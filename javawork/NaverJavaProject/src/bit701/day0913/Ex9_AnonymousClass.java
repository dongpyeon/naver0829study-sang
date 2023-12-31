package bit701.day0913;
//익명 내부 클래스(Anonymous Inner Class)
abstract class AnonySuper
{
	abstract public void show();
	abstract public void play();
}

interface BitInter
{
	public void study();
	public void draw();
}

//추상 클래스를 상속받는 서브 클래스 구현
class AnonyClass
{
	//이 형태가 바로 익명 내부 클래스 형태이다.
	//탐색기에서 보면 외부클래스명 $1 이런식으로 class 이름이 만들어진다.
	AnonySuper anony=new AnonySuper() { //anonysupser친후 ctl+space하면 아래 내용나옴
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("오늘은 N-Time 날");
		}
		
		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("노는날 아닙니다.");
		}
	};
	//interface Bitinter를 익명 내부 클래스 형태로 구현하여 메인에서 호출해보세요.
	BitInter bit=new BitInter() {
		
		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("자바공부를 하고 있어요");
		}
		
		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("그림도 그리고 있어요.");
		}
	};
}

public class Ex9_AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonyClass a=new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();
	}

}
