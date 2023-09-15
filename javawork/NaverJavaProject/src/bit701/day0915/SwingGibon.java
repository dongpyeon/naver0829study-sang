package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame {

	public SwingGibon(String title) {
		// TODO Auto-generated constructor stub
		super(title);//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(300, 300);//프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.GREEN);//setBackground만하면 색상이 안바뀌기에 앞에 반드시 getContentPane해준다.
		this.getContentPane().setBackground(new Color(200,145,57));//0~255의 rgb
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		
		this.setVisible(true);//true: 프레임을 보이게 하기, false:프레임 숨기기
	
		//윈도우 이벤트 발생 - 익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //x버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(SwingGibon.this,"프레임을 종료합니다.");
				//실제 종료
				System.exit(0);//정상 종료
				super.windowClosing(e);
			}
		});
	}
	
	
	private void setDesign() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon s= new SwingGibon("안녕");

	}

}
