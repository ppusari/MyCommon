package com.ppusari.java.type.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	public static void main(String[] args) {
	
		calendarInit();		// 초기화 방법 
		totalLiving();		// 내가 살아온 날
		dateToCalendar();	// date와 calendar와 변환
		outputDateTime();		// 해당 년, 월, 일, 요일, 오전/오후 출력
		daySetting();
		
    
       
	}
	
	// 초기화 방법 
	public static void calendarInit(){
		 
		
        Calendar cal = new GregorianCalendar(1981, 12-1, 25);
        System.out.printf("setting day: %s\n", cal.getTime().toString());
	
        Calendar cal2 = Calendar.getInstance();
        System.out.printf("today: %s\n", cal2.getTime().toString());
	}

	// 내가 살아온 날
	public static void totalLiving(){		 
        Calendar cal1 = new GregorianCalendar(1981, 12-1, 25);
        Calendar cal2 = Calendar.getInstance();
 
        long cha = cal2.getTimeInMillis() - cal1.getTimeInMillis(); 
        cha = cha / 1000; // 밀리세컨드 이므로 1000을 나눠서 초단위로 변경해야함
        cha = cha / 86400;// 하루는 86400초이므로 나누어준다.
        System.out.printf("살아온 일 수  : %d\n", cha); // 살아온 일수가 나온다.	 
	}
	
	// date와 calendar와 변환
	public static void dateToCalendar(){
	    
		Date date = new Date();		
		Calendar cal = Calendar.getInstance();
		
        cal.setTime(date);
        System.out.printf("Date to Calendar :%s \n", cal.getTime().toString()); 
	}
		
	// 해당 년, 월, 일, 요일, 오전/오후 출력
	public static void outputDateTime(){
		
		// 요일 출력
		int week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK); // 일요일=1, 월요일=2			
		String weeks[] = {"일","월","화","수","목","금","토"};
		System.out.println("오늘은 " + weeks[week-1] + "요일 입니다.");
		
		// 20151006 년월일 8자리 출력
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH)-1;	// 0부터 시작하니 -1은 필수
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
 		String today = String.format("%04d%02d%02d", year, month, day);
		System.out.println("today: " + today);
		
		// 오전오후 출력
		String am_pm = (Calendar.getInstance().get(Calendar.AM_PM) == 0) ? "AM" : "PM";		
		System.out.println("지금은 " +  am_pm + " 입니다."); 
	}
	
	public static void daySetting(){
		
		Calendar startDay = Calendar.getInstance();
		startDay.set(1981, 11-1, 20, 0, 0, 0);
		 
		Calendar endDay = Calendar.getInstance();
		endDay.set(1981, 12-1, 26, 0, 0, 0);
 
		long sec = (endDay.getTimeInMillis() - startDay.getTimeInMillis()) / 1000;
		int day = (int)(sec / (60 *60 * 24));
 		System.out.println("날짜의 차이: " + day);
	}
}
