package afterclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex_FileReader {

	static final String FILE1="D:/naver0829/afterclass.txt"; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr= null;
		BufferedReader br= null;
		
		try {
			fr=new FileReader(FILE1);
			br=new BufferedReader(fr);
			//fr에서 파일을 열어서 br로 파일 내용을 불러들인다.
			//이제 이 파일의 내용들을 한 줄씩 읽어보자
			while(true)
			{
				String line=br.readLine();
				// 한줄씩 읽어오는것들은 line변수로 넣어준다.
				//여기서 exception으로 예외를 넣어준다. 
				//try-catch 블록을 사용하여 IOException을 처리하면, 예외가 발생하더라도 프로그램이 graceful하게 처리되고, 
				//오류 메시지를 통해 문제를 식별할 수 있게 됩니다. 
				//이로써 프로그램의 안정성과 신뢰성을 높일 수 있습니다.
				if(line==null)
					break;
				System.out.println(line);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//파일을 열어서 받았으니 이번에는 닫아줘야하는데 역순으로 닫아줘야 한다.
		br.close();
		fr.close();

	}

}
