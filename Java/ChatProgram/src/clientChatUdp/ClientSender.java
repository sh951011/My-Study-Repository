
package clientChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� Ŭ���̾�Ʈ �۽� Ŭ���� (UDP)
 * ������Ž��͵�
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSender extends Thread implements ClientInterface{
	private SharedArea sArea;
	DatagramSocket socket;
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String clientID="defaultID";
		try {
			socket=new DatagramSocket();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/* 
		 * �� ó�� ������ �� 
		  * �ڽ��� ���ϴ� ID�� ������ ������ 
		  *  ������ IP�� ID�� Key,Value�� �����Ѵ�
		  *  Value : IP , Key : ID
		  *   */
		/*
		try {
			System.out.print("���ϴ� ID�� �Է��ϼ��� : ");
			clientID = sc.nextLine();
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket loginPacket = new DatagramPacket(clientID.getBytes(),
					clientID.getBytes().length,
					InetAddress.getByName(SERVER_IP), SERVER_PORT);
			socket.send(loginPacket);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		System.out.println("##### ������ �۽� ���� #####");	// ������� ������ٸ�, ������ �۽ű����� ����!
		
		try {
			while (true) {
				/*
				String userInput = sc.nextLine();
				
				checkQuit(userInput);	// quit�� �Է¹����� �����ϵ���
				
				String msg = clientID + " : "+userInput;
				byte[] buf = msg.getBytes();
				DatagramPacket packet;
				
				if(sArea.quit){
					String q = "QUIT";
					packet = new DatagramPacket(q.getBytes(), q.length(), 
							InetAddress.getByName(SERVER_IP), SERVER_PORT);
					socket.send(packet);
					sc.close();
					return;	// ���Ḧ ���ϸ� ������ quit�� ������ �����Ѵ�.
				}
				
				packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, 
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				socket.send(packet);
				*/
				clientID = sc.nextLine();
				DatagramPacket loginPacket = new DatagramPacket(clientID.getBytes(),
						clientID.getBytes().length,
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				socket.send(loginPacket);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	
	
	
	/* ����ڰ� ����Ű���带 �Է��ߴ��� �˻��ϴ� �޼��� */
	public void checkQuit(String userInput){
		if(userInput.toUpperCase().equals("QUIT")){
			sArea.quit=true;
		}
		return;
	}

	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}