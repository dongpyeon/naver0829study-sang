package bit701.day0906;

public class Ex3_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []arr= {'A','p','p','l','e'};
		double []arr2;
		arr2 = new double[] {1.7,8.2,3.5};
		String []arr3=new String[3];
		arr3[0]="사과";
		arr3[1]="오렌지";
		arr3[2]="딸기";
		
		System.out.println("=".repeat(50));
		
		System.out.println("*** arr1 출력 ***");
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println("\n*** arr2 출력 ***");
		for (int i=0; i<arr2.length; i++)
		{
			System.out.print(arr2[i]+"\t");
		}
		System.out.println("\n*** arr3 출력 ***");
		for (int i=0; i<arr3.length; i++)
		{
			System.out.println(arr3[i]);
		}	
		System.out.println("=".repeat(50));
		System.out.println("*** arr1 출력 ***");
		for (char ch:arr) {
			System.out.print(ch);
		}
		System.out.println("\n*** arr2 출력 ***");
		for (double d:arr2)
		{
			System.out.print(d+"\t");
		}
		System.out.println("\n*** arr3 출력 ***");
		for (String st:arr3)
		{
			System.out.println(st);
		}
	}

}
