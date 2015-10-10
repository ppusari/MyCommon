package com.ppusari.java.thread.base;

//Thread를 상속받아 사용할 경우
public class ExtendsTest {
	public static void main(String[] args) {
				
		howToCreate();
		threadNameSetting();
		deprecated();
	 		
		// TIP: main 스레드가  죽어도 그전에 생성한 thread는 살아있다.
	}
	
	static void howToCreate(){

		// 생성방법1
		new Thread(new MyThread()).start();

		// 생성방법2
		Thread t = new Thread(new MyThread());
		t.start();
		
		// 생성방법3
		MyThread myThread = new MyThread();		
		myThread.start();
		
		// 생성방법4
		myThread.start();  // 한번 사용된 쓰레드는 두번 start() 할 수 없고 아래처럼 또 초기화 해서 사용해야한다.
		MyThread myThread2 = new MyThread();
		myThread2.start();
	}
	
	static void threadNameSetting(){
		
		// 스레드 명을 설정한다.
		MyThread myThread = new MyThread();
		myThread.setName("MyThread 스레드");
		myThread.start();
	}
	
	static void deprecated(){
 
		MyThread myThread = new MyThread();		
		myThread.start();
				
		try {
			myThread.sleep(1000*10);	// 쓰레드 의 Sleep이 멈추는게 아니고 현재 실행중인 쓰레드(main)가 멈춘다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 교착 상태에 빠질 수 있어 아래 3함수는 deprecated 되었다.
		myThread.suspend();
		myThread.resume();		
		myThread.stop(); 
	}
}

class MyThread extends Thread {
	
	public void run(){		
		System.out.println(getName());  // 스레드 명을 출력한다. (입력하지 않으면 기본값 출력)
	}
}
