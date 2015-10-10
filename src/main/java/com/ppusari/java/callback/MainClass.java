package com.ppusari.java.callback;

public class MainClass {
	public static void main(String[] args) {
		
		// 콜백 수신
		CallbackEvent callbackEvent = new CallbackEvent() {
			
			@Override
			public void callbackMethod() {
				System.out.println("returned callback message");				
			}
		};
		
		// 시작.
		EventRegistration eventRegistration = new EventRegistration(callbackEvent);
		eventRegistration.doWork();
	}

}
