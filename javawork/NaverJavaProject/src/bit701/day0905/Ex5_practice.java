package bit701.day0905;

import java.util.Scanner;

public class Ex5_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money=0, total=0;
		Exit:
			while(true)
			{
				System.out.println("=".repeat(40));
				System.out.println("1. 예금 | 2. 출금 | 3.잔금 | 4. 종료");
				System.out.println("=".repeat(40));
				System.out.println("선택> ");
				int num = sc.nextInt();
				if (num==1) {
					System.out.println("예금액> ");
					money = sc.nextInt();
					total += money;
					continue;
				} else if(num==2) {
					System.out.println("출금액> ");
					money = sc.nextInt();
					total -= money;
					continue;
				} else if(num==3) {
					System.out.println("잔고> "+total);
				} else if(num==4) {
					break Exit;
				} else {
					System.out.println("잘못 입력했습니다. (1~4번만 입력)");
					continue;
				}
			}
		System.out.println("**종료**");
	}

}
