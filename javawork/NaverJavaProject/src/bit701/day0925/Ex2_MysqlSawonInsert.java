package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex2_MysqlSawonInsert {
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
		
		String sql="INSERT INTO sawon VALUES (null,'"+name+"',"+score+",'"+gender+"','"+buseo+"')";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt=null;
		
		//db연결
		conn=db.getMysqlConnection();
		//statement
		try {
			stmt=conn.createStatement();
			//실행
			stmt.execute(sql);
			System.out.println("sawon에 데이터 추가됨");
		}catch(SQLException e) {
			System.out.println("insert sql문 오류:"+e.getMessage());
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_MysqlSawonInsert ex = new Ex2_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
