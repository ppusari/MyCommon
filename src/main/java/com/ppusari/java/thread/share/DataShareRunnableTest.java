package com.ppusari.java.thread.share;

public class DataShareRunnableTest {
	public static void main(String[] args) {
	
		DataShareRunnableRunnable r = new DataShareRunnableRunnable();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class DataShareRunnableRunnable implements Runnable{

	int iv = 0; // 전역변수는 쓰레드간에 데이터를 공유할 수 있게 된다.( 중요: Runnable은 전역변수로
	
	@Override
	public void run() {
		
		int lv = 0;	// 지역변수는 쓰레드간에 데이터를 공유할 수 없다.
		String name = Thread.currentThread().getName();
		
		while (lv <3){
			System.out.println(name + "Local Var: " + ++lv);
			System.out.println(name + "Instance Var: " + ++iv);
			System.out.println();
		}
	}
}
