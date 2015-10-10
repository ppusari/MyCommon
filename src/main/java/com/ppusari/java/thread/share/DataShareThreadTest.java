package com.ppusari.java.thread.share;

public class DataShareThreadTest {
	public static void main(String[] args) {
		
		Data d = new Data();
		new DataShareThread(d).start();
		new DataShareThread(d).start(); 		
	}
}

class Data {
	int iv = 0;
}

class DataShareThread extends Thread {
	
	Data d;
	
	public DataShareThread(Data d) {
		this.d = d;
	}
	
	public void run(){
		
		int lv = 0;
		
		while (lv <3){
			System.out.println(getName() + "Local Var: " + ++lv);
			System.out.println(getName() + "Instance Var: " + ++d.iv);
			System.out.println();
		}		
	}
}
