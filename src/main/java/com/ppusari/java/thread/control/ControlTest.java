package com.ppusari.java.thread.control;

public class ControlTest {
	public static void main(String[] args) {
		MyThread2 t = new MyThread2("*");
		t.start();
		
		try {
			Thread.sleep(1000*2);	// 2초 멈춰 있는동안 자식 쓰레드는 일한다.
			t.suspend();			// 다른 쓰레드에 양보함 마치 자신의 쓰레드는 멈춰있는 듯한 효과를 줌
			Thread.sleep(1);
			t.resume(); 			// 스레드 재가동효과를 줌
			Thread.sleep(1000*2);
			t.stop(); 				// 스레드를 종료시킬 때 즉각 종료시킨다. 
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

class MyThread2 implements Runnable {
	
	Thread t;
	boolean stoped = false;
	boolean suspended = false;
	
	
	public MyThread2(String name) {
		t = new Thread(this, name);
	}					
	
	public void run() {
		
		System.out.println("자기 자신의 쓰레드 이름: " + Thread.currentThread().getName());
		
		while(!stoped){			
			if (!suspended){
				System.out.println("*");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {					
					System.out.println("interrupt 에 의해 즉각 빠져나옴");
				}				
			}
			else{
				Thread.yield();
				System.out.println("다른 쓰레드에 양보한다.");
			}
		}		
		
		System.out.println("스레드 종료");
	}
	
	public void start(){
		t.start();
	}
	
	public void suspend(){
		suspended = true;
		t.interrupt();
	}
	
	public void resume(){
		suspended = false;		
	}
	
	public void stop(){
		stoped = true;
		t.interrupt(); // Sleep() 이나 Join() 함수 때문에 멈춰있는 상태를 즉각 빠져 나오게 해줌. 
	}
}