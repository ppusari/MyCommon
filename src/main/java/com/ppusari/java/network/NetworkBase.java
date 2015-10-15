package com.ppusari.java.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkBase {
	
	public static void main(String[] args) {
		
		getIp(); // 로컬컴퓨터 이름과 아이피 얻기.
		
	}
	
	public static void getIp(){
		
		// 원도우 방식
		try {
			InetAddress Address = InetAddress.getLocalHost();
			System.out.println("로컬 컴퓨터의 이름 : "+Address.getHostName());
			System.out.println("로컬 컴퓨터의 IP 주소 : "+Address.getHostAddress());
			Address = InetAddress.getByName("java.sun.com");
			System.out.println("java.sun.com 컴퓨터의 이름과 IP 주소 : "+Address);
			InetAddress SW[] = InetAddress.getAllByName("www.hollywood.com");		
		} catch (Exception e) {			
		}
		
		
		// 리룩스 방식
		try {
			Enumeration<NetworkInterface> nienum = NetworkInterface.getNetworkInterfaces();
			
	        while (nienum.hasMoreElements()) {
	            NetworkInterface ni = nienum.nextElement();
	            Enumeration<InetAddress> kk = ni.getInetAddresses();
	            
	            while (kk.hasMoreElements()) {
	    			InetAddress inetAddress = (InetAddress) kk.nextElement();
	    			System.out.println(inetAddress.getHostName()+" : "+inetAddress.getHostAddress());
	            }
	        }
			
		} catch (Exception e) {			
		}
		
	}

}
