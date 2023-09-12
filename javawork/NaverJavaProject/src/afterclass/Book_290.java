package afterclass;
class Phone
{
	public String model;
	public String color;
	
	public Phone() {
		System.out.println("Phone() 생성자 실행");
	}
}

class SmartPhone extends Phone
{
	public SmartPhone(String model, String color)
	{
		super();
		this.model=model;
		this.color=color;
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
public class Book_290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone myPhone = new SmartPhone("갤럭시","은색");
		
		System.out.println("모델: "+myPhone.model);
		System.out.println("색상: "+myPhone.color);
	}

}
