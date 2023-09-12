package afterclass;

public class Ex_Sungjuk {
	//필드를 넣어준다.
	private String name;
	private int kor;
	private int eng;
	
	//멤버 변수 생성자를 만든다.
	//직접 타이핑하는 방법도 있지만 source메뉴에서 generate contructor using filed사용하는 방법도있다.
	//select all해서 생성하면된다.
	public Ex_Sungjuk(String name, int kor, int eng)
	{
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	}

	
	//이제 이내용들을 받을 setter, getter method를 넣는다.
	//이번에는 generate를 사용해서 해보자
	//source메뉴에서 generate setter, getter 후 selectall 한후 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	
}
