package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex7_Canvas extends JFrame {
	//캔버스 멤버변수로 선언
	MyCanvas myCanvas=new MyCanvas();
	public Ex7_Canvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(500, 500);//프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.GREEN);//setBackground만하면 색상이 안바뀌기에 앞에 반드시 getContentPane해준다.
//		this.getContentPane().setBackground(new Color(200,145,57));//0~255의 rgb
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		
		this.setVisible(true);//true: 프레임을 보이게 하기, false:프레임 숨기기
	
		//윈도우 이벤트 발생 - 익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //x버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex7_Canvas.this,"프레임을 종료합니다.");
				//실제 종료
				System.exit(0);//정상 종료
				super.windowClosing(e);
			}
		});
	}
	
	//캔버스 내부 클래스 - 다중 상속이 불가하기때문에
	class MyCanvas extends Canvas
	{
		String ImageIcon1="D:\\naver0829\\image\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) { //paint 자동 완성 기능으로 오버라이드하기
			// TODO Auto-generated method stub
			super.paint(g);
			
			//원그리기
			g.setColor(new Color(210,135,99)); //선색
			g.drawOval(100, 20, 100, 100);//테두리선만 있는 원

			//채워진 원
			g.setColor(Color.orange);
			g.fillOval(200, 20, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(Color.pink);
			g.drawRect(50, 200, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(Color.pink);
			g.fillRect(200, 200, 100, 100);
			
			Image image1=new ImageIcon(ImageIcon1).getImage();
			//이미지 그리기
			g.drawImage(image1, 300, 220, this);
			
			//크기변경해서 출력
			g.drawImage(image1, 300, 30, 100, 100, this);
		}
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		this.add(myCanvas,"Center");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_Canvas s= new Ex7_Canvas("캔버스");

	}

}
