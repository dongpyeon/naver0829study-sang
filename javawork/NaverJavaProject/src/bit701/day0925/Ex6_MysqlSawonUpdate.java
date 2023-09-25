package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex6_MysqlSawonUpdate {
	DbConnect db = new DbConnect();
	
	public void sawonUpdate()
	{
		Scanner sc = new Scanner(System.in);
		//name, scoore, buseo를 입력받은 후 num에 해당하는 name, score,buseo 수정하기
		//num이 없으면 해당 데이터가 없어요
		System.out.println("번호를 입력하세요");
		String num = sc.nextLine();
		System.out.println("수정할 이름은?");
		String name = sc.nextLine();
		System.out.println("수정할 점수는");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 부서는");
		String buseo = sc.nextLine();
		
		String sql ="UPDATE sawon SET name='"+name+"',score="+score+",buseo='"+buseo+"' WHERE num="+num+"";
		System.out.println(sql);				
		
		Connection conn = null;
		Statement stmt = null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==0)
				System.out.println("해당 데이터가 없습니다.");
			else
				System.out.println(name+"의 정보가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_MysqlSawonUpdate ex = new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

}
