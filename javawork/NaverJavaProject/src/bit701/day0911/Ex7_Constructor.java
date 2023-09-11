package bit701.day0911;

public class Ex7_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 방법1
//		Student []stu=new Student[3];//5개로 배열 할당, 초기값은 null
//		stu[0]=new Student();
//		stu[1]=new Student("이효리");
//		stu[2]=new Student("이진",1999,99);
		
		//방법2 1번을 더 많이 사용한다.
		Student []stu= {
				new Student(),
				new Student("유재석"),
				new Student("박효신",1989,89),
				new Student("캔디",1979,100)
		};
		//출력 방법1
//		for(int i=0; i<stu.length; i++)
//		{
//			stu[i].studentInfo();
//		}
		//출력 방법2
		for(Student s:stu)
			s.studentInfo();
		
	}

}
