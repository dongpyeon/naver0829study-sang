package afterclass;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//JFrame을 사용하기 위해서는 extend를 해주어야 한다.(JFrame유틸 import)
public class Practice_Swing extends JFrame{

	//JButton사용을 위해서는 해당 유틸도 import할것
	//먼저 버튼을 사용할 변수들을 넣어주자. 총 3개의 버튼을 만들예정
	JButton btn1, btn2, btn3;

	
	
	//String title을 하게 될 경우 main에다가 title내용을 넣어주어야 한다.
	public Practice_Swing(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		//프레임의 시작위치
		this.setLocation(300,300);
		//프레임의 너비, 높이
		this.setSize(300,300);
		//프레임 백그라운 컬러 설정
//		this.getContentPane().setBackground(new Color(200,95,85)); //color 유틸 import할것

		//화면으로 나오기 전에 디자인한 부분을 넣어주어야한다. 
		//그리고 method 자동 완성을 하면 아랫부분에 매서드가 만들어진다.
		this.setDesign(); 

		//화면으로 출력하는 부분(true)로 해야 보여진다.
		this.setVisible(true);

		//종료될때 나오는 프레임 만들기
		//이를 윈도우 이벤트라고 부른다.- 익명 내부 클래스 형태로 이벤트 구현해보자
		this.addWindowListener(new WindowAdapter() {
			// windowclosing을 자동 완성으로 하면 오바라이드 되면서 생성이된다.
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//alert와 같은 팝업창 - JOptionPane.showConfirmDialog(rootPane, e) 같은 형태이다.
				//프레임을 종료합니다라는 글이 나온다.
				JOptionPane.showMessageDialog(Practice_Swing.this, "프레임을 종료합니다.");
				//실제 종료
				System.exit(0); //정상 종료
				//해당 부분은 마지막에 실행되야하기에 마지막줄에 넣는다.
				super.windowClosing(e);
			}

		});
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		btn1=new JButton("버튼 1");// 버튼 생성
		//해당 버튼을 프레임에 추가
		//BorderLayout(기본) 인경우는 위치를 지정해야함,North,South,East,West,Center
		this.add(btn1,"North");
		btn2=new JButton("버튼 2");
		this.add(btn2,"South");
		btn3=new JButton("버튼 3");
		this.add(btn3,"East");
	}

	public static void main(String []args) {
		//Practice_Swing의 클래스 생성, 위에 매서드에 String title로 되어있기에 문자열을 넣어주어야 한다.
		Practice_Swing a=new Practice_Swing("버튼");
	}
}
