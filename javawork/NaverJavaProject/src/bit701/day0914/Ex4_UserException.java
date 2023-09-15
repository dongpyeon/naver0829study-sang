package bit701.day0914;

import java.util.Scanner;

class NicknameException extends Exception
/*
 * NicknameException 클래스의 객체를 직접 생성하지 않아도 됩니다. 
 * 여기서 NicknameException은 자바에서 제공하는 예외 클래스(Exception 클래스의 하위 클래스)를 확장한 
 * 사용자 정의 예외 클래스입니다. 사용자 정의 예외 클래스는 일반적으로 예외를 생성하고 
 * 던지기 위한 목적으로 사용됩니다.
 */
{
	public NicknameException(String msg)
	{
		super(msg);
	}
}

//////
public class Ex4_UserException {

	public static void dataInput() throws NicknameException, InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		String nickName;
		System.out.println("닉네임이 무엇인가요?");
		nickName=sc.nextLine();
		if(nickName.equals("바보")||nickName.equals("이놈")) {
			throw new NicknameException("고운말을 씁시다.!!"); //강제로 예외 발생 (여기에 클래스 생성new가 있기때문에 따로 클래스생성하지 않아도 무방)
		}
		Thread.sleep(1000);
		System.out.println("당신의 닉네임이 "+nickName+" 이군요!");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			dataInput();
		} catch (NicknameException e) {
			System.out.println(e.getMessage());
		}
	}

}
