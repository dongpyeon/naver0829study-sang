package day1108.test1;

import lombok.NoArgsConstructor;

public class TestMainEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDto dto = new TestDto();  //TestDto에 AllArgsConstructor넣으면 오류뜬다. 하지만 그 위에 @NoArgsConstructor 넣어주면 해결
		dto.setName("이상아");
		dto.setAddr("강남");
		dto.setAge(23);
		
		System.out.println("이름: "+dto.getName());
		System.out.println("주소: "+dto.getAddr());
		System.out.println("나이: "+dto.getAge());
	
		System.out.println("toString() 호출");
		System.out.println(dto); //원래는 dto.toString();
		
		TestDto dto2 = new TestDto("강호동", "제주도", 45);
		System.out.println(dto2);
		
		TestDto dto3 = new TestDto("윤계상");
		System.out.println(dto3);
	}

}
