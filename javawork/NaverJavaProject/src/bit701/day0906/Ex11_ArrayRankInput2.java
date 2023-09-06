package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 총 4명의 이름과 점수를 입력하면 이름과 점수 등수를 출력하는 프로그램을 작성하시오
		 *  단, 점수가 0~100을 벗어나는 경우 다시 입력하시오
		 *  
		 *  예:
		 *  		0번 이름: 김하나
		 *  		0번 점수: 99
		 *  
		 *  		1번 이름: 최여섯
		 *  		1번 점수: 120
		 *  			다시 입력하세요.
		 *  		1번 이름: 최여섯
		 *  		1번 점수: 60
		 *  
		 *  		번호		이름		점수		등수
		 *  	------------------------------------------------
		 *  		1		김하나			99			1
		 */
		Scanner sc = new Scanner(System.in);
		String []names = new String[4];
		int []score = new int[4];
		int []rank=new int[4];

		for (int i=0; i<names.length; i++)
		{
			System.out.println(i+"번 이름은?");
			names[i]=sc.nextLine();
			System.out.println(i+"번 점수는?");
			score[i]=Integer.parseInt(sc.nextLine());
			if(score[i]<0 || score[i]>100)
			{
				System.out.println("0~100 사이 점수로 입력바람");
				i--;//미리 1 감소후 i++에서 1증가되므로 다시 제자리에 입력
				continue; 
			}
		}
		//등수 구하기
		for (int i=0; i<score.length;i++)
		{
			//각 i번지 등수는 1로 초기화
			rank[i]=1;
			for(int j=0; j<score.length; j++)
			{
				//i번지 점수보다 j번지 점수가 더 크면 i번지 등수를 1 증가
				if (score[i]<score[j])
				{
					rank[i]++;
				}
			}
		}
		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0; i<score.length; i++)
		{
			System.out.println(i+1+"\t"+names[i]+"\t"+score[i]+"\t"+rank[i]);
		}
	}

}
