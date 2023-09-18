package afterclass;

@FunctionalInterface
interface Workable{
	public void work();
}

class Person{
	public void action(Workable workable) {
		workable.work();
	}
}

public class Ex_Lambda2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.action(()->{
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		});
		
		person.action(()-> System.out.println("퇴근 합니다."));
		}

}
