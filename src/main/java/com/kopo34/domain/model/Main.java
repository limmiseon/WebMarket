package com.kopo34.domain.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// 캘린더는 추상 클래스이다. 추상 클래스는 상속의 재료다.
		// 현재 달력
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.get(Calendar.YEAR)); // 현재 년도
		System.out.println(calendar.get(Calendar.MONTH) + 1); // 현재 월 (+ 1 해야 함)
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 현재 날짜
		
		// 10일 후
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		
		System.out.println(date);
		
		// 내년 내 생일
		calendar.set(2023, 9, 01); // 달 입력할때는 -1 해야 함 (10월 1일)
		// 요일 구하기
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 1 ~ 7 일 ~ 토

	}

}
