package bit701.day0926;

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

import db.DbConnect;

public class Ex2_SawonSwingCRUD extends JFrame {
	JTextField tfName, tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;

	DbConnect db= new DbConnect();

	public Ex2_SawonSwingCRUD() {
		// TODO Auto-generated constructor stub
		super("부서관리");
		this.setBounds(1000, 100, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				super.windowClosing(e);
			}
		});

	}


	private void setDesign() {
		// TODO Auto-generated method stub
		tfName = new JTextField(5);
		tfScore = new JTextField(5);
		String []cbTitle1 = {"남자","여자"};
		cbGender = new JComboBox<String>(cbTitle1);
		String []cbTitle2 = {"인사부","홍보부","교육부"};
		cbBuseo = new JComboBox<String>(cbTitle2);
		//상단
		JPanel pTop= new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("성적"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);

		this.add("North",pTop);

		//하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnAll = new JButton("전체조회");

		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);

		this.add("South",pBottom);


		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
				if (name.length()==0) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "이름을 입력해주세요.");
					return;
				}
				
				int score;
				try {
					score=Integer.parseInt(tfScore.getText());
					if(score < 0 || score > 100)
					{
						JOptionPane.showConfirmDialog(Ex2_SawonSwingCRUD.this, "점수는 0-100 사이값으로 입력하시오");
						return;
					}
				}catch (NumberFormatException e1) {
					score=0;//점수에 문자를 넣으면 그냥 0점으로
				}
					
				String gender = (String)cbGender.getSelectedItem();
				String buseo = (String)cbBuseo.getSelectedItem();
				
	
				//db에 insert하는 메서드 호출
				insertSawon(name, score, gender, buseo);
				//db로부터 다시 데이터를 가져와서 출력
				selectAllSawon();
				//입렵값 초기화
				tfName.setText("");
				tfScore.setText("");
			}
		});

		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				System.out.println(row); //선택 안했을 경우 -1
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택해주세요");
				}else {
					//row행의 0번열이 num값
					String num=table.getValueAt(row, 0).toString();
					deleteSawon(num);
					//삭제 후 데이터 다시 불러온다.
					selectAllSawon();
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchBuseo=JOptionPane.showInputDialog("검색할 부서명을 입력해주세요");
//				System.out.println(searchName);
				if(searchBuseo==null)
					return; //취소누를 경우 이벤트 종료
				else
					
					searchSawon(searchBuseo);//이름이 포함된 모든 데이터 테이블에 출력
				
			}
		});

		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAllSawon();
			}
		});


		//중앙
		String []title = {"번호","이름","점수","성별","부서"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//초기 db데이터 가져오기
		selectAllSawon();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_SawonSwingCRUD ex= new Ex2_SawonSwingCRUD();
	}

	public void insertSawon(String name, int score, String gender, String buseo)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql="""
				INSERT INTO sawon
				VALUES
				(
				null,
				?,
				?,
				?,
				?
				)
				""";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void deleteSawon(String num)
	{
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql="""
					DELETE FROM sawon
					WHERE
					num = ?
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectAllSawon()
	{
		tableModel.setRowCount(0);
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = """
					SELECT *
					FROM sawon
					ORDER BY num ASC
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				tableModel.addRow(data);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	public void searchSawon(String searchBuseo)
	{
		tableModel.setRowCount(0);
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String sql = """
					SELECT *
					FROM sawon
					WHERE buseo = ?
					ORDER BY num
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,searchBuseo);
			rs=pstmt.executeQuery();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				String num = rs.getString("num");
				String name1= rs.getString("name");
				String score= rs.getString("score");
				String gender= rs.getString("gender");
				String buseo= rs.getString("buseo");

				data.add(num);
				data.add(name1);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				//테이블 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
