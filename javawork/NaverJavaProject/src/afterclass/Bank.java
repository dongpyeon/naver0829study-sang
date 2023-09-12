package afterclass;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account []account = new Account[10];
		Scanner sc= new Scanner(System.in);
		int idx=0;
		while(true)
		{
			System.out.println("-".repeat(60));
			System.out.println("1.계좌생성|\t2.계좌목록|\t3.입금|\t4.출금|\t5.종료");
			System.out.print("선택>");
			int num=Integer.parseInt(sc.nextLine());
			
			//5가 나올시 종료
			if(num ==5) {
				System.out.println("프로그램 종료");
				break;
			}
			
			//계좌가 10개면 더이상 만들수 없다는 내용 나오기
			switch(num) 
			{
			// 계좌 생성
			case 1:
			{
				//10개 되었을때 계자 개설 불가 및 종료
				if(idx>=10)
				{
					System.out.println("더이상 계좌 개설 불가");
					break;
				}
				//입력부분
				System.out.println("---------------\n계좌 생성\n---------------");
				System.out.println("계좌번호");
				String accountNo=sc.nextLine();
				System.out.println("계좌주");
				String accountName=sc.nextLine();
				System.out.println("초기입금액");
				int money=Integer.parseInt(sc.nextLine());
				
				//새로운 account 생성자
				account[idx]=new Account(accountNo, accountName, money);
				System.out.print("결과: 계좌가 생성되었습니다.");
				//하나 생성시 idx가 증가
				idx++;
				break;
			}
			case 2:
			{
				System.out.println("---------------\n계좌 목록\n---------------");
				for(int i=0; i<idx; i++)
				{
					account[i].accountInfo();
				}
				break;
			}
			case 3: //입금액
			{
				System.out.println("---------------\n입금\n---------------");
				System.out.println("계좌번호");
				String accountNo=sc.nextLine();
				System.out.println("입금액");
				int money=Integer.parseInt(sc.nextLine());
				for(int i=0; i<idx; i++)
				{
					if(account[i].isAccount(accountNo))
					{
						account[i].AddMoney(money);
						break;
					}else {
						System.out.println("없는 계좌입니다.");
						break;
					}
				}
				System.out.println("결과: 입금 성공 되었습니다.");
				break;
			}
			case 4: //출금액
			{
				{
					System.out.println("---------------\n출금\n---------------");
					System.out.println("계좌번호");
					String accountNo=sc.nextLine();
					System.out.println("출금액");
					int money=Integer.parseInt(sc.nextLine());
					for(int i=0; i<idx; i++)
					{
						if(account[i].isAccount(accountNo))
						{
							account[i].SubMoeny(money);
							break;
						}else {
							System.out.println("없는 계좌입니다.");
							break;
						}
						}
					}
				System.out.println("결과: 출금 성공했습니다.");
				}
			}
			System.out.println();
		}
	}

}

