package mygaspard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.Dbgaspard;

public class GaspardReplyDao {
	Dbgaspard db = new Dbgaspard();
	
	//insert
	public void insertReply(GaspardReplyDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql=
				"""
				INSERT INTO gaspardreply
				 VALUES (null,
				 			?,
				 			?,
				 			?,
				 			now())
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//delete
	public void deleteReply(String idx)
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
					DELETE FROM gaspardreply
					 WHERE idx = ?
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,idx);

			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//list
	public List<GaspardReplyDto> getBoardReply(String num)
	{
		List<GaspardReplyDto> list = new Vector<GaspardReplyDto>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = """
					SELECT *
					 FROM gaspardreply
					 WHERE num=?
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				GaspardReplyDto dto = new GaspardReplyDto();
				dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가  -- 중요
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
	
}
