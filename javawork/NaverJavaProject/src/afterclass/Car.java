package afterclass;

public class Car {

	String model;
	int speed;
	
	//생성자 선언
	Car(String model){
		this.model=model;
	}
	
	//메소드 선언
	public void setSpeed(int speed)
	{
		this.speed=speed;
	}
	
	//출력 내용 메소드
	public void run() {
		this.setSpeed(100);
		System.out.println(this.model+"가 달립니다.(시속:"+this.speed+"km/h)");
	}
	
}
