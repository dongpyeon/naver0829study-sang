package bit701.day0905;

import java.util.Scanner;

public class Ex1_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int speed = 0;
//
//		while(true) {
//			System.out.println("=".repeat(30));
//			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
//			System.out.println("=".repeat(30));
//			System.out.println("선택");
//
//			String strNum = sc.nextLine();
//
//			if(strNum.equals("1"))
//			{
//				speed++;
//				System.out.println("현재 속도 = "+ speed);
//			} else if(strNum.equals("2"))
//			{
//				speed--;
//				System.out.println("현재 속도 = "+ speed);
//			} else if(strNum.equals("3"))
//			{
//				break;				
//			}
//		}
//		System.out.println("프로그램종료");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("please insert the number");
//		int n = sc.nextInt();
//		for (int i=5; i<=5; i++) {
//			for (int j=1; j<=5; j++)
//			{
//				if(i==j) {
//					System.out.print(i);
//				} else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//		int[] arr1;
//		int[] arr2;
//		int[] arr3;
//		arr1=new int[] {1,2,3};
//		arr2=new int[] {1,2,3};
//		arr3=arr2;
//		System.out.println(arr1==arr2);
//		System.out.println(arr2==arr3);

//		String hobby = "여행";
//		hobby = null;
//		
//		String kind1 = "자동차";
//		String kind2 = kind1;
//		kind1=null;
//		System.out.println("kind2:" + kind2);
//		String subject ="자바 프로그래밍";
//		
//		int location = subject.indexOf("프로그래밍");
//		System.out.println(location);
//		String substring = subject.substring(location);
//		System.out.println(substring);
//		
//		location = subject.indexOf(location);
//		if(location != -1)
//		{
//			System.out.println("자바와 관련된 책이군요");
//		}else {
//			System.out.println("자반와 관련 없는 책인군요");
//		}
//		
//		boolean result = subject.contains("자바");
//		if(result)
//		{
//			System.out.println("자바와 관련된 책이군요");
//		} else {
//			System.out.println("자바와 관련없는 책인군요");
//		}
		String board = "1,자바 학습,참조 타입 string을 학습했습니다.,홍기롱";
		String[] tokens = board.split(",");
		
		System.out.println("번호: "+tokens[0]);
		System.out.println("제목: "+tokens[1]);
		System.out.println("내용: "+tokens[2]);
		System.out.println("성명: "+tokens[3]);
		System.out.println();
		
		for(int i=0; i<tokens.length; i++){
			System.out.println(tokens[i]);
		}
	}
}
