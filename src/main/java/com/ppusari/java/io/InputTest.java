package com.ppusari.java.io;
import java.util.Random;
import java.util.Scanner;

public class InputTest {
	public static void main(String[] args)
	{
		// 입력받을 객체를 생성한다.
		Scanner scanner = new Scanner(System.in);
		
		//-------------------------------------------------------------------------------------------
		// 입력문자 받기.
		//-------------------------------------------------------------------------------------------		
		try
		{
			System.out.println("What is your name?");
			String name = scanner.nextLine(); 		 // 문자를 입력받는 것.
			System.out.println("What is your age?");
			int age = scanner.nextInt();		
			System.out.println("your name is " + name + " and your age is " + age);		 	
		}catch(Exception exp)
		{
			System.out.println(exp.toString());		
		}
		
		
		
		//-------------------------------------------------------------------------------------------
		// 가위 바위보 게임.
		//-------------------------------------------------------------------------------------------
		Random rand = new Random();
		int flag;
		
		do
		{
			int computerHand = rand.nextInt(3); // 0~2				
			
			System.out.println("어떤 것을 내시겠습니까? (가위=0, 바위=1, 보=2)");
			int yourHand = scanner.nextInt();
			 	
			switch (computerHand)
			{
			case 0:  // 컴퓨터가 가위를 낼때. 
				if (yourHand == 0)
					System.out.println("비겼습니다.");
				else if ( yourHand == 1)
					System.out.println("내가 이김");
				else if ( yourHand == 2)
					System.out.println("내가 졌다.");
				break;
			case 1:  // 컴퓨터가 바위를 낼때. 
				if (yourHand == 0)
					System.out.println("내가 졌다.");
				else if ( yourHand == 1)
					System.out.println("비겼습니다.");
				else if ( yourHand == 2)
					System.out.println("내가 이김.");
				break;
			case 2:  // 컴퓨터가 보를 낼때. 
				if (yourHand == 0)
					System.out.println("내가 이김");
				else if ( yourHand == 1)
					System.out.println("내가 졌다.");
				else if ( yourHand == 2)
					System.out.println("비겼습니다.");
				break;		
			}
			
			System.out.println("계속 하시겠습니까?");
			flag = scanner.nextInt();			 
			
		} while (flag != 0);
 
	}

}
 