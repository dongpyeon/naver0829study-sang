package bit701.day0911;

import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
//		int sawon;
//		Sawon []sw;
//		
//		System.out.println("사원수를 입력하세요");
//		sawon=Integer.parseInt(sc.nextLine());
//		//[내꺼]
//		sw=new Sawon[sawon];
//		
//		for(int i=0; i<sawon; i++)
//		{
//			System.out.println((i+1)+"의 이름은?");
//			String name=sc.nextLine();
//			System.out.println((i+1)+"의 기본급은?");
//			int gibon=sc.nextInt();
//			System.out.println((i+1)+"의 수당은?");
//			int sudang=sc.nextInt();
//			System.out.println((i+1)+"의 가족수는");
//			int familySu=sc.nextInt();
//			
//			sw[i]=new Sawon(name, gibon, sudang, familySu);
//		}
//		
//		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
//		System.out.println("=".repeat(60));
//		for(Sawon my:sw)
//		{
//			System.out.println(my.getName()+"\t"+my.getGibon()+"\t"+my.getSudang()+"\t"+my.familySu()+"\t"+my.getFamilySudang()+"\t"+my.getTax()+"\t"+my.getNetPay());
//		}

//		//[강사님]
		Sawon []sa=new Sawon[3];
		
		//3명의 사원에 대한 정보 입력후 배열 생성하기
		for(int i=0; i<sa.length;i++)
		{
			System.out.println(i+"번 사원명:");
			String name=sc.nextLine();
			System.out.println("\t기본급은?");
			int gibon=Integer.parseInt(sc.nextLine());
			System.out.println("\t수당은?");
			int sudang=Integer.parseInt(sc.nextLine());
			System.out.println("\t가족수는?");
			int familysu=Integer.parseInt(sc.nextLine());
			
			//객체 생성
			sa[i]=new Sawon(name, gibon, sudang, familysu);
		}
		
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println(("=".repeat(60)));
		for(Sawon s:sa)
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"+s.familySu()+"\t"+s.getFamilySudang()+"\t"+s.getTax()+"\t"+s.getNetPay());
	}

}
