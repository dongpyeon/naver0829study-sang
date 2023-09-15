package bit701.day0915;

import java.awt.Canvas;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Assignment extends JFrame {
	JButton btnAnimal, btnStar, btnFood, btnCar;
	String initImage="D:\\naver0829\\image\\연예인사진\\shinminah.jpg";
	Image image;
	MyCanvas myCanvas =new MyCanvas();
	
	public Assignment(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(300, 100);
		this.setSize(800, 800);
		
		this.setDesign();
		
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(Assignment.this, "프레임을 종료합니다.");
			System.exit(0);
			super.windowClosing(e);
		}
		});
		
	}
	
	//캔버스 내부 클래스
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if(image.getWidth(this)>=400)
				g.drawImage(image, 70, 10, 400, 450, this);
			else
				g.drawImage(image, 70, 10, this);
		}
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		btnAnimal=new JButton("동물(랜덤)");
		btnStar=new JButton("연예인(랜덤)");
		btnFood=new JButton("음식(랜덤)");
		btnCar=new JButton("shop(랜덤)");
		
		JPanel p=new JPanel();
		p.add(btnAnimal);
		p.add(btnStar);
		p.add(btnFood);
		p.add(btnCar);
		
		this.add(p,"North");
		
		//사진을 Image로 변환
		image=new ImageIcon(initImage).getImage();
		this.add(myCanvas,"Center");
		
		btnAnimal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num = (int)(Math.random()*8)+1;
				String animal = "D:\\naver0829\\image\\이쁜동물이미지\\C"+num+".png";		
				image=new ImageIcon(animal).getImage();
				myCanvas.repaint();
			}
		});
		
		btnStar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int num = (int)(Math.random()*20)+1;
				String star = "D:\\naver0829\\image\\연예인사진 (2)\\"+num+".jpg";		
				image=new ImageIcon(star).getImage();
				myCanvas.repaint();
			}
		});
		
		btnFood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num = (int)(Math.random()*12)+1;
				String food = "D:\\naver0829\\image\\음식사진\\"+num+".jpg";		
				image=new ImageIcon(food).getImage();
				myCanvas.repaint();
			}
		});
		
		btnCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String shop;
				int num = (int)(Math.random()*34)+1;
				if(num==24) {
					shop = "D:\\naver0829\\image\\shop\\"+num+".gif";							
				}else {
					shop = "D:\\naver0829\\image\\shop\\"+num+".jpg";												
				}
				image=new ImageIcon(shop).getImage();
				myCanvas.repaint();
			}
		});

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment a=new Assignment("랜덤이미지");
	}

}
