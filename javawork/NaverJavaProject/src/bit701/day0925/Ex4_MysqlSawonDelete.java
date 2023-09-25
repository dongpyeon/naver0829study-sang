package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db = new DbConnect();
	
	public void sawonDelete()
	{
		//사원명 입력 후 해당 사원 삭제
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원은?");
		String sawon=sc.nextLine();
		String sql="DELETE FROM sawon WHERE name LIKE '%"+sawon+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			
			//결과 값이 0이면 xxx은 없습니다.
			//           n이면 xxx사원정보를 삭제했습니다.
			if (n==0)
				System.out.println(sawon+"은 없습니다.");
			else
				System.out.println(sawon+"사원정보를 삭제했습니다.("+n+")");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex = new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
