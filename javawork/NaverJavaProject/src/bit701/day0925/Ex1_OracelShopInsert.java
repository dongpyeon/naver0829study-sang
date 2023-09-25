package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex1_OracelShopInsert {
	DbConnect db = new DbConnect();
	
	public void shopInsert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명 입력");
		String sang=sc.nextLine();
		
		System.out.println("가격 입력");
		int price=Integer.parseInt(sc.nextLine());
		
		System.out.println("색상 입력");
		String color=sc.nextLine();
		
		String sql="INSERT INTO shop VALUES (seq_shop.nextval,'"+sang+"',"+price+",'"+color+"')";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		//db연결
		conn=db.getOracleConnection();
		//statement
		try {
			stmt=conn.createStatement();
			//실행
//			boolean b=stmt.execute(sql);//반환타입이 boolean,(false:실행결과가 없을 경우)
//			int n=stmt.executeUpdate(sql); //반환타입이 int
//			System.out.println(b+","+n);
//			System.out.println("데이터 두번 insert됨");

			stmt.execute(sql);
			System.out.println("shop에 데이터 추가됨");
			
		}catch(SQLException e) {
			System.out.println("insert sql문오류:"+e.getMessage());			
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracelShopInsert ex = new Ex1_OracelShopInsert();
		ex.shopInsert();
	}

}
