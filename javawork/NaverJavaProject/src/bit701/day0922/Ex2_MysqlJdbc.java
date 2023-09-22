package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex2_MysqlJdbc {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex2_MysqlJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("MysqL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MysqL 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void sawaonAlldatas()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			System.out.println("Mysql 연결 성공");
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패: "+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_MysqlJdbc ex= new Ex2_MysqlJdbc();
		ex.sawaonAlldatas();
	}

}
