package bit701.day0913;

class Parent
{
	public void method1() {
		System.out.println("Parent-method1()");
	}
	
	public void method2() {
		System.out.println("Parent-method2()");
	}
}

class Child extends Parent{
	
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Child-method2()");
	}
	
	public void method3() {
		System.out.println("Child-method3()");
	}
}

public class Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child c = new Child();
		c.method1();//상속받는 메서드
		c.method2();//child의 method2가 호출
		c.method3();//child에만 있는 메서드
		System.out.println("======================");
		Parent p = c;
		
		p.method1();
		p.method2(); 
		//p.method3();//오류 발생, Child의 오버라이드한 메서드만 호출 가능
		((Child)p).method3(); //강제 형 변환을 통해서 사용이 가능하다.
	}

}
