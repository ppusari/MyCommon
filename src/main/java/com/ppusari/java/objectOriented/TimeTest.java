package com.ppusari.java.objectOriented;
class Time extends Object {
	int hour;	// 명시하지 않으면 public 임.
	private int minute;
	private int second;
	
	// 상수 입력 방법.
	public static final int HOUR = 0;
	public final int MINUTE = 2;
	
	
	Time()
	{
		// 생성자에서 다른 생성자를 호출한다.
		this(0,0,0);
		
	//	this.MINUTE = 5;
	}
	
	Time(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;				
	}
			
	int getHour() { return this.hour; }
	int getMinute() { return this.minute; }
	int getSecond() { return this.second; }
	 
	void setHour(int hour) 
	{
		if (hour > 0 && hour < 25)
			this.hour = hour; 
	}
	
	void setMinute(int minute) 
	{
		if (minute > 0 && minute < 60)
			this.minute = minute; 
	}
	
	void setSecond(int second) 
	{
		if (second > 0 && second < 60)
			this.second = second; 
	}	
	
}


public class TimeTest {
	public static void main(String[] args)
	{
		Time time = new Time(); 
		time.setHour(4);
		
		// 클래스 배열은 아래와 같이 초기화를 해줘야 한다.
		Time[] timeArray = new Time[10];
		for (int i=0; i<timeArray.length; i++)
		{
			timeArray[i] = new Time();
		}
		
		
		// 클래스 인스던트나 배열 포인터를 함수로 넘길때는 포인터 개념으로 넘어간다.
		
		// 명시적인 소멸방법.		
		timeArray = null;
			
		time.hour = 23;
		
		time.hour = 23;
		
	}

}
