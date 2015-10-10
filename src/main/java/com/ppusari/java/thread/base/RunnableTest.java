package com.ppusari.java.thread.base;

import javax.swing.JOptionPane;

public class RunnableTest {
 
	public static void main(String[] args) {
		
		MyThreadRunnable r = new MyThreadRunnable();
		Thread t = new Thread(r,"스레드명1");	// 스레드 이름을 입력할 수 있다.
		t.setName("스레드명2");
		t.start();
				
		new Thread(new MyThreadRunnable()).start();	// 스레드명을 입력하지 않으면 뒤에 숫자가 붙는다.
		
		String input = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
	}
}


class MyThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}	 
}
