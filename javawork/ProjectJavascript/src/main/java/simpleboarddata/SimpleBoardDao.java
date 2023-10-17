package simpleboarddata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class SimpleBoardDao {
	
	DbConnect db = new DbConnect();
	
	//목록
	public List<SimpleBoardDto> getAllList()
	{
		List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql = """
					SELECT *
					 FROM simpleboard
					 ORDER BY num desc
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SimpleBoardDto dto = new SimpleBoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//insert
	public void insertBoard(SimpleBoardDto dto)
	{
		String sql = """
					INSERT INTO simpleboard
					 (
					 writer, 
					 subject, 
					 content, 
					 photo, 
					 writeday
					 )
					 VALUES
					 (
					 ?,
					 ?,
					 ?,
					 ?,
					 now()
					 )
				""";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPhoto());
		
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	};
	
	//내용보기
	  public SimpleBoardDto getData(String num) {
	      
	      String sql = """
	                  SELECT *
	                    FROM SIMPLEBOARD
	                   WHERE NUM = ?
	                """;
	      
	      SimpleBoardDto dto = new SimpleBoardDto();
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         //바인딩
	         pstmt.setString(1, num);
	         //실행
	         rs=pstmt.executeQuery();

	         if(rs.next()){         
	            
	            dto.setNum(rs.getString("num"));
	            dto.setWriter(rs.getString("writer"));
	            dto.setSubject(rs.getString("subject"));
	            dto.setContent(rs.getString("content"));
	            dto.setPhoto(rs.getString("photo"));
	            dto.setReadcount(rs.getInt("readcount"));
	            dto.setWriteday(rs.getTimestamp("writeday"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return dto;
	   }
	
	//조회수 증가
	public void updateReadcount(String num)
	{
		String sql = """
					UPDATE simpleboard
					 SET readcount=readcount+1
					 WHERE num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt =null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//삭제
	public void deleteBoard(String num)
	{
		String sql=
				"""
				DELETE FROM simpleboard
				 WHERE num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,num);

			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//수정
	public void updateBoard(SimpleBoardDto dto)
	{
		String sql="";
		//사진은 수정하지 않았을 경우 null값을 가진다.
		//null이 아닐 경우에만 photo를 수정한다.
		if(dto.getPhoto()==null) {
			//사진 수정 안함
			sql=
					"""
					UPDATE simpleboard
					 SET
					  writer=?,
					  subject=?,
					  content=?
					 where num=?
					""";
		}else {
			//사진을 수정하는 경우
			sql=
				"""
				UPDATE simpleboard
				 SET
				  writer=?,
				  subject=?,
				  content=?,
				  photo='#1'
				WHERE num =?
				""".replace("#1", dto.getPhoto());
		}
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,dto.getWriter());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getContent());
			pstmt.setString(4,dto.getNum());

			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}
