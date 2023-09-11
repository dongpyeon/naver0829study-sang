package bit701.day0911;
//Overloading Method:메서드 명은 반드시 같아야하고 인자는 반드시 달라야 한다.
class Apple{
	//1번
	public static int sm(int a, int b)
	{
//		System.out.println(1);
		return a+b;
	}
	//2번
	public static int sum(int s1, int s2, int s3)
	{
		return s1+s2+s3;
	}
	//3번
	public static double sum(double a, double b)
	{
		return a+b;
	}
	//4번
	public static String sum(String a, String b)
	{
		return a+b;
	}
	//5번
	public static String sum(String a, int b)
	{
		return a+b;
	}
	//... Variable Arguments
	public static int sum(int...n)//n은 배여라입, 숫자 갯수 상관없이 int 배열타입으로 받는다.
	{
		System.out.println(2);
		System.out.println("총 "+n.length);
		return 0;
	}
}

public class Ex2_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Apple.sum(5, 7));
//		System.out.println(s1);
		System.out.println(Apple.sum("apple", "orange"));
		System.out.println(Apple.sum(1.2, 4.5));
//		System.out.println(Apple.sum(100, "ornage"));//오류 int와 String결합이기에
		System.out.println(Apple.sum(100,200,300));
//		System.out.println(Apple.sum(100,200,300,400)); //오류, 인지가 4개인 메서드가 없기때문
	}

}
