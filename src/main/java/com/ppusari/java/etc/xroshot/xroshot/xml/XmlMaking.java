package com.ppusari.java.etc.xroshot.xroshot.xml;

import java.util.ArrayList;

import com.ppusari.java.etc.xroshot.xroshot.auth.AuthKey;
import com.ppusari.java.etc.xroshot.xroshot.auth.MCSAuth;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
 
public class XmlMaking {
	
	//private static final Logger logger = LoggerFactory.getLogger(XmlMaking.class);
	
	AuthKey authKey = null;
	MCSAuth mcsAuth = null;
	String authKeyValue = "";
	int authKeyIndex = -1;
	String oneTimeKeyValue = "";
	
	public XmlMaking() {
		
		this.mcsAuth = new MCSAuth();		
		this.authKey = new AuthKey();
		this.authKeyValue = this.authKey.getAuthKey();
		this.authKeyIndex = this.authKey.getIndex();
	}	

	public String getServerTime(String id){		 
		String serverTimeRequest = "<?xml version='1.0' encoding='UTF-8'?>\r"
								 + "  <MAS method='req_auth'>\r"
								 + "  <ServiceProviderID>" + id + "</ServiceProviderID>\r"
								 + "</MAS>\0";				
				
		return serverTimeRequest.replace("'", "\"");
	}
	
	public String getRequestLoginXml(String id, String pw, String endUserID, String serverTime, String oneTimeKey){
		
		String authTicket = this.authKey.makeAuthTicket(id, pw, endUserID, serverTime, oneTimeKey);		
		String encodedAuthTicket = mcsAuth.makeCryptograph(authTicket, this.authKeyValue);
		this.oneTimeKeyValue = oneTimeKey;
	
		{// Just log
			String login = "<?xml version='1.0' encoding='UTF-8'?>\r"
					 + "<MAS method='req_regist'>\r"
					 + "  <ServiceProviderID>" + id + "</ServiceProviderID>\r"
					 + "  <EndUserID>" + endUserID + "</EndUserID>\r"
					 + "  <AuthTicket>"  + authTicket + "</AuthTicket>\r"								
					 + "  <AuthKey>" + Integer.toString(authKeyIndex) + "</AuthKey>\r"
					 + "  <Version>1.0.15</Version>\r"
					 + "</MAS>\0";			
			System.out.println("login request------------------------------\n"+ login);
		}
		
		String login = "<?xml version='1.0' encoding='UTF-8'?>\r"
					 + "<MAS method='req_regist'>\r"
					 + "  <ServiceProviderID>" + id + "</ServiceProviderID>\r"
					 + "  <EndUserID>" + endUserID + "</EndUserID>\r"
					 + "  <AuthTicket>"  + encodedAuthTicket + "</AuthTicket>\r"								
					 + "  <AuthKey>" + Integer.toString(authKeyIndex) + "</AuthKey>\r"
					 + "  <Version>1.0.15</Version>\r"
					 + "</MAS>\0";
		
		return login.replace("'", "\"");					
	} 
	
	public String getSms(String callbackNumber, String customMessageID, ArrayList<String> receiveNumbers, String subject, String content){		
		{ // Just log			
			String receiveNumber = "";
			for (int i=0; i<receiveNumbers.size(); i++){
				receiveNumber += "    <ReceiveNumber seqNo='" + (i+1) + "'>" + receiveNumbers.get(i) + "</ReceiveNumber>\r";		
			}		
			
			String sms =  "<?xml version='1.0' encoding='UTF-8'?>\r"
						+ "<MAS method='req_send_message_2'>\r"
						+ "  <MessageType>1</MessageType>\r"
						+ "  <MessageSubType>1</MessageSubType>\r"
						+ "  <CallbackNumber>" + callbackNumber +  "</CallbackNumber>\r"
						+ "  <CustomMessageID>" + customMessageID + "</CustomMessageID>\r"
						+ "  <Message>\r"
						+ 		receiveNumber 
						+ "    <Subject>" + subject + "</Subject>\r"
						+ "    <Content>" + content + "</Content>\r"
						+ "  </Message>\r"
						+ "</MAS>\0";			
			System.out.println("MSM transport request------------------------------\n"+ sms);
		}
		
		String eCallbackNumber = mcsAuth.makeCryptograph(callbackNumber, this.oneTimeKeyValue);
		String eContent = mcsAuth.makeCryptograph_EUC_KR(content, this.oneTimeKeyValue);
				
		String receiveNumber = "";
		for (int i=0; i<receiveNumbers.size(); i++){
			String phoneNumber = receiveNumbers.get(i);
			String ePhoneNumber = mcsAuth.makeCryptograph(phoneNumber, this.oneTimeKeyValue);
			receiveNumber += "    <ReceiveNumber seqNo='" + (i+1) + "'>" + ePhoneNumber + "</ReceiveNumber>\r";		
		}
		 		
		String sms =  "<?xml version='1.0' encoding='UTF-8'?>\r"
					+ "<MAS method='req_send_message_2'>\r"
					+ "  <MessageType>1</MessageType>\r"
					+ "  <MessageSubType>1</MessageSubType>\r"
					+ "  <CallbackNumber>" + eCallbackNumber +  "</CallbackNumber>\r"
					+ "  <CustomMessageID>" + customMessageID + "</CustomMessageID>\r"
					+ "  <Message>\r"
					+ 		receiveNumber 
					+ "    <Subject>" + subject + "</Subject>\r"
					+ "    <Content>" + eContent + "</Content>\r"
					+ "  </Message>\r"
					+ "</MAS>\0";
		
		return sms.replace("'", "\"");
	}
	
	public String getAlive(){
		String alive = "<?xml version='1.0' encoding='UTF-8'?>\r"
					 + "<MAS method='req_ping'>\r"
					 + "  <Result>0</Result>\r"
					 + "</MAS>\0";
		
		return alive.replace("'", "\"");
	}
	
	public String getLogOut(){
		String logOut = "<?xml version='1.0' encoding='UTF-8'?>\r"
				 + "<MAS method='req_unregist'>\r"
				 + "  <Result>0</Result>\r"
				 + "</MAS>\0";
	
		return logOut.replace("'", "\"");
	} 
}