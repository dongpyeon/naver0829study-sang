package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_MysqlJdbc {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex2_MysqlJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("MysqL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MysqL 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void sawaonAlldatas()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			
			Statement stmt=null;
			ResultSet rs=null;
		      String sql = null;
		      sql = "SELECT * "
		         + "FROM sawon "
		         + "ORDER BY num";
			
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("번호\t이름\t점수\t성별\t부서");
			System.out.println();
			int total=0;
			int count=0;
			double avg;
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int score=rs.getInt("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("gender");
				
				total += score;
				count++;
				
				System.out.println(num+"\t"+name+"\t"+score+"\t"+gender+"\t"+buseo);
			}
			System.out.println("\n총 점수: "+total);
			avg=(double)total/count;
			System.out.printf("평균: %3.1f\n",avg);
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
