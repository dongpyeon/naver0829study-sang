package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex2_Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름, 3과목의 점수(kor, eng, mat)를 입력받은후 총점과 평균(소숫점 1자리 출력-NumberFormat)
		 * 그리고 등급을 출력(grade : 90이상이면 "Excellent!", 80이상이면 "Good!", 나머지는 "Try!"라고 출력
		 * if-else 사용해서 구해보자
		 */
		
		//선언
		Scanner sc = new Scanner(System.in);
		NumberFormat numFormat=NumberFormat.getInstance();
		numFormat.setMaximumFractionDigits(1);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("국어 점수를 입력하세요");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int mat = sc.nextInt();
//		//입력

		int score = kor+eng+mat;
		double avgScore = score/3.0;
		
		String grade = "";
		
//		//계산
		if (avgScore >= 90)
		{
			grade = "Excellent!";
		}
		else if (avgScore >=80)
		{
			grade="Good!";
		}
		else
		{
			grade="Try!";
		}
		//출력
		System.out.printf("%s의 총 점수는 %d 평균 점수는 %s 이며 등급은 %s 입니다.", name,score,numFormat.format(avgScore),grade);
		
		
		//강사님꺼
//		//선언
//		Scanner sc = new Scanner(System.in);
//		NumberFormat numFormat=NumberFormat.getInstance();
//		numFormat.setMaximumFractionDigits(1);
//		String name="";
//		int kor, eng, mat, total =0;
//		double avg=0;
//		String grade="";
//		
//		//입력
//		System.out.println("이름을 입력하세요");
//		name = sc.nextLine();
//		System.out.println("국어 점수를 입력하세요");
//		kor = sc.nextInt();
//		System.out.println("영어 점수를 입력하세요");
//		eng = sc.nextInt();
//		System.out.println("수학 점수를 입력하세요");
//		mat = sc.nextInt();
//		
//		//계산
//		total=kor+eng+mat;
//		avg=total/3.0;
//		if(avg>=90) grade="Excellent!";
//		else if(avg>=80) grade="Good!";
//		else grade="Try!";
//		
//		//출력
//		System.out.println("이름 : "+name);
//		System.out.println("국어 점수 : "+kor);
//		System.out.println("영어 점수 : "+eng);
//		System.out.println("수학 점수 : "+mat);
//		System.out.println("총점 : "+total+"점");
//		System.out.println("평균 : "+numFormat.format(avg)+"점");
//		System.out.println("평가 : "+grade);
		
		
	}

}
