package bit701.day0906;

import java.util.Random;

public class Ex16_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 6개 할당된 lotto변수에 1~45사이의 난수를 발생하는데
		 * (중복된 경우 다시 발생) 오름차순 정렬로 출력하시오
		 */
		Random r= new Random();
		int []lotto = new int[6];

		Loop:
			for (int i=0; i<lotto.length;i++)
			{
				lotto[i]=r.nextInt(45)+1;
				for(int j=0; j<i; j++)
				{
					if(lotto[i]<lotto[j])
					{
						int temp = lotto[i];
						lotto[i] =lotto[j];
						lotto[j]= temp;
					}
					if(lotto[i]==lotto[j])
					{
						i--;
						continue Loop;
					}
				}
			}
		for (int i=0; i<lotto.length; i++) 
		{
			System.out.printf("%4d",lotto[i]);
			if((i+1)%6==0)
			{
				System.out.println();	
			}
		}

	}

}
