package afterclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex_Table1 extends JFrame {

	final static String FILENAME = "D:\\naver0829\\member1.txt"; // 정적변수(파일 저장할 위치 및 파일 이름)
	
	JTable table; //테이블
	DefaultTableModel model; //테이블 제목 칼럼 필드
	JTextField tfName, tfAge, tfAddr, tfGender; //텍스트 입력 필드
	JButton btnAdd; //버튼 필드
	
	public Ex_Table1(String title) {
		// TODO Auto-generated constructor stub
		super(title); //JFrame 창에 문자열 받는 생성자 호출
		this.setBounds(500, 100, 600, 600);
		this.setDesign(); //디자인 메서드 호출, 작성후 왼쪽옆 x자를 눌러서 메서드생성
				
		this.setVisible(true);
		
		//종료시 이벤트 발생 - 익명 내부 클래스 형태로 형성
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//창 종료전에 테이블의 내용을 member1.txt에추가하도록 하는 코드
				FileWriter fw=null;
				//파일을 읽어올때는 try catch문으로 만든다.
				try {
					// true로 넣을 경우 파일이 있을 경우 기존파일에 내용을 추가된다.(없을경우 새로 생성)
					fw=new FileWriter(FILENAME,true);
					//행의 갯수
					int row = table.getRowCount();// 테이블의 행의 갯수를count 한다.
					for(int i=0; i<row; i++)
					{
						//테이블 행을 i로 보면 i행의 0에는 이름 식으로 저장한다. 
						String name=(String) model.getValueAt(i, 0);
						String age=(String)model.getValueAt(i, 1);
						String addr=(String)model.getValueAt(i, 2);	
						String gender=(String)model.getValueAt(i, 3);	
						
						fw.write(name+","+age+","+addr+","+gender+"\n"); //해당 내용을 한줄에 ,로 넣어서 저장한다.
					}
				} catch (IOException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					}catch (IOException e1){
						e1.printStackTrace();
					}
				}
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	
	
	private void setDesign() {
		// TODO Auto-generated method stub
		//상단에 위치할 내용들
		// 넣기위해서는 패널을 생성한뒤 그 위에 넣어주어야 한다.
		JPanel p = new JPanel();
		//상단에 지정한 Text필드값을 JTextfiled로 칼럼의 크기를 생성해준다.
		tfName = new JTextField(4);
		tfAge = new JTextField(3);
		tfAddr = new JTextField(5);
		tfGender = new JTextField(4);
		btnAdd=new JButton("추가");
		
		//패널에 필드값 추가
		p.add(new JLabel("이름"));
		p.add(tfName);
		p.add(new JLabel("나이"));
		p.add(tfAge);
		p.add(new JLabel("주소"));
		p.add(tfAddr);
		p.add(new JLabel("성별"));
		p.add(tfGender);
		p.add(btnAdd);
		
		//패널 위치 및 내용들 추가
		this.add("North",p);
		
		//table 생성
		model= new DefaultTableModel(new String[] {"이름","나이","주소","성별"},0); //행의 갯수는 일단 0개로 설정
		table=new JTable(model); //모델의 테이블을 생성
		this.add("Center",new JScrollPane(table)); // 위치 및 스크롤 기능, 스크롤을 넣지 않을 경우 제목이 나오지 않는다.
		
		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() { //괄호안 action은 자동 생성으로 오버라이드 해준다.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//입력값을 백터 string타입으로 넣는다.
				Vector<String> data=new Vector<String>();
				//각 필드에 있는 text를 받아와 data에 넣어주기
				data.add(tfName.getText());
				data.add(tfAge.getText());
				data.add(tfAddr.getText());
				data.add(tfGender.getText());
				//addRow메서드로 행을 추가한다.
				//위에 있는 model에 맞추어 데이터를 넣는다.
				model.addRow(data);
				//일력을 한 후에는 값을 지워서 빈칸으로 만들어 준다.
				tfName.setText("");
				tfAge.setText("");
				tfAddr.setText("");
				tfGender.setText("");
			}
		});
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_Table1 t = new Ex_Table1("테이블생성");
	}

}
