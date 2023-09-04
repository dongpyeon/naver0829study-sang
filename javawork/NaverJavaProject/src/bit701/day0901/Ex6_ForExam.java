package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * 구구단을 출력할 시작단 입력
		 * 4 
		 * 구구단을 출력할 끝단 입력
		 * 6
		 * 
		 *      4단     5단     6단      - 단일 for문으로 돌리기
		 *    4x1=4     5x1=5   6x1=6     - 다중 for문
		 *    4x2=8     5x2=10  6x2=12
		 *    
		 */
		//이전의 내답
//		int startDan;
//		int lastDan;
//		System.out.println("구구단을 출력할 시작단을 입력하시오");
//		startDan=sc.nextInt();
//		System.out.println("구구단을 출력할 시작단을 입력하시오");
//		lastDan=sc.nextInt();
//
//		for (int i=startDan; i<=lastDan; i++) {
//			System.out.printf("\t**"+i+"단 **\t");
//			}
//		System.out.println();
//		for (int j=1; j <=9; j++) 
//		{
//			for (int i=startDan; i<=lastDan; i++)
//				System.out.printf("%6d X %d = %2d\n",i,j,i*j);
//		}
//			System.out.println();
		
		//내꺼
//				System.out.println("구구단을 출력할 시작단을 입력하시오");
//				int start=sc.nextInt();
//				System.out.println("구구단을 출력할 마지막단을 입력하시오");
//				int last=sc.nextInt();
//		
//				for (int dan=start; dan<=last; dan++) 
//					{
//					System.out.printf("%7d단 ",dan);
//					}
//				System.out.println();
//				for (int j=1; j<=9; j++) 
//				{
//					for (int dan=start; dan<=last; dan++) 
//					{
//						System.out.printf("%6dX%d=%2d",dan,j,dan*j);
//					}
//					System.out.println();
//				}
		// 강사님
		System.out.println("구구단을 출력할 시작단을 입력하시오");
		int start=sc.nextInt();
		System.out.println("구구단을 출력할 시작단을 입력하시오");
		int end=sc.nextInt();
		//start가 end보다 클 경우 두 변수의 값을 바꿔보자
		if (start>end) {
			int temp=start;
			start=end;
			end=temp;
		}
		//제목 출력
		for (int dan=start; dan<=end; dan++)
		{
			System.out.printf("%7d단 ",dan);
		}
		System.out.println("\n");
		for (int i=1; i<=9;i++)
		{
			for(int dan=start; dan<=end;dan++)
			{
				System.out.printf("%5dx%d=%2d",dan,i,dan*i);
			}
			System.out.println();
		}
	}
	
}
