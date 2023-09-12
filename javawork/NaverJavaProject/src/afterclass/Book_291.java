package afterclass;
class Phone1
{
	public String model;
	public String color;
	
	public Phone1(String model, String color)
	{
		this.model=model;
		this.color=color;
		System.out.println("Phone(String model, String color)생성자 실행");
	}
}

class SmartPhone1 extends Phone1
{
	public SmartPhone1(String model, String color)
	{
		super(model, color);
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
public class Book_291 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone1 myPhone = new SmartPhone1("갤럭시", "은색");
		System.out.println("모델: "+myPhone.model);
		System.out.println("색상: "+myPhone.color);
	}

}
