package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//money 변수에 args[0] 값을 대입후(급여: 백만단위: 5674321)
		/*
		 * 출력
		 * money : 5674321
		 * 만원짜리 567 장
		 * 천원짜리 4장
		 * 백원짜리 3개
		 * 10원짜리 2개
		 * 1원짜리 1개
		 * 
		 *  : 산술연산자를 사용해서 출력해보세요.
		 */
		int money = 5674321;
		int 만원 = money / 10000;
		int 천원 = (money % 10000)/1000;
		int 백원 = ((money % 10000)%1000)/100;
		int 십원 = (((money % 10000)%1000)%100)/10;
		int 일원 = ((((money % 10000)%1000)%100)%10)/1;
		System.out.println("만원짜리 : " + 만원+"장");		
		System.out.println("천원짜리 : " + 천원+"장");
		System.out.println("백원짜리 : " + 백원+"개");
		System.out.println("십원짜리 : " + 십원+"개");
		System.out.println("일원짜리 : " + 일원+"개");		
	}

}
