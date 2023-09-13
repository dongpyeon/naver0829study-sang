package bit701.day0913;

abstract class Tire{
	abstract public void roll();
}

class HankookTire extends Tire
{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다.");
	}
}

class KumhoTire extends Tire
{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다.");
	}
}

///////////////////////////////////////////////////////////
class Car{
	public Tire tire;
	public void run()
	{
		tire.roll(); //tire에 new로 생성을 안한상태에서 호출시 NullPointerException 이셉션 발생
	}
}
public class Book315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.tire=new HankookTire();
		car.run();
		car.tire=new KumhoTire();
		car.run();
	}

}
