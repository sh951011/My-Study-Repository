package ex03.thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class GraphicThread extends JFrame implements Runnable{
	// 	Frame : window
	int num,x,y;
	Color color;
	Random random;

	public GraphicThread(int num){	// �Ű����� 1�� ������ �Լ�,	������� �ʱ�ȭ
		this.num=num;
		color = Color.darkGray;
		random = new Random();
		setSize(500,400);	// ������(ȭ��)ũ�� - �ʺ�, ����
		setVisible(true);	// ȭ�� �����ֱ�
		setLocation(300,150);	// â�� ��ǥ �̵����ֱ�
		setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �ݱ�
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}

	public void run(){	// ������ ������(�����)
		Rectangle rect = getBounds();
		
		for(int i=0;i<num;i++){
			x = random.nextInt(rect.width);
			y= random.nextInt(rect.height);
			
			repaint();
			
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
/*		GraphicThread gt = new GraphicThread(10);
		Thread t1 = new Thread(gt);*/
		new Thread(new GraphicThread(2000)).start();
		
		//start();
	}
}