package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGroupSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex3_MysqlGroupSawon() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("MysqL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MysqL 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void saWonBunseok()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			
			Statement stmt=null;
			ResultSet rs=null;
			
			String sql="select buseo,count(*) count, max(score) maxscore, min(score) minscore,avg(score) avgscore \r\n"
					+ "from sawon group by buseo";
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("부서\t인원수\t최고점수\t최저점수\t평균");
			System.out.println();
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int maxscore=rs.getInt("maxscore");
				int minscore=rs.getInt("minscore");
				int count=rs.getInt("count");
				double AVG=rs.getDouble("avgscore");
				
				System.out.println(buseo+"\t"+count+"\t"+maxscore+"\t"+minscore+"\t"+AVG);
			}
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패: "+e.getMessage());
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MysqlGroupSawon ex = new Ex3_MysqlGroupSawon();
		ex.saWonBunseok();

	}

}
