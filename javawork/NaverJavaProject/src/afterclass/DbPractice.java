package afterclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbPractice {

	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public DbPractice()
	{
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류"+e.getMessage());
		}
	}

	public Connection getMysqlConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL,"root","1234");
		} catch (SQLException e) {
			System.out.println("MYSQL 연결 실패: "+e.getMessage());
		}
		return conn;
	}

	public void dbclose(PreparedStatement pstmt,Connection conn)
	{
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close하다가 오류:"+e.getMessage());
		}	
	}

	public void dbclose(ResultSet rs, PreparedStatement pstmt,Connection conn)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close하다가 오류:"+e.getMessage());
		}
	}
}
