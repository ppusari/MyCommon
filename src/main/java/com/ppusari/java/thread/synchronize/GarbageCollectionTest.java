package com.ppusari.java.thread.synchronize;

public class GarbageCollectionTest
{	
	public static void main (String[] args) 
	{
		MyGc gcThread = new MyGc();
		gcThread.setDaemon(true);
		gcThread.start();
		
	//	int requiredMemory = 0;
		
		for (int i=0; i<20; i++) 
		{	
			//try { Thread.sleep(1000); } catch (Exception e) {}
			
			int requiredMemory = (int)(Math.random() * 10) * 20; // random 스태틱 이기 때문에 이태릭으로 된다.
			
			if (gcThread.freeMemory() > requiredMemory) {
				gcThread.interrupt();
				
				try {
					gcThread.join(100);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
				gcThread.usedMemory += requiredMemory;
				System.out.println("usedMemory: " + gcThread.usedMemory);
			}
		}
	}
}

class MyGc extends Thread  {
	
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while (true) {			
			try { 
				Thread.sleep(1000*10); // Sleep() 을 사용할 때 Thread를 빼도 되지만 Thread를 상속 받았기 때문에 제거해도 사용할 수 있음. 
			} catch (InterruptedException e){
				//e.printStackTrace();				
			}
			
			gc();
			System.out.println("Free Memory:" + freeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if (usedMemory < 0) 
			usedMemory = 0;		
	}
	
	public int freeMemory() {
		return MAX_MEMORY - usedMemory;		
	}
	
	public int totalMemorty() { 
		return MAX_MEMORY; 
	}
	
}
