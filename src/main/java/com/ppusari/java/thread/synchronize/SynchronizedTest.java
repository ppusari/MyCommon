package com.ppusari.java.thread.synchronize;

public class SynchronizedTest {
	
	public static void main(String[] args) {

		Runnable r = new AccountThread();
		new Thread(r).start();
		new Thread(r).start();		
	}
}

class Account {
	private int balance = 1000;
	
	// synchronized 을 추가하면 락을 걸수 있는 메소드가 됨.
	public synchronized void withdraw(int money){

//		synchronized (this) {  함수에 synchronized을 추가하지 않고 이렇게 synchronized블록으로 묶어서 처리해도 동일하다. 			
			while (balance < money) {
				try {
					System.out.println(Thread.currentThread().getName() + " WAIT");
					wait();					
				} catch(Exception e) {}			
			}
			
			balance -=money;
//		}
	}
	
	// synchronized 을 추가하면 락을 걸수 있는 메소드가 됨.
	public synchronized void deposit(int money) {
		balance += money;
		notify(); 
		System.out.println(Thread.currentThread().getName() + " NOTIFY");
	}
	
	public synchronized int getBalance() { return this.balance; }
}


class AccountThread implements Runnable {
	
	Account account = new Account();
	
	public void run(){ 
		
		while (account.getBalance() > 0) {
			
			int money = (int)(Math.random()*3+1)*100;	// 인출할 금액을 렌덤으로 초이스 되도록
			
			if (Math.random() < 0.5)
				account.withdraw(money);
			else
				account.deposit(money);
			
			System.out.println(Thread.currentThread().getName() + "balance: " + account.getBalance());
		}		
	}
}