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
				dto.setNum(rs.getInt("num"));
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
}
