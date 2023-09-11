package bit701.day0911;

import java.util.Date;

class Student
{
	//멤버 변수
	private String name;
	private  int birthYear;
	private int score;
	
	//생성자 1
	Student()
	{
//		name="이효리";
//		birthYear=2000;
//		score=50;
		this("이효리",2000,50);
	}
	//생성자2
	Student(String name)
	{
//		this.name=name;
//		birthYear=2000;
//		score=50;
		this(name,2000,50);
	}
	//생성자 3
	Student(String name, int birthday, int score)
	{
		this.name=name;
		this.birthYear=birthday;
		this.score=score;
	}
	//출력
	public void studentInfo()
	{
		System.out.println("**학생정보**");
		System.out.println("이름:"+name);
		
		int year=new Date().getYear()+1900;
		
		System.out.println("태어난 년도:"+birthYear+",나이"+(year-birthYear));
		System.out.println("점수"+score+"점");
		System.out.println("-".repeat(40));
	}
}
