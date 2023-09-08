package bit701.day0908;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// car 객체 생성
		Car mycar1 = new Car();
		mycar1.setCompany("현대");
		mycar1.setModel("소나타");
		mycar1.setColor("blue");
		mycar1.setStart(true);
		mycar1.setMaxSpeed(250);
		mycar1.setSpeed(70);
		
		CarExample.PrintInformation(mycar1);
		System.out.println("=".repeat(40));
		
		Car mycar2 = new Car();
		mycar2.setCompany("페라리");
		mycar2.setModel("아벤타도르");
		mycar2.setColor("red");
		mycar2.setStart(false);
		mycar2.setMaxSpeed(300);
		mycar2.setSpeed(50);
		
		CarExample.PrintInformation(mycar2);

	}
	//car 객체에 필드값 읽기
	
	public static void PrintInformation(Car c)
	{
		System.out.println("회사명: " +c.getCompany());
		System.out.println("모델명: " +c.getModel());
		System.out.println("색상: " +c.getColor());
		System.out.println("시동여부: " +c.getStart());
		System.out.println("최대 속도: " +c.getMaxSpeed());
		System.out.println("현재속도: " +c.getSpeed());
	}
	

}
