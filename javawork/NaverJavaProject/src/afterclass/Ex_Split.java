package afterclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex_Split {
	//1. 먼저 어디에 있는 파일을 불러낼지 정적변수로써 넣어준다.
	static final String FILE2="D:/naver0829/afterclass.txt";
	//2. 미리 저장해두었던 메모장 파일을 배열로 넣어야 하기에 배열을 생성하자(20개)
	Ex_Sungjuk []sj = new Ex_Sungjuk[20];
	//3.이전에 배열을 for문을 통해서 불러와야할 경우에는 count를 넣어서 초기화한 후 받아왓다.
	int count;
	
	//4. 이제 내용들을 하나씩 분리하는 내용을 넣어보자. 이전에 한거와 비슷하게 진행된다.
	public Ex_Split() throws IOException {
		//5. FileReader, BufferedReader를 null로 초기화 및 유틸 import
		FileReader fr=null;
		BufferedReader br=null;
		
		//6. 이제 filereader로 파일을 열어주고 buffered로 불러온다.
		//이때 빨간줄이 그어지는데 그때 try catch를 넣어준다.
		
		try {
			fr = new FileReader(FILE2);
			br = new BufferedReader(fr);
			
			//7. 이제 while을 하기전에count를 0으로 초기화 해준다.
			//count 변수는 파일에서 읽어온 데이터의 총 수를 추적하기 위해 초기화되고, 
			//각 데이터를 읽을 때마다 증가하는 역할
			
			count =0;
			while(true)
			{
				//8. 한줄씩 읽어오기 넣을 변수를 생성해준다.
				//예외부분을 넣어준다. (Add throw declaration)
				String line=br.readLine();
				//9. null이 나오면 종료하는 코드를 넣어 준다.
				//while이 무한으로 돌수도 있기때문이다.
				if(line==null)
					break;
				//10. 현재 line에는 ,가 들어가있는 내용들이 있다. split(",")사용
				//이것을 split을 이용해서 data라는 배열에 넣어줄거다.
				// 총 3가지 종류 여기에 배열[0]은 이름, 배열[1]은 국어, 배열[2]는 영어로 들어간다.
				/*
				 *  {이효리,78,90}
				 *  {강호동,48,89} 이런식으로 data에 저장이되고 우리는 각 배열의 인덱스 0,1,2를 뽑아올것이다.
				 */
				String []data=line.split(",");
				String name=data[0];
				int kor=Integer.parseInt(data[1]);
				int eng=Integer.parseInt(data[2]);
				
				//11. 이제 이 내용들을 sj[count]에 넣어준다.
				/*
				 * sj[1] = {이효리,78,90}
				 * sj[2] = {강호동,48,59}
				 * 으로 각각 나누어 넣어준다.
				 */
				// Ex_Sungjuk 생성자에 맞추어 넣어준다.
				sj[count]=new Ex_Sungjuk(name, kor,eng);
				count ++;
				
			}
			//12. br, fr을 닫아준다.
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//13. 자료에 없을 경우에 없다는 메세지를 넣어준다.
			System.out.println("파일에 없어요!");
		}
		
	}
	//14. 이제 메인으로 가기전에 위에 내용들을 여러번 부르기 귀찮으니 메소드를 이용해서
	//불러오자.
	
	public void dataList()
	{
		//15. 총 인원은 count로 불러오기
		System.out.println("총 "+count+"명");
		//16. 이름, 국어, 영어, 총점, 평균 순으로 출력하는 내용 만들기
		System.out.println("이름\t국어\t영어\t총점\t평균\t등급");
		System.out.println("=".repeat(50));
		//17. for문을 이용해서 각인원들의 내용들을 불어들이다. 불러들이는건 Ex_Sungjuk getter메소드
		//평균, 총점,등수는 따로 변수를 만들어 줘서 출력해야한다.
		//i는 count보다 작아야한다. 
		for (int i=0; i<count; i++)
		{
			//18. sj[i]가 Ex_Sungjuk s에 객체로 들어가도록 해준다
			/*
			 * s= {이효리,78,90},{강호동,48,59} 이런식으로 넣어주는것이다.
			 */
			Ex_Sungjuk s = sj[i];
			//19. 총점을 구한다.
			int tot = s.getKor()+s.getEng();
			//20. 평균을 구한다. (2과목만 있고, double로 타입지정)
			double avg= tot/2.0;
			//21. 등급 구하기
			String rank="";
			if(avg>=90)
			{
				rank="A";
			} else if(avg>=80)
			{
				rank="B";
			} else if(avg>=70)
			{
				rank="C";
			} else if(avg>=60)
			{
				rank="D";
			}else {
				rank="F";
			}
			//22. 내용 전체 출력
			System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()+"\t"+tot+"\t"+avg+"\t"+rank);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 23. Ex_Split 생성하기, 빨간줄이 나올 경우 add throws declaration해준다.
		Ex_Split ex = new Ex_Split();
		ex.dataList();
	}

}
