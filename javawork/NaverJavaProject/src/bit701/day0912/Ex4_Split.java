package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="red,blue,green,orange,gray";
		//문자열을 , 로 분리해서 배열에 담아보자
		String []strArray=str1.split(",");
		System.out.println("총 "+strArray.length+" 개로 분리됨");
		for(int i=0; i<strArray.length;i++)
		{
			System.out.println(i+" : "+strArray[i]);
		}
		System.out.println("-".repeat(20));
		String str2="sea.jpg";
		String str3="sea.jpg";
		String []str2Array=str2.split("\\.");
		String []str3Array=str3.split("[.]");
		System.out.println(str2Array.length);
		System.out.println(str2Array[0]);
		System.out.println(str2Array[1]);
		System.out.println(str3Array[0]);
		System.out.println(str3Array[1]);
		System.out.println("=".repeat(40));
		
		String str4="red|green|yellow";
//		String []str4Array=str4.split("\\|");
		String []str4Array=str4.split("[|]");
		System.out.println(str4Array.length);
		for(int i=0; i<str4Array.length;i++)
		{
			System.out.println(i+":"+str4Array[i]);
		}
		System.out.println("=".repeat(40));
		
		//자바의 클래스를 이용해서 분리하기
		StringTokenizer st=new StringTokenizer(str1,",");
		System.out.println("총 "+st.countTokens()+"개로 분리");
		while(st.hasMoreTokens())//다음 분리할 토큰이 있으면 true, 아니면 false
		{
			System.out.println(st.nextToken());
		}
		System.out.println("=".repeat(40));
		StringTokenizer st2=new StringTokenizer(str1,",");
		for(int i=0; i<st2.countTokens();i++) //
		{
			System.out.println(st2.nextToken());
		}
		
		System.out.println("=".repeat(40));
		StringTokenizer st3=new StringTokenizer(str1,",");
		int count=st3.countTokens(); //2. 먼저 고정값을 가지고 시작하면 문제 안생김
		for(int i=0; i<count;i++) //1. count 될때마다 숫자가 줄어들어서 3개만 추력
		{
			System.out.println(st3.nextToken());
		}
	}

}
