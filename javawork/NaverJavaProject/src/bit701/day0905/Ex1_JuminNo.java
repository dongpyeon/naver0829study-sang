package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		Exit:
//			while(true) {
//				System.out.println("주민등록번호를 입력하시오 ex)801010-1000000");
//				String ssn = sc.nextLine();
//				String year = ssn.substring(0,2);
//				String month = ssn.substring(2,4);
//				String day = ssn.substring(4,6);
//				System.out.printf("당신은 %s년생 %s월 %s일생 입니다.",year, month, day);
//				if (ssn.charAt(7)=='1' || ssn.charAt(7)=='2') {
//					System.out.println("내국인입니다.");
//					System.err.println("남성입니다.");
//					System.out.println("프로그램을 종료원하시면 q or Q를 입력하시오");
//					String quit = sc.nextLine();
//					if(quit.equalsIgnoreCase("q")) {
//						System.out.println("프로그램을 종료하겠습니다.");
//						break Exit;}
//				}else if(ssn.charAt(7)=='3'|| ssn.charAt(7)=='4'){
//					System.out.println("내국인입니다.");
//					System.err.println("남성입니다.");
//					System.out.println("프로그램을 종료원하시면 q or Q를 입력하시오");
//					String quit = sc.nextLine();
//					if(quit.equalsIgnoreCase("q")) {
//						System.out.println("프로그램을 종료하겠습니다.");
//						break Exit;}
//				}else if (ssn.charAt(7)=='5'|| ssn.charAt(7)=='6'){
//					System.out.println("외국인입니다.");
//					System.out.println("프로그램을 종료원하시면 q or Q를 입력하시오");
//					String quit = sc.nextLine();
//					if(quit.equalsIgnoreCase("q")) {
//						System.out.println("프로그램을 종료하겠습니다.");
//						break Exit;}
//				}else {
//					System.out.println("잘못 입력하셨습니다.");
//					break Exit;
//					}
//				}
//			}
			//강사님
		Scanner sc = new Scanner(System.in);
		String juminNo;
		
		while(true)
		{
			System.out.println("주민등록 번호 입력");
			juminNo = sc.nextLine();
			//q or Q입력시 종료
			if (juminNo.equalsIgnoreCase("q")){
				System.out.println("Program End!!!!");
				break;
			}
			String yearStr=juminNo.substring(0,2);
			String monthStr=juminNo.substring(2,4);
			String dayStr=juminNo.substring(4,6);
			char gender=juminNo.charAt(7);
			System.out.println(yearStr+"년"+monthStr+"월"+dayStr+"일");
			
			if(gender=='1'||gender=='2'||gender=='3'||gender=='4')
				System.out.println("내국인");
			else if(gender=='5' || gender=='6')
				System.out.println("외국인");
			else
				System.out.println("8번째 값을 잘못 입력했어요.");
			
			switch(gender)
			{
			case '1': case '3': case '5':
				System.out.println("남자!");
				break;
			case '2': case '4': case '6':
				System.out.println("여자!");
				break;
			default:
				System.out.println("성별 알수 없음");
			}
		}
	}

}
