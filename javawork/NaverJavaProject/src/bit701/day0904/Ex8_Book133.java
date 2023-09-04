package bit701.day0904;

import java.util.Scanner;

public class Ex8_Book133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
		
		Scanner	scanner = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.println(">");
			inputString=scanner.nextLine();
			System.out.println(inputString);
		//}while(!inputString.equals("q")); //소문자 q 입력시 종료
		}while(!inputString.equalsIgnoreCase("q")); //대/소문자 구분없이 q입력시 종료
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
