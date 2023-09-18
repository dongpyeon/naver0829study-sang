package bit701.day0918;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex2_Table extends JFrame{
	JTable table1;
	
	JTable table2;
	
	public Ex2_Table(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임종료해주는 메서드
		this.setDesign();
		this.setVisible(true);
		
	}
	private void setDesign() {
		// TODO Auto-generated method stub
		//table 2개를 넣기 위해서 2행1열로 레이아웃 변경
		this.setLayout(new GridLayout(2,1));
	
		//table생성
		//table1=new JTable(5,4);//5행 4열의 빈 테이블이 만들어진다.
		
		//제목과 3개의 빈행을 추가하고자 할 경우(Model을 이용)
		//제목을 직접 줄경우에는 String[]과 같이 배열을 줘야 한다.
		DefaultTableModel model=new DefaultTableModel(new String[] {"이름","나이","주소"},3);
		table1=new JTable(model);
		
		//this.add(table1);//제목이 안나오네?
		this.add(new JScrollPane(table1));//scroll이 가능하도록 만들어줘야 제목도 나온다.
	
		//table2에는 데이터를 넣어보자, 위에와 다른점은 위에는 빈 행을 3개 만들었지만
		//여기에서는 데이터를 넣어주기 때문에 따로 빈 행을 넣어줄 필요가 없다.
		String [][]data= {
				{"강부자","56","강남구"},
				{"이순재","67","여의도"},
				{"신구","56","제주도"},
		};
		table2=new JTable(data, new String[]  {"이름","나이","주소"});
		this.add(new JScrollPane(table2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_Table ex=new Ex2_Table("JTable");
	}

}
