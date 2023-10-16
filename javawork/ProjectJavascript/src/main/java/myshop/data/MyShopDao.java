package myshop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class MyShopDao {
	DbConnect db = new DbConnect();
	//전체 출력
	public List<MyShopDto> getAllSangpums()
	{
		List<MyShopDto> list = new Vector<MyShopDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = """
				SELECT *
				FROM myshop ORDER BY num;
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); //반드시 가져와야한다.
			
			while(rs.next())
			{
				MyShopDto dto=new MyShopDto();//반드시 while문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setPhoto(rs.getString("photo"));
				dto.setColor(rs.getString("color"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbCloase(rs, pstmt, conn);
		}
		return list;
	}
	
	//insert
	public void insertShop(MyShopDto dto)
	{
		String sql="""
					INSERT INTO myshop
					(sangpum,color,price,photo,writeday) 
					values(?,?,?,?,now))
					""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getPhoto());
			pstmt.setString(4, dto.getColor());
			//실행
			pstmt.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				db.dbCloase(pstmt, conn);
			}
		}
}