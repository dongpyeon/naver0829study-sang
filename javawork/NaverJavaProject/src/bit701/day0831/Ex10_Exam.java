package bit704.day0831;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품명 과 수량, 단갈ㄹ 각각 입력받은 후 총금액을 출력하시오
		 * 그리고 수량이 5개 이상일 경우 10프로 할인된 최종 금액도 출력해쥇요.
		 * 
		 * (예)
		 * 상품명: 딸기
		 * 단가: 1000
		 * 수량: 6개
		 * 
		 * 총 단가: 6000
		 * 5개 이상일 시 10% 할인 총 금액: 5400
		 */
		//		Scanner sc=new Scanner(System.in);
		//		System.out.println("상품명을 입력하시오");
		//		String product = sc.nextLine();
		//		System.out.println("수량을 입력하시오");
		//		int quantity=sc.nextInt();
		//		System.out.println("단가 입력하시오");
		//		int price =sc.nextInt();
		//		
		//		int totalPrice = 0;
		//		totalPrice = quantity * price;
		//		DecimalFormat df = new DecimalFormat("###,###");
		//		String formatTotalPrice = df.format(totalPrice);
		//		
		//		System.out.printf("상품명: %s\n수량: %d\n단가: %d\n최종 금액: %s",product, quantity, price, formatTotalPrice);
		//		System.out.println();
		//		boolean b=quantity>5?true:false;
		//
		//		NumberFormat numberformat1=NumberFormat.getInstance();
		//		
		//		if(b)
		//		{
		//			totalPrice *= 0.9;
		//		}
		//		else {
		//		}
		//		System.out.println("최종금액:" + ' '+ numberformat1.format(totalPrice));
		
		//선언
		Scanner sc=new Scanner(System.in);
		NumberFormat numFormat=NumberFormat.getInstance();
		String sangpum ="";
		int su=0, dan=0, total=0;
				
		//입력
		System.out.println("상품명");
		sangpum=sc.nextLine();
		System.out.println("수량");
		su=sc.nextInt();
		System.out.println("단가");
		dan=sc.nextInt();
		
		//계산
		//총금액
		total=su*dan;
		
		//출력
		System.out.println("총 금액 ="+numFormat.format(total)+"원");
		
		//5개 이상 할인받는 조건 추가
		if(su>=5)
		{
			total=(int)(total*0.9);
			System.out.printf("5개 이상 10프로 할인된 금액 : %d원\n",total);
			System.out.printf("5개 이상 10%% 할인된 금액 : %s원\n",numFormat.format(total));
		}
		
			}

	}
