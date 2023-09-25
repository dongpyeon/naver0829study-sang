package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() 
	{
		System.out.println("1.추가    2.삭제    3.수정    4.전체출력    5.검색    6.종료");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	//insert
	public void insertStudent()
	{
		System.out.println("이름?");
		String name = sc.nextLine();
		System.out.println("혈액형은?");
		String blood = sc.nextLine();
		System.out.println("핸드폰 번호는?");
		String phone = sc.nextLine();
		
		String sql = """
					INSERT INTO student
					VALUES (null,?,?,?,now())
				""";
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			
			pstmt.execute();
			System.out.println("thêm học sinh rồi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}	
	}
	
	//delete - 이름으로 삭제
	public void deleteStudent()
	{
		System.out.println("삭제할 학생이름은?");
		String name = sc.nextLine();
		
		String sql="""
					DELETE FROM student
					WHERE name = ?
				""";
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("không có học sinh này ở trên hệ thông");
			else
				System.out.println(name+"이 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//update - 번호로 이름, 혈액형, 핸드폰 수정
	public void updateStudent()
	{
		System.out.println("수정할 학생 번호는?");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 학생 이름은?");
		String name = sc.nextLine();
		System.out.println("수정할 학생 혈액형은?");
		String blood = sc.nextLine();
		System.out.println("수정할 학생 핸드폰번호는?");
		String phone = sc.nextLine();
		
		String sql = """
					UPDATE student
					SET 
					name=?,
					blood=?,
					phone=?
					WHERE num=?
				""";
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setInt(4, num);
			
			int n =pstmt.executeUpdate();
			if(n==0)
				System.out.println("找不到那个学生，不存在");
			else
				System.out.println("改写完了");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	//전체 출력
	public void selectAllStudent()
	{
		System.out.println("번호\t이름\t혈액형\t  핸드폰번호\t작성일");
		System.out.println("=".repeat(45));
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = """
					SELECT *
					FROM student
					ORDER BY num
				""";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); //방법3
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
//				String writeday=rs.getString("writeday");//방법1
				Timestamp ts=rs.getTimestamp("writeday");//방법2
//				System.out.println(num+"\t"+name+"\t  "+blood+"\t"+phone+"\t"+writeday); //방법1
//				System.out.println(num+"\t"+name+"\t  "+blood+"\t"+phone+"\t"+ts); //방법2
				System.out.println(num+"\t"+name+"\t  "+blood+"\t"+phone+"\t"+sdf.format(ts)); //방법3
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//search - 번호 끝 4자리로 검색
	public void searchStudent()
	{
		System.out.println("검색할 핸드폰 뒤에 4자리?");
		String phone = sc.nextLine();
	
		//조원분이 알려준 쿼리문 (좀 더 명확하다.)
		String sql = """
					SELECT *
					FROM student
					WHERE RIGHT(phone,4)
					LIKE ?
					ORDER BY num
				""";
		/*내꺼
	      String sql = """
	               SELECT *
	               FROM student
	               WHERE phone
	               LIKE'_________%' ?
	            """;
		*/
		
		/* 강사님
		 * pstmt.setString(1, "%"+searchPhone);
		 */
		
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs=pstmt.executeQuery();
			System.out.println("검색 결과");
			
			int cnt = 0;
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone1=rs.getString("phone");
				String writeday =rs.getString("writeday");
				
				System.out.println(++cnt);
				System.out.println("번호:"+num);
				System.out.println("이름:"+name);
				System.out.println("혈액형:"+blood);
				System.out.println("핸드폰번호:"+phone1);
				System.out.println("작성일자:"+writeday);
				System.out.println("=".repeat(45));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex=new Ex9_StudentCrud();
		while(true)
		{
			int menu=ex.getMenu();
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchStudent();
				break;
			default:
				System.out.println("종료합니다.");
				System.exit(0);
			}
			System.out.println("=".repeat(50));
		}
	}

}
