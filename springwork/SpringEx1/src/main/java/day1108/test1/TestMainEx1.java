package day1108.test1;

import lombok.NoArgsConstructor;

public class TestMainEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDto dto = new TestDto();  //TestDto�� AllArgsConstructor������ �������. ������ �� ���� @NoArgsConstructor �־��ָ� �ذ�
		dto.setName("�̻��");
		dto.setAddr("����");
		dto.setAge(23);
		
		System.out.println("�̸�: "+dto.getName());
		System.out.println("�ּ�: "+dto.getAddr());
		System.out.println("����: "+dto.getAge());
	
		System.out.println("toString() ȣ��");
		System.out.println(dto); //������ dto.toString();
		
		TestDto dto2 = new TestDto("��ȣ��", "���ֵ�", 45);
		System.out.println(dto2);
		
		TestDto dto3 = new TestDto("�����");
		System.out.println(dto3);
	}

}
