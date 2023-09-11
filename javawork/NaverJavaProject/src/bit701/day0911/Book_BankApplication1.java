package bit701.day0911;

import java.util.Scanner;

public class Book_BankApplication1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account []account=new Account[10];
		Scanner sc=new Scanner(System.in);

		//배열 10개가 꽉차면 "더이상 계좌생성이 안됩니다."라고 출력

		int idx=0;
		while(true)
		{
			System.out.println("-".repeat(60));
			System.out.println("1.계좌생성|\t2.계좌목록|\t3.예금|\t4.출금|\t5.종료");
			System.out.println("선택>>");
			int re=Integer.parseInt(sc.nextLine());

			if(re==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			switch(re)
			{
			case 1:{
				if(idx >= 10) {
					System.out.println("더이상 계좌생성이 안됩니다.");
					break;
				}
				System.out.println("----------\n계좌생성\n----------");
				System.out.print("계좌번호:");	
				String accountNo=sc.nextLine();
				System.out.print("계좌주:");	
				String accountName=sc.nextLine();
				System.out.print("초기입금액:");	
				int money=Integer.parseInt(sc.nextLine());

				account[idx]= new Account(accountNo,accountName, money); 
				idx++;
				break;
			}
			case 2:
			{
				System.out.println("----------\n계좌목록\n----------");
				for(int i=0; i<idx; i++)
				{
					account[i].accountWrite();
				}
			}
			case 3:
			{
				System.out.println("----------\n출금\n----------");
				System.out.print("계좌번호:");	
				String accountNo=sc.nextLine();
				System.out.print("예금액:");	
				int money=Integer.parseInt(sc.nextLine());
				for(int i=0; i<idx; i++)
				{
					if(account[i].isAccount(accountNo))
					{
						account[i].addMoney(money);
					}
				}
			}
			case 4:
			{
				System.out.println("----------\n출금\n----------");
				System.out.print("계좌번호:");	
				String accountNo=sc.nextLine();
				System.out.print("출금액:");	
				int money=Integer.parseInt(sc.nextLine());
				for(int i=0; i<idx; i++)
				{
					if(account[i].isAccount(accountNo))
					{
						account[i].subMoney(money);
					}
				}
			}	
			}
			}
	}
}