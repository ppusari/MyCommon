package com.ppusari.java.thread.priorities;

public class PrioritiesTest {
	
	public static void main(String[] args) {
		
		Runnable r = new MyThread1();
		Thread t = new Thread(r);
				
		Runnable r2 = new MyThread2();
		Thread t2 = new Thread(r2);
		
		t.setPriority(10);	// 우선순위를 입력 1~ 10까지
		t.start();
		t2.start();
	}
}

class MyThread1 implements Runnable{
	
	public void run(){
		
		for (int i=0; i<10; i++){
			System.out.print("-");
			
			for(int x=0; x<100000000; x++);
		}			
	}
}

class MyThread2 implements Runnable{
	
	public void run(){
		for (int i=0; i<10; i++){
			System.out.print("|");
			
			for(int x=0; x<100000000; x++);
		}	
	}
}