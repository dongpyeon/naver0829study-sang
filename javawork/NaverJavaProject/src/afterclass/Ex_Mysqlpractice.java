package afterclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class DbConnect {

    static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

    public DbConnect() {
        // TODO Auto-generated constructor stub
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql 드라이버 오류" + e.getMessage());
        }
    }

    // getMysqlConnection 메소드를 DbConnect 클래스 외부로 이동
    public Connection getMysqlConnection() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(MYSQL_URL,"root","1234");
        } catch(SQLException e) {
            System.out.println("MYSQL 연결 실패: "+e.getMessage());
        }
        return conn;
    }

    //close #1
    public void dbClose(PreparedStatement pstmt, Connection conn) {
        try {
            pstmt.close();
            conn.close();
        } catch(SQLException | NullPointerException e) {
            System.out.println("close 하다가 오류:"+e.getMessage());
        }
    }

    //close #2
    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch(SQLException | NullPointerException e) {
            System.out.println("close 하다가 오류:"+e.getMessage());
        }
    }
}


public class Ex_Mysqlpractice {
	DbConnect db = new DbConnect();
	
	public void sawonInsert() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("1-100 사이 점수");
		int score=Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender=sc.nextLine();
		System.out.println("부서");
		String buseo=sc.nextLine();
		
		String sql="INSERT INTO sawon VALUES (null,?,?,?,?)";
		System.out.println(sql);
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		//statement
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			//실행
			pstmt.execute();
			System.out.println("sawon에 데이터 추가됨");
		}catch(SQLException e) {
			System.out.println("insert sql문 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_Mysqlpractice ex = new Ex_Mysqlpractice();
		ex.sawonInsert();
	}

}
