package com.ppusari.java.type.date;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 현재 컴퓨터 날짜 출력
	    Date date = new Date();
	    System.out.printf("now: %s\n", date);
	    System.out.println("now: " + date.toString());

	    // Date 클래스는 기준이 1900 1월 1일 기준이기 때문에 계산이 헷갈린다.
	    Date date2 = new Date(15, 5-1, 5);
	    System.out.printf("%s\n", date2);
	    		
	}

}
