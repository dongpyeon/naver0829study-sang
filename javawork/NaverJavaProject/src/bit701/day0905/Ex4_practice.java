package bit701.day0905;

import java.util.Scanner;

public class Ex4_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i=1; i<=5; i++) {
//			for (int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i=1; i<=5; i++) {
//		for (int j=i; j<=5; j++) {
//			System.out.print("*");
//		}
//		System.out.println();
//	}
//		
//		for (int i=1; i<=5; i++) {
//		for (int j=1; j<=5; j++) {
//			if(i==j) {
//				System.out.print(i);
//			}else {
//				System.out.print("*");
//			}
//		}
//		System.out.println();
//	}
//
		Scanner sc =new Scanner(System.in);
		int money = 0, total =0;
		Exit: while(true) {
			System.out.println("=".repeat(40));
			System.out.println("1. 예금 | 2. 출금 | 3.잔금 | 4. 종료");
			System.out.println("=".repeat(40));
			System.out.println("선택> ");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("예금액> ");
				money = sc.nextInt();
				total+=money;
				break;
			case 2:
				System.out.println("출금액> ");
				money =sc.nextInt();
				total-=money;
				break;
			case 3:
				System.out.println("잔고 :"+total);
				break;
			case 4:
				break Exit;
			default:
				System.out.println("잘못 입력했습니다.(1~4만 입력가능)");
				continue;
			}
		}
		System.out.println("프로그램 실행 종료");
	}
		
	}

