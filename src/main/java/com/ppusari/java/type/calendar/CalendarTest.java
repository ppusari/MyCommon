package com.ppusari.java.type.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	public static void main(String[] args) {
	
		calendarInit();		// 초기화 방법 
		totalLiving();		// 내가 살아온 날
		dateToCalendar();	// date와 calendar와 변환
		outputDateTime();	// 해당 년, 월, 일, 요일, 오전/오후 출력
		daySetting();		// 설정시간 입력
		stringToCalender();	// 문자 를 달력으로 변경
		stringToCalender2();// 문자 를 달력으로 변경2
		calToString();		// 날짜를 스트링으로 출력
		priod1();			// 해당 기간 안에 이벤트 발생 
       
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
		
	// 설정시간 입력
	public static void daySetting(){
		
		Calendar startDay = Calendar.getInstance();
		startDay.set(1981, 11-1, 20, 0, 0, 0);
		 
		Calendar endDay = Calendar.getInstance();
		endDay.set(1981, 12-1, 26, 0, 0, 0);
 
		long sec = (endDay.getTimeInMillis() - startDay.getTimeInMillis()) / 1000;
		int day = (int)(sec / (60 *60 * 24));
 		System.out.println("날짜의 차이: " + day);
	}
	
	// String to Calendar
	public static void stringToCalender(){
	
		String str = "2015-08-01";
		
		Date date = null;		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			date = dateFormat.parse(str);
		} catch (ParseException e) {
		} 
	}
	
	// String to Calendar2	
	public static void stringToCalender2(){
		
		String value = "2015-10-14T00:00:00-0000";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
		Calendar calendar = Calendar.getInstance();
		
		try {
			calendar.setTime(dateFormat.parse(value));
			System.out.println("success");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	}
	
	// 날짜를 스트링으로 출력
	public static void calToString(){
		Calendar today = Calendar.getInstance();		
		System.out.println(today.getTime().toString());
	}
	
	// 해당 기간 안에 이벤트 발생
	public static void priod1(){
		
		// 아래 코드가 여러번 돌아야 진정한 예제가 된다.
		int nowWinningCnt = 0;
		
		// 서비스 시작날짜
		Calendar startDay = Calendar.getInstance();
		startDay.set(2015, 7-1, 22, 00, 00, 00); 	
		 		
		// 오늘날짜
		Calendar today = Calendar.getInstance();	 	
   	 
		// 1단계 기간 
		Calendar cal1_s = Calendar.getInstance();
		cal1_s.set(2015, 7-1, 23, 11, 31, 1);					
		Calendar cal1_e = Calendar.getInstance();
		cal1_e.set(2015, 7-1, 23, 11, 32, 0);			
		 
		// 2단계 기간 
		Calendar cal2_s = Calendar.getInstance();
		cal2_s.set(2015, 7-1, 23, 11, 32, 1);					
		Calendar cal2_e = Calendar.getInstance();
		cal2_e.set(2015, 7-1, 23, 11, 33, 0);			
		
		// 각 단계에서 당첨되어야할 개수
		int totalWinningCnt_1 = 7; 
		int totalWinningCnt_2 = 3; 
		
		if (today.before(cal1_s)){
			System.out.println("befor promotion priod");			//logger.info("befor promotion priod");
		}		 
		else if (today.after(cal1_s) && today.before(cal1_e)){ 		
			
			long totalTime = (cal1_e.getTimeInMillis() - cal1_s.getTimeInMillis())/1000;		System.out.println("이벤트 기간: " + totalTime);			
			long toBeWinningSecond =  totalTime / totalWinningCnt_1;					 		System.out.println("몇초에 하나씩 당첨되어야 하나? " + toBeWinningSecond);
			long remainderTime = (cal1_e.getTimeInMillis() - today.getTimeInMillis())/1000;		System.out.println("남은시간: " + remainderTime);
			long runningTime = totalTime -  remainderTime; 										System.out.println("러닝타임: " + runningTime);
			long cnt = (runningTime/toBeWinningSecond);											System.out.println("당첨되야할 수: " + cnt);
			
			if (cnt > nowWinningCnt ){
				System.out.println("당첨~~");
				nowWinningCnt++;
			}
			else{
				System.out.println("패스");
			}
		}	 
		else if (today.after(cal2_s) && today.before(cal2_e)){
						
			long totalTime = (cal2_e.getTimeInMillis() - cal2_s.getTimeInMillis())/1000;		System.out.println("이벤트 기간: " + totalTime);			
			long toBeWinningSecond =  totalTime / totalWinningCnt_2;					 		System.out.println("몇초에 하나씩 당첨되어야 하나? " + toBeWinningSecond);
			long remainderTime = (cal2_e.getTimeInMillis() - today.getTimeInMillis())/1000;		System.out.println("남은시간: " + remainderTime);
			long runningTime = totalTime -  remainderTime; 										System.out.println("러닝타임: " + runningTime);
			long cnt = (runningTime/toBeWinningSecond);											System.out.println("당첨되야할 수: " + cnt);
			
			if (cnt > (nowWinningCnt - totalWinningCnt_1) ){
				System.out.println("당첨~~");
				nowWinningCnt++;
			}
			else{
				System.out.println("패스");
			}
		}
		else if (today.after(cal2_e) ){
			System.out.println("end promotion priod");		//	logger.info("end promotion priod");
		}  
	}
 
		
}
