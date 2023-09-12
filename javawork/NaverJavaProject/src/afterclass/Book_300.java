package afterclass;

class Car1{
	//필드 선언
	public int speed;
	
	//메소드 선언
	public void speedUp() {
		speed+=1;
	}
	
	//final 메소드
	public final void stop()
	{
		System.out.println("차를 멈춰");
		speed=0;
	}
}

class SportsCar1 extends Car1
{
	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		speed +=10;
	}
	
}

public class Book_300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
