package com.ppusari.java.thread.control;

public class JoinTest {
	public static void main(String[] args) {
		
		// TIP: 두 쓰레드가 번갈아 가며 실행되지 않고 순차적으로 실행해야할 때 join()을 사용.
		
		Thread t = new Thread(new MyThread());
		t.start();
		
		try {
			t.join();	// 스레드가 종료될 때 까지 기다렸다가 통과한다.
//			t.join(2000); // 지정한 시간만큼 기다린 후 통과한다.
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		System.out.println("main 함수 종료");
	}
}

class MyThread implements Runnable {	
	public void run() {
		for (int i=0; i<10; i++){
			try {Thread.sleep(500);} catch (Exception e){}
			System.out.println(i+1);
		}
	}
}
