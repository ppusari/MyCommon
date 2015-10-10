package com.ppusari.java.exception;

import java.beans.Expression;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;

//336쪽 참고.
// throw를 발생시키는 상위 클래스를 만들어서 try를 묶지 않고 해보자.

class MyException extends Exception {
	
	private final int ERR_CODE;
	
	public MyException(String msg) {
		//super(msg);
		this(msg, 100);	// 간접적인 에러코드 삽입방법
	}
	
	public MyException(String msg, int errCode) {
		super(msg);
		ERR_CODE = errCode;
	}
	
	public int getErrCode() {
		return ERR_CODE; 
	}
}

public class ExceptionTest {	
 
	public static void sub() throws Exception { // throws 를 던지면 사용하는 sub에서는 반드시 try로 묶여 있어야함.
		
		try {
			throw new MyException("사용자 정의 예외 발생~", 222);			
		} catch (MyException e) {
			System.out.println(e.getErrCode());
		}
		
		PrintStream printStream = null;
		
		try
		{
			//return; // 강제 리턴뭉을 만나도 finally을 실행한다.
			printStream = new PrintStream("error.log");			
			throw new Exception("서브 메소드 예외 발생!");
		}
		catch (Exception e)
		{
			e.printStackTrace();			// 인수가 없으면 화면에 출력		
			e.printStackTrace(printStream);	// PrintStream 객체를 넘겨주면 파일에 출력.
			printStream.println("서브 메소드 예외 발생:" + e.toString());
			throw e;
		}
		finally{
			System.out.println("SUB 종료!!!");
		}
	}
	
	public static void sub2() {
		PrintStream printStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("error2.lob", true);
			printStream = new PrintStream(fileOutputStream);
			System.setErr(printStream);
			
			throw new Exception("서브2 메소드 예외 발생!!");			
		} catch (Exception e) {
			System.err.println("-----------------------------------------");
			System.err.println("예외 발생시간:" + new Date());
			e.printStackTrace(System.err);
			System.err.println("예외메시지:" + e.getMessage());
			System.err.println("-----------------------------------------");
		}
	}
	
	public static void sub3() throws ArithmeticException, NullPointerException {
		throw new ArithmeticException(); // 수학적인 예외 발생!		
	}
		
	public static void main(String[] args){
	
		try {
			sub3();
		}
		catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
		
		sub2();		
		
		try {
			sub(); // 이 함수는 throws 로 했기때문에 try로 묶여 있어야함. try를 묶지 않고 사용하려면?
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
			 		
		Random rand = new Random();	
		
		try {
			try {
				int value = 10/0;
				
			} catch ( Exception e) {
				System.out.println(e.toString());				
			}			
			
			for (int i=0; i<10; i++) {
				int result = 100/ (rand.nextInt(5)+1); // 0~4
				System.out.println(i + ": " + result);				
			}		
			
			// 고의로 에러 발생!
			Exception exception = new Exception("이것은 고의로 발생한 에러입니다.");
			throw(exception); 
		}
		catch ( ArithmeticException ae) {
			System.out.println("ArithmeticExption: " + ae.toString());
		}
		catch (NullPointerException nullE) {			
		}
		catch (ClassCastException classE) {			
		}
		catch ( Exception exception) {			
			System.out.println(exception.toString());
			
			try {	
				throw(exception);				
			} catch ( Exception e) {
				System.out.println("!!!!"+ e.toString());
				System.out.println("!!!!"+ e.getMessage());
				e.printStackTrace();
			}
		}
		finally {			
			System.out.println("정상종료!!");	
		}
		
		System.out.println("Complete!");	
	}
}
