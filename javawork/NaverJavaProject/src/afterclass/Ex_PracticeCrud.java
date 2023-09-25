package afterclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Ex_PracticeCrud {
	DbPractice db= new DbPractice();
	Scanner sc= new Scanner(System.in);

	//메뉴 메서드
	public int getMenu() 
	{
		System.out.println("1.추가 2.삭제 3.수정 4.전체출력 5.검색 6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	//추가
	public void insertPractice()
	{
		System.out.println("이름을 입력하시오");
		String name = sc.nextLine();
		System.out.println("영어 점수를 입력하시오");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("국어 점수를 입력하시오");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.println("혈액형을 입력하시오");
		String blood = sc.nextLine();
		System.out.println("핸드폰번호를 입력하시오");
		String phone = sc.nextLine();
		System.out.println("주소를 입력하시오");
		String addr = sc.nextLine();

		String sql="""
				INSERT INTO practice
				VALUES (null,?,?,?,?,?,?,now())
				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt =null;

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, kor);
			pstmt.setString(4, blood.toUpperCase());
			pstmt.setString(5, phone);
			pstmt.setString(6, addr);

			pstmt.execute();
			System.out.println("加了");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}

	}

	//삭제 - 이름로 삭제
	public void deletePractice()
	{
		System.out.println("삭제할 이름은?");
		String name = sc.nextLine();

		String sql="""
					DELETE FROM practice
					WHERE name=?
				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("不存在的名字");
			else
				System.out.println("删除了");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}

	}

	//수정 - 번호로
	public void updatePracetice()
	{
		System.out.println("수정할 번호는?");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 이름?");
		String name = sc.nextLine();
		System.out.println("수정할 영어 점수?");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 국어 점수?");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 혈액형?");
		String blood = sc.nextLine();
		System.out.println("수정할 핸드폰번호?");
		String phone = sc.nextLine();
		System.out.println("수정할 주소?");
		String addr = sc.nextLine();


		String sql="""
					UPDATE practice
					SET
					name=?,
					eng=?,
					kor=?,
					blood=?,
					phone=?,
					addr=?
					WHERE num=?
				""";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, kor);
			pstmt.setString(4, blood.toUpperCase());
			pstmt.setString(5, phone);
			pstmt.setString(6, addr);
			pstmt.setInt(7, num);

			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("不存在的名字");
			else
				System.out.println("改写了");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}

	//조회
	public void selectAllPractice()
	{
		System.out.println("번호 \t이름 \t영어 \t국어 \t평균\t 혈액형\t 전화번호 \t주소\t작성일");
		System.out.println("=".repeat(90));

		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;

		String sql ="""
					SELECT *
					FROM practice
					ORDER BY num
				""";

		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			double avg;
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int eng=rs.getInt("eng");
				int kor=rs.getInt("kor");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				String writeday =rs.getString("writeday");

				avg=(eng+kor)/2.0;
				System.out.println(num+"\t"+name+"\t"+eng+"\t"+kor+"\t"+avg+"\t  "+blood+"\t"+phone+"\t"+addr+"\t"+writeday);
				System.out.println("=".repeat(90));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs,pstmt, conn);
		}	
	}

	//검색 - 핸드폰 뒷번호로
	public void searchPractice()
	{
		System.out.println("검색할 핸드폰 뒤에 4자리?");
		String phone = sc.nextLine();

		String sql="""
					SELECT *
					FROM practice
					WHERE RIGHT(phone,4)
					LIKE ?
					ORDER BY num
				""";

		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;

		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs=pstmt.executeQuery();
			System.out.println("검색 결과");

			int cnt=0;
			double avg;
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int eng=rs.getInt("eng");
				int kor=rs.getInt("kor");
				String blood=rs.getString("blood");
				String phone1=rs.getString("phone");
				String addr=rs.getString("addr");
				String writeday =rs.getString("writeday");
				avg = (eng+kor)/2;

				System.out.println(++cnt);
				System.out.println("번호:"+num);
				System.out.println("이름:"+name);
				System.out.println("영어:"+eng);
				System.out.println("국어:"+kor);
				System.out.println("평균:"+avg);
				System.out.println("혈액형:"+blood);
				System.out.println("핸드폰번호:"+phone1);
				System.out.println("핸드폰번호:"+addr);
				System.out.println("작성일자:"+writeday);
				System.out.println("=".repeat(45));

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs,pstmt, conn);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_PracticeCrud ex = new Ex_PracticeCrud();
		while(true)
		{
			int menu=ex.getMenu();
			switch(menu)
			{
			case 1:
				ex.insertPractice();
				break;
			case 2:
				ex.deletePractice();
				break;
			case 3:
				ex.updatePracetice();
				break;
			case 4:
				ex.selectAllPractice();
				break;
			case 5:
				ex.searchPractice();
				break;
			default:
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}

}
