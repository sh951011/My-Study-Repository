package Listener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public static final int FRAME_WIDTH=1280;
	public static final int FRAME_HEIGHT=720;
	
	public MyFrame(){
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�˶�");
		JButton mybtn = new JButton("��������?");
		mybtn.addActionListener(new MyBtnClickListener());
		this.add(mybtn);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
