package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex1_oracleJdbc {
	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	//                                -    패키지      -.- 클래스 -
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public Ex1_oracleJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER); //Class.forName 단순 문자열을 클래스로 바꿔준다.
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류:"+e.getMessage());
		}  
	}
	
	public void shopAllDatas()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			System.out.println("오라클 연결 성공");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_oracleJdbc ex = new Ex1_oracleJdbc();
		ex.shopAllDatas();
	}

}
