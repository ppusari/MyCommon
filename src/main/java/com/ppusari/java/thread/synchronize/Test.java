package com.ppusari.java.thread.synchronize;

public class Test {
	public static void main(String[] args) {
		
		// 미완성코드.
		// 아래 두 클래스가 번갈아 가면서 출력되도록 수정 해야함.   Ex) |-|-|-|-|-|-|-|-|-  	
		Data d = new Data();
		d.t1 = new MyThread1(d);
		d.t2 = new MyThread2(d);
		
		Thread t1 = new Thread(d.t1);
		Thread t2 = new Thread(d.t2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
	}
}

class Data {
	public boolean chk = true;
	MyThread1 t1;
	MyThread2 t2;
}

class MyThread1 implements Runnable {

	Data d;
	
	public MyThread1(Data d) {
		this.d = d;	
	}
	
	@Override
	public synchronized void run() {
		for (int i=0; i<10; i++){
			System.out.print("|");
 
			d.t2.notify();
			
			try {
				wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			} 
		}		
	}	
}

class MyThread2 implements Runnable {

	Data d;
	
	public MyThread2(Data d) {
		this.d = d;	
	}
	
	@Override
	public synchronized void run() {
		for (int i=0; i<10; i++){
			System.out.print("-");
			 
			
			d.t1.notify();
			try {
				wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
			
		}		
	}	
}
