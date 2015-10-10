package com.ppusari.java.etc.xroshot.xroshot.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlParsing {
	
	String ip;
	int port;
	String serverTime;
	int login = -1;
	int smsResult = -1;

	// String to xml
	private Document loadXML(String xml){	
		Document doc = null;		
		try {
		   DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
		   DocumentBuilder bldr = fctr.newDocumentBuilder();
		   InputSource insrc = new InputSource(new StringReader(xml));
		   doc =  bldr.parse(insrc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public String getMethodName(String xml) {
		Document doc = loadXML(xml);
		NodeList list = doc.getElementsByTagName("MAS");
		return list.item(0).getAttributes().getNamedItem("method").getNodeValue();
	}
	
	public boolean serverInfo(String url) /*throws SAXException, IOException, ParserConfigurationException*/ {
		try {
			this.ip = "";
			this.port = 0;		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);
			NodeList list = doc.getElementsByTagName("Result");		
			
			if (list.getLength() > 0){			
				String result = list.item(0).getTextContent();						
				if (result.equals("0")){
					list = doc.getElementsByTagName("Resource");				
					for(int i=0; i<list.getLength(); i++){
						for (Node node = list.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){
							if (node.getNodeName().equals("Address")){
								this.ip = node.getTextContent();
							}
							else if (node.getNodeName().equals("Port")){
								this.port = Integer.parseInt(node.getTextContent());
							}
						}
					}				  
				}
				else{
					System.out.println("Server request fail..");
				}
			}
		} catch (ParserConfigurationException e) {			
			e.printStackTrace();
		} catch(SAXException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return this.ip.isEmpty() ? false : true;
	}
		
	public boolean serverTime(String xml) throws SAXException, IOException, ParserConfigurationException {
		this.serverTime = ""; 		
		Document doc = loadXML(xml);
		NodeList list = doc.getElementsByTagName("Result");
		if (list.getLength() > 0){				
			String result = list.item(0).getTextContent();						
			if (result.equals("0")){  // <Result>0</Result> check.				
				list = doc.getElementsByTagName("Time"); 
				if (list.getLength() > 0){
					this.serverTime = list.item(0).getTextContent(); 
				}				
			}						
		}
		 
		return serverTime.isEmpty() ? false : true;
	}
	
	public void logIn(String xml){
		Document doc = loadXML(xml);
		NodeList list = doc.getElementsByTagName("Result");
		if (list.getLength() > 0){				
			String result = list.item(0).getTextContent();
			login = Integer.parseInt(result);
		}
	} 
	
	public void logOut(String xml){
		Document doc = loadXML(xml);
		NodeList list = doc.getElementsByTagName("Result");
		if (list.getLength() > 0){				
			String result = list.item(0).getTextContent();
			login = Integer.parseInt(result);
		}
	}
	
	public void smsResponse(String xml){
		Document doc = loadXML(xml);
		NodeList list = doc.getElementsByTagName("Result");
		if (list.getLength() > 0){				
			String result = list.item(0).getTextContent();
			smsResult = Integer.parseInt(result);			
		}
	}	
	
	// Getters..
	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getServerTime() {
		return serverTime;
	}
	
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	public int getLogin() {
		return login;
	}
	
	public void setLogin(int login){
		this.login = login;
	}

}