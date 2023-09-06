package bit701.day0905;

import java.util.Scanner;

public class Review1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	sc= new Scanner(System.in);
		String juminNo;
		
		while(true)
		{
			System.out.println("주민번호 입력");
			juminNo = sc.nextLine();
			if (juminNo.equalsIgnoreCase("q"))
			{
				System.out.println("프로그램을 종료하겠습니다.");
				break;
			}
			String year=juminNo.substring(0,2);
			String month=juminNo.substring(2,4);
			String day=juminNo.substring(4,6);
			char gender=juminNo.charAt(7);
			System.out.println(year+"년"+month+"월"+day+"일");
			
			if(gender=='1'||gender=='2'||gender=='3'||gender=='4')
			{
				System.out.println("내국인입니다.");
			}else if(gender=='5'||gender=='6')
			{
				System.out.println("외국인입니다.");
			}else {
				System.out.println("8번째 숫자를 잘못 입력했습니다.");
			}
			
			switch(gender)
			{
			case '1', '3', '5':
				System.out.println("남자입니다");
				break;
			case '2', '4', '6':
				System.out.println("여자입니다.");
			default:
				System.out.println("성별을 알 수 없음");
			}
		}
		
	}

}
