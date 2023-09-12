package afterclass;
class Airpalane
{
	public void land()
	{
		System.out.println("착륙합니다.");
	}
	
	public void fly()
	{
		System.out.println("일반 비행합니다.");
	}
	
	public void takeOff()
	{
		System.out.println("이륙합니다.");
	}
}

class SupersonicAirpalne extends Airpalane
{
	///상수 선언
	public static final int NORMAL =1;
	public static final int SUPERSONIC =2;
	
	//상태 필드 선언
	public int flyMode=NORMAL;
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if(flyMode == SUPERSONIC)
		{
			System.out.println("초음속 비행입니다.");
		} else {
			//Airplane 객체의 fly() 메소드 호출
			super.fly();
		}
	}
}

public class Book_296 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicAirpalne sa = new SupersonicAirpalne();
		sa.takeOff();
		sa.fly();
		sa.flyMode=SupersonicAirpalne.SUPERSONIC;
		sa.fly();
		sa.flyMode=SupersonicAirpalne.NORMAL;
		sa.fly();
		sa.land();
	}

}
