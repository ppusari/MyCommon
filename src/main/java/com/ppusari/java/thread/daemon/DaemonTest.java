package com.ppusari.java.thread.daemon;

public class DaemonTest {
 
	public static void main(String[] args) 
	{
		// 데몬 스레드란? 부모 스레드가 죽으면 자식 스레드도 죽도록 만드는것.
		// setDaemon(true)를 주석하면 차이점을 알 수 있다.
		
		AutoSaveThread thread  = new AutoSaveThread();
		thread.setDaemon(true);	// 반드시 start() 위에 있어야 한다.
		thread.start();
 					
		for (int i=0; i<5; i++) {
			try {Thread.sleep(500);} catch (Exception e){}
			System.out.println(i);  
		}
		
		if (thread.isDaemon())
			System.out.println("데몬스레드 라서 자동으로 자식 스레드가 종료된다.");
		else
			System.out.println("데몬스레드가 아니라서 부모가 죽어도 자식이 종료되지 않는다.");
			
		System.out.println("프로그램 종료!");
	}
}

// 무한으로 3초마다 저장 하는 스레드 
class AutoSaveThread extends Thread {
	
	public void run() {
		
		int n = 0;
		while (true) {
			try { Thread.sleep(3*500);} catch (Exception e) {}
			
			System.out.println("자동 저장 완료!");
			if (n++ > 3) break;						
		}

	 	//while 문에 종료 조건이 있어야  다음 코드들을 사용할 수 잇다. 
		System.out.println("데몬 쓰레드로 종료하면 이 부분을 출력하지 않고 끝난다.");
	} 
}  