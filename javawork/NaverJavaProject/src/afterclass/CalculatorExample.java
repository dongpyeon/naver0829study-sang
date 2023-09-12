package afterclass;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal=new Calculator();
		
		//정사각형의 넓이 구하기
		
		double result1=cal.areaRectangle(10);
		
		
		// 직사각형의 넓이 구하기
		double result2=cal.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이는:"+ result1);
		System.out.println("직사각형의 넓이는:"+ result2);
		
	}

}
