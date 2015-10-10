package com.ppusari.java.thread.group;

public class GroupTest {
	public static void main(String[] args) {
		
		// 기본 스레드 구룹 가져오기.
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup threadGroup1 = new ThreadGroup("Group1");
		ThreadGroup threadGroup2 = new ThreadGroup("Group2");
		
		ThreadGroup subThreadGroup1 = new ThreadGroup(threadGroup1, "SubGroup1");
		
		threadGroup1.setMaxPriority(3);
		
		Thread thread1 = new Thread(threadGroup1, "thread1");
		Thread thread2 = new Thread(subThreadGroup1, "thread2");
		Thread thread3 = new Thread(threadGroup2, "thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		main.list(); // 
		
		System.out.println("Active Thread Group:" + main.activeGroupCount());
		System.out.println("Active Thread:" + main.activeCount());
		
		// 구릅으로 관리하면 한번에 종료할 수 있다.		
	}
}
