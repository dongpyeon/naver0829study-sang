package mygaspard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.Dbgaspard;

public class MygaspardDao {
	Dbgaspard db = new Dbgaspard();
	
	//전체 출력
	
	public List<MygaspardDto> getAllPerson()
	{
		List<MygaspardDto> list=new Vector<MygaspardDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = """
				SELECT *
				 FROM gaspard
				 ORDER BY num
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MygaspardDto dto = new MygaspardDto();
				dto.setNum(rs.getString("num"));
				dto.setGname(rs.getString("gname"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegisterday(rs.getTimestamp("registerday"));
			
				//list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		//void가 아니기에 list로 return을 해준다.
		return list;
	}
	
	//내용 보기
	public MygaspardDto getData(String num)
	{
		String sql = 
					"""
					SELECT *
					 FROM gaspard
					WHERE num = ? 
					""";
		
		MygaspardDto dto= new MygaspardDto();
		Connection conn= db.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setGname(rs.getString("gname"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegisterday(rs.getTimestamp("registerday"));
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
	public void insertGaspard(MygaspardDto dto)
	{
		String sql = """
					INSERT INTO gaspard
					(
					gname,
					gender,
					phone,
					addr,
					photo,
					registerday
					)
					VALUES
					(
					?,
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
			
			pstmt.setString(1, dto.getGname());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//update
	public void updateGaspard(MygaspardDto dto)
	{
		String sql = "";
		//사진은 수정하지 않았을 경우 null값을 가진다.
		//null이 아닐 경우에만 photo를 수정한다.
		if(dto.getPhoto()==null) {
			sql = """
					UPDATE gaspard
					 SET
					 gname=?,
					 phone=?,
					 addr=?,
					 photo=?
					WHERE num =?
				""";		
		}else {
			//사진을 수정하는 경우
			sql = """
					UPDATE gaspard
					 SET
					 gname=?,
					 phone=?,
					 addr=?,
					 photo="#1"
					WHERE num =?
				""".replace("#1",dto.getPhoto());
		}
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getGname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getNum());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//delete
}
