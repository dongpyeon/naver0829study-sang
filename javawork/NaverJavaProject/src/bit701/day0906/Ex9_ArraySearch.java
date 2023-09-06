package bit701.day0906;

import java.util.Scanner;

public class Ex9_ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"김하나","김둘","김셋","김넷"};
		//이름을 검색하여 몇번째에 있는지 출력
		//없을경우 "xxx님은 명단에 없습니다."
		Scanner sc= new Scanner(System.in);
		String searchName="";
		int find=-1;//찾을 경우 배열인덱스값 저장
		
		//검색할 이름 입력
		System.out.println("이름을 입력하세요");
		searchName = sc.nextLine();
		
		//for문: 같은 이름이 있을경우 출력, BFind도 true로 변경 - break
		//bFind 값에 따라 못 찾은경우 메세지 출력

		
		for(int i=0;i<names.length;i++)
		{
			if(searchName.equals(names[i]))
			{
				find=i;
				break;
			}
		}
		//find 값에 따라 메세지 출력
		if(find==-1)
		{
			System.out.println(searchName+"님은 명단에 없습니다.");
		}else
		{
			System.out.println(searchName+"님은 "+(find+1)+"번째에 있습니다");
		}
	}

}
