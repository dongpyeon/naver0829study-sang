package bit701.day0904;

public class Ex1_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  반복문에는 for, while, do-while 3가지가 있다.
		 *  for문은 주로 반복횟수가 정해져있는 경우에 많이 사용
		 *  while이나 do-while은 반복횟수가 정해져있지 않은 경우네 많이 사용
		 *  while과 do-while 차이점은 조건은 먼저주느냐, 나중에 주느냐(선조건, 후조건) 차이
		 *  
		 */

		int a=65; //대문자 A의 아스키코드 값
		while(a<=90) //조건이 참인 동안 실행: 91이되면 빠져나간다.
		{
			//			System.out.println((char)a);
			//			a++;
			//위의 코드를 한줄로 줄여보세요
			System.out.println((char)a++);
		}
		System.out.println();
		System.out.println("빠져나온후에 a값"+a);
		
		a=65;
		while(true)
		{
			System.out.println((char)a++);
			if(a>90)
			break;
		}
		
		a=65;
		do {
			System.out.println((char)a++);
		}while(a<=90);//조건뒤에 반드시 ;추가
		
		int n=10;
//		while(n<10) //조건이 거짓이면 한번도 반복안함
//		{
//			System.out.println(n--);
//		}
		//do while은 무조건 일단 한번은 실행
		do {
			System.out.println(n--);
			if(n==0)
				break;
		}while(n<10);
	}

}
