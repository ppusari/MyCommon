package com.ppusari.java.etc.xroshot.xroshot;

import java.util.ArrayList;

import com.ppusari.java.etc.xroshot.xroshot.socket.ReceiveEvent;
import com.ppusari.java.etc.xroshot.xroshot.socket.TcpSocket;
import com.ppusari.java.etc.xroshot.xroshot.xml.XmlMaking;
import com.ppusari.java.etc.xroshot.xroshot.xml.XmlParsing;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
 
public class Xcroshot {
		
//	private static final Logger logger = LoggerFactory.getLogger(Xcroshot.class);
	
	private final String ID = "saup1happyon";
	private final String PW = "happyon0401!";
	private final String END_USER_ID = ID;		
	private final String ONE_TIME_KEY = "myOneTimeKeyisMobileleader";
	private final String MCS_URL = "http://rcs2.xroshot.com/catalogs/MAS/recommended/0";
	
	XmlMaking xmlMaking = null;
	XmlParsing xmlParsing = null;
	TcpSocket socket = null;
	ReceiveEvent event = null;
  	
	public boolean send(String sender, ArrayList<String> receivers, String msg){		
		boolean ret = false; 
		connect();				
		sendSMS(sender, receivers, msg);				
		return ret;
	}
 	
	public void connect(){		
		
		this.socket = new TcpSocket();
		this.xmlParsing = new XmlParsing();
		this.xmlMaking = new XmlMaking();
		
		receive();	
		 			
		// 최적의 MCS서버 찾기
		xmlParsing.serverInfo(MCS_URL);	
		
		// MCS서버에 TCP접속
		if (socket.connect("210.105.195.151", xmlParsing.getPort(), event)){
//		if (socket.connect(xmlParsing.getIp(), xmlParsing.getPort(), event)){			
//			logger.info("connected at MCS server " + xmlParsing.getIp() + ":" + xmlParsing.getPort());
			System.out.println("connected at MCS server " + xmlParsing.getIp() + ":" + xmlParsing.getPort());
						
			// 서버시간 동기화값 얻기
			String serverTimeXml = xmlMaking.getServerTime(ID);			
			System.out.println("server time request------------------------------\n"+ serverTimeXml);						
			socket.send(serverTimeXml);
		}			
	}
	 
	private void receive() {		
		event = new ReceiveEvent() {
				
			@Override
			public synchronized void Receive(String xml) { 				
				try {
					String methodName = xmlParsing.getMethodName(xml);
					if (methodName.equals("res_auth")){	// 서버시간 응답
						System.out.println("server time response------------------------------\n"+ xml);
						xmlParsing.serverTime(xml);	// 서비시간 파싱 후 결과 값 저장.
						logIn();
					}
					else if (methodName.equals("res_regist")){// 로그인 응답
						System.out.println("login response------------------------------\n"+ xml);
						xmlParsing.logIn(xml);
					}
					else if (methodName.equals("res_unregist")){// 로그아웃 응답						
						System.out.println("logout response------------------------------\n"+ xml);
						xmlParsing.logOut(xml);
						socket.close();					
					}
					else if (methodName.equals("res_send_message_all")){// SMS단건 응답
						System.out.println("SMS short response------------------------------\n"+ xml);
						xmlParsing.smsResponse(xml);
					}
					else if (methodName.equals("req_report")){ // SMS단건 응답						
						System.out.println("SMS transport response------------------------------\n"+ xml);
					}
					else if (methodName.equals("res_ping")){// Alive 체크 응답						
						System.out.println("Ping response------------------------------\n"+ xml);
					} 	
					else {						
						System.out.println("etc response------------------------------\n"+ xml);
					}				
						
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		};		
	}

	public void logIn() { 
		String loginXml = xmlMaking.getRequestLoginXml(ID, PW, END_USER_ID, xmlParsing.getServerTime(), ONE_TIME_KEY);		
		socket.send(loginXml);
	}
 	
	public void sendSMS(String sender, ArrayList<String> receivers, String msg) {		
		
		int cnt = 10;
		while (true){
			if (xmlParsing.getLogin() == 0) {
				String sms = xmlMaking.getSms(sender, "1234", receivers, "title", msg);
				socket.send(sms);
				break;
			}
			else{
				try {
					Thread.sleep(100);
					if (cnt-- <= 0){
						System.out.println("SMS transport 10 time fail");
						break;					
					}
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		}
	}

	public void logOut() {
		String xml = xmlMaking.getLogOut();
		System.out.println("logout request------------------------------\n"+ xml);
		socket.send(xml); 	
	} 
}