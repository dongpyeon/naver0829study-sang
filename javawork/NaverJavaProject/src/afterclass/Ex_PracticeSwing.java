package afterclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex_PracticeSwing extends JFrame{
	JTextField tfName, tfScore, tfPhone;
	JComboBox<String>cbBlood, cbJob;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearchB, btnSearchJ, btnAll;

	DbConnect db=new DbConnect();	

	public Ex_PracticeSwing() {
		// TODO Auto-generated constructor stub
		super("자격증 평가");
		this.setBounds(1000, 100, 900, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex_PracticeSwing.this,"종료하시겠습니까?"); //종료시 띄어질 창
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}


	private void setDesign() {
		// TODO Auto-generated method stub
		//상단
		tfName = new JTextField(4);
		tfScore = new JTextField(4);
		tfPhone = new JTextField(10);
		String []cbTitleBlood= {"A","B","O","AB"};
		cbBlood =new JComboBox<String>(cbTitleBlood);
		String []cbTitleJob= {"학생","직장인","CEO","무직","그 외"};
		cbJob= new JComboBox<String>(cbTitleJob);

		JPanel pTop = new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("성적"));
		pTop.add(tfScore);
		pTop.add(new JLabel("전화번호"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);
		pTop.add(new JLabel("직업"));
		pTop.add(cbJob);

		this.add("North",pTop);
		//하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearchB = new JButton("Blood조회");
		btnSearchJ = new JButton("이름조회");
		btnAll = new JButton("전체조회");

		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearchB);
		pBottom.add(btnSearchJ);
		pBottom.add(btnAll);

		this.add("South",pBottom);

		//버튼 액션
		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAllPerson();
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
				if(name.length()==0) {
					JOptionPane.showMessageDialog(Ex_PracticeSwing.this, "이름을 입력해주세요");
					return;
				}
				int score;
				try {
					score=Integer.parseInt(tfScore.getText());
					if(score<0 || score>100) {
						JOptionPane.showMessageDialog(Ex_PracticeSwing.this, "점수는 1-100사이 값을 넣어주세요");
						return;
					}
				}catch (NumberFormatException e1) {
					score=0;
				}

				String phone = tfPhone.getText();
				String blood = (String)cbBlood.getSelectedItem();
				String job = (String)cbJob.getSelectedItem();

				//db에 insert하는 메서드 호출
				insertPerson(name, score, phone, blood, job);
				//db로부터 다시 데이터를 가져와서 출력
				selectAllPerson();
				//입렵값 초기화
				tfName.setText("");
				tfScore.setText("");
				tfPhone.setText("");
			}
		});

		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				System.out.println(row); //선택 안했을 경우 -1
				if (row==-1)
				{
					JOptionPane.showMessageDialog(Ex_PracticeSwing.this, "삭제할 행을 선택해주세요");
				}else {
					//row행의 0번열이 num값, in로 받은걸 다시 string으로 변환해야함
					String num = table.getValueAt(row, 0).toString();
					deletePerson(num);
					selectAllPerson();
				}
			}
		});

		btnSearchB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String []sel_message= {
	                      "A",
	                      "B",
	                      "O",
	                      "AB"
	                };
	                String searchBlood = (String)JOptionPane.showInputDialog(
	                      null,
	                      "혈액형을을 선택하세요.",
	                      "혈액형 선택창.", 
	                      JOptionPane.INFORMATION_MESSAGE,
	                      null, 
	                      sel_message, 
	                      "두번째 메시지"
	               );
	               System.out.println("searchBlood  = " + searchBlood );
	            searchBlood(searchBlood);
			}
		});

		btnSearchJ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchName = JOptionPane.showInputDialog("검색할 이름을 입력해주세요");
				if(searchName==null)
					return;
				else
					searchPerson(searchName);
			}
		});


		//중단
		String []title= {"번호","이름","성적","등급","핸드폰번호","혈액형","직업","작성일"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//초기 db데이터 가져오기
		selectAllPerson();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//먼저 텍스트박스을 어디에 쓸것인지?
		//이름, 점수, 전화번호
		//콤보박스는 어떤것을 넣을것인지?
		//혈액형, 직업
		//버튼을 뭐로 만들것인지?
		//추가, 삭제, 검색 2가지 버전(직업별, 이름), 전체조회
		//디자인을 어떻게 할것인지?
		/*
		 * 위: 텍스트 박스 
		 * 중간: 테이블 나오게
		 * 아래: 버튼을 두어서 선택할 수 있게끔
		 */
		Ex_PracticeSwing ex = new Ex_PracticeSwing();
	}

	//버튼에 대한 기능 메서드(조회, 추가, 삭제, 검색B, 검색J)
	public void selectAllPerson()
	{
		//기존 테이블의 데이터를 지운다.
		tableModel.setRowCount(0);
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		String sql="""
					SELECT *
					FROM practice1
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String grade;
				if (score >= 90)
					grade = "A";
				else if (score >= 80)
					grade = "B";
				else if (score >= 70)
					grade = "C";
				else if (score >= 60)
					grade = "D";
				else
					grade = "F";
				String phone = rs.getString("phone");
				String blood = rs.getString("blood");
				String job = rs.getString("job");
				Timestamp ts = rs.getTimestamp("writeday");
				String writeday = sdf.format(ts);
				
				data.add(num);
				data.add(name);
				data.add(String.valueOf(score));
				data.add(grade);
				data.add(phone);
				data.add(blood);
				data.add(job);
				data.add(writeday);

				//반드시 넣어줘야지 내용이 출력된다.
				tableModel.addRow(data);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertPerson(String name, int score, String phone, String blood, String job)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = """
					INSERT INTO practice1
					VALUES
					(
					null,
					?,
					?,
					?,
					?,
					?,
					now()
					)
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, phone);
			pstmt.setString(4, blood);
			pstmt.setString(5, job);

			pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}


	}

	public void deletePerson(String num)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = """
					DELETE FROM practice1
					WHERE num = ?
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void searchBlood(String searchBlood)
	{
		tableModel.setRowCount(0);
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		String sql = """
					SELECT *
					FROM practice1
					WHERE blood = ?
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,searchBlood);
			rs=pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String grade;
				if (score >= 90)
					grade = "A";
				else if (score >= 80)
					grade = "B";
				else if (score >= 70)
					grade = "C";
				else if (score >= 60)
					grade = "D";
				else
					grade = "F";
				String phone = rs.getString("phone");
				String blood = rs.getString("blood");
				String job = rs.getString("job");
				Timestamp ts = rs.getTimestamp("writeday");
				String writeday = sdf.format(ts);

				data.add(num);
				data.add(name);
				data.add(String.valueOf(score));
				data.add(grade);
				data.add(phone);
				data.add(blood);
				data.add(job);
				data.add(writeday);

				//반드시 넣어줘야지 내용이 출력된다.
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchPerson(String searchName)
	{
		tableModel.setRowCount(0);
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		String sql = """
					SELECT *
					FROM practice1
					WHERE name 
					LIKE '%' ? '%'
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,searchName);
			rs=pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String grade;
				if (score >= 90)
					grade = "A";
				else if (score >= 80)
					grade = "B";
				else if (score >= 70)
					grade = "C";
				else if (score >= 60)
					grade = "D";
				else
					grade = "F";
				String phone = rs.getString("phone");
				String blood = rs.getString("blood");
				String job = rs.getString("job");
				Timestamp ts = rs.getTimestamp("writeday");
				String writeday = sdf.format(ts);

				data.add(num);
				data.add(name);
				data.add(String.valueOf(score));
				data.add(grade);
				data.add(phone);
				data.add(blood);
				data.add(job);
				data.add(writeday);

				//반드시 넣어줘야지 내용이 출력된다.
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
