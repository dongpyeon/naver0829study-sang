package mygaspard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.Dbgaspard;
import simpleboarddata.SimpleBoardDto;

public class GaspardBoardDao {

	Dbgaspard db = new Dbgaspard();
	
	//list
	public List<GaspardBoardDto> getAllList()
	{
		List<GaspardBoardDto> list = new Vector<GaspardBoardDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = 
				"""
				SELECT *
				 FROM gaspardboard
				""";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				GaspardBoardDto dto = new GaspardBoardDto();
				dto.setNum(rs.getString("num"));
				dto.setNum(rs.getString("writer"));
				dto.setNum(rs.getString("subject"));
				dto.setNum(rs.getString("content"));
				dto.setNum(rs.getString("photo"));
				dto.setNum(rs.getString("readcount"));
				dto.setNum(rs.getString("writeday"));
			
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
	//data
	public GaspardBoardDto getData(String num)
	{
		String sql =
				"""
				SELECT *
				 FROM gaspardboard
				WHERE num = ?
				""";
		GaspardBoardDto dto = new GaspardBoardDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setNum(rs.getString("writer"));
				dto.setNum(rs.getString("subject"));
				dto.setNum(rs.getString("content"));
				dto.setNum(rs.getString("photo"));
				dto.setNum(rs.getString("readcount"));
				dto.setNum(rs.getString("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	//insert
	public void insertBoard(GaspardBoardDto dto)
	{
		String sql = """
				INSERT INTO gaspardboad
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
	
	
	//삭제
	public void deleteBoard(String num)
	{
		String sql=
				"""
				DELETE FROM gaspardboard
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
	};
	
	//수정
	public void updateBoard(GaspardBoardDto dto)
	{
		String sql="";
		//사진은 수정하지 않았을 경우 null값을 가진다.
		//null이 아닐 경우에만 photo를 수정한다.
		if(dto.getPhoto()==null) {
			//사진 수정 안함
			sql=
					"""
					UPDATE gaspardboard
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
				UPDATE gaspardboard
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
	};

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
	
}
