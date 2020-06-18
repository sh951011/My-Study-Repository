package chatPackage;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Class : ä�ù� Ŭ����
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Messenger extends JFrame implements ActionListener {
	private InetAddress inetAddress;	/* ������ IP�� �����ϱ� ���� ���� */
	private int port;	/* ������ PORT�� �����ϱ� ���� ���� */
	private MulticastSocket Socket;		/* packet �߻縦 ���� ��Ƽĳ��Ʈ socket */
	private DatagramPacket Packet;		/* �����͸� ������ ���� packet */
	private DatagramSocket dataSocket;	
	
	String userId;
	String userName;
	private JTextField textField;
	private JTextArea textArea;

	public Messenger(String id, String name, InetAddress ip, int p) throws UnknownHostException, IOException {
		inetAddress = ip;
		port = p;
		userName = name;
		userId = id;
		
		/* GUI ���� �κ� START */
		/* GUI ���� �κ� START */
		/* GUI ���� �κ� START */
		
		setTitle("SooHwan Chat Room");

		setBounds(200, 100, 900, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		textField = new JTextField();
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JButton banner = new JButton("");
		banner.setForeground(new Color(255, 255, 255));
		banner.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop\\"
				+ "��ȯ\\Workspace\\Java_Practice_Project\\src\\chatPackage\\banner2.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(850,70, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedImg);
		banner.setIcon(icon);
		banner.setBorderPainted(false);
		panel_1.add(banner);
		
		
		textField.addActionListener(this); /* textField�� ActionListener ���� */
		panel.add(textField); /* panel�� textField �߰� */
		this.setVisible(true); /* ���� ���� GUI ��� ȭ�鿡 ǥ�� */

		/* GUI ���� �κ� END */
		/* GUI ���� �κ� END */
		/* GUI ���� �κ� END */
		
		Runnable r = new Runnable() {
			public void run() {
				byte[] buffer = new byte[512];
				try {
					/* socket�� joinGroup�� ������� */
					Socket = new MulticastSocket(port);
					Socket.joinGroup(inetAddress);
					dataSocket = new DatagramSocket();
					/* ���������� �����Ͽ����ϴٸ� ���� */
					String connect = "[ " + userName + "�� �� �����ϼ̽��ϴ�. ����� exit ]";
					buffer = connect.getBytes();

					Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
					Socket.send(Packet);

					/* Receive �κ� */
					while (true) {
						Packet = new DatagramPacket(buffer, buffer.length);
						Socket.receive(Packet);		/* packet receive */
						String msg = new String(Packet.getData(), 0, Packet.getLength()); 	/* msg�� packet�� ���� message ���� */
						textArea.append(msg + "\n");	/* textArea�� msg append */
						textArea.setCaretPosition(textArea.getDocument().getLength());	/* scroll�� �߰� */
					}
					/* Receive �κ� */
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				} finally {
					Socket.close();
				}
			}
		};
		new Thread(r).start();
	}

	/* Send�� �����ϴ� �κ� */
	/* Ŭ���� ��ü�� ActionListener�� implements ���� */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String s = textField.getText();
		textField.setText(null);
		byte[] buffer = new byte[512];

		/* �Է��� ���� �����ô� �׳� ���� */
		if (s == null || s == "" || s == "\n"  || s.length() == 0) {
			return;
		} 
		/* exit �Է½� ���α׷� ���� */
		else if (s.equalsIgnoreCase("exit")) { /* exit�� ��,�ҹ��� ������� �Է� �� ���� */
			String connect = "[" + userName + "�� �� �����ϼ̽��ϴ�.]";
			buffer = connect.getBytes();
			Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
			try {
				Socket.send(Packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Socket.close();		/* ���� close */
			System.exit(0);	/* ���α׷� ���� */
		}
		/* EXIT üũ */
		
		/* Message Send */
		try {
			dataSocket = new DatagramSocket();
			String msg = "[" + userName + "]  : " + s;
			buffer = msg.getBytes();
			Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
			Socket.send(Packet);
		} catch (IOException ie) {
			System.out.println("send ����");
		} finally {
			dataSocket.close(); // ������ �����մϴ�.
		}
		/* Message Send */
	}
}