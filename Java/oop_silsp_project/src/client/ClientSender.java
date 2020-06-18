package client;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� ä�����α׷� Ŭ���̾�Ʈ �۽� Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
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
	private Thread receiver;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private Scanner sc;
	public ClientSender() {
		sArea=null;
		receiver=null;
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		sc = new Scanner(System.in);
	}
	
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	@Override
	public void run() {
		/* 
		 * �� ó�� ������ �� 
		 * �ڽ��� ���ϴ� ID�� ������ ������ 
		 *  ������ IP�� ID�� Key,Value�� �����Ѵ�
		 *  Value : IP , Key : ID
		 */
		String clientID=makeID();
		
		System.out.println("##### ������ �۽� ���� #####");	// ������� ������ٸ�, ������ �۽ű����� ����!
		
		try {
			while (true) {
				String userInput = sc.nextLine();
				
				checkQuit(userInput);	// quit�� �Է¹����� �����ϵ���
				
				String msg = clientID + " : "+userInput;
				byte[] buf = msg.getBytes();
				DatagramPacket packet =new DatagramPacket(buf, buf.length, 
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				
				/* ����� */
				if(sArea.isQuit()){
					cSenderFinish(packet,socket);
					sc.close();
					receiverFinish(receiver);
					return;	// ���Ḧ ���ϸ� ������ quit�� ������ �����Ѵ�.
				}
				
				socket.send(packet);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	
	/* ���� ���̵� ���� ���� */
	public String makeID(){
		String clientID="defaultID";
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
		return clientID;
	}
	
	/* ����ڰ� ����Ű���带 �Է��ߴ��� �˻��ϴ� �޼��� */
	public void checkQuit(String userInput){
		if(userInput.toUpperCase().equals(CMD_QUIT)){
			sArea.setQuit(true);
		}
		return;
	}
	
	/* cSender ����� */
	public void cSenderFinish(DatagramPacket packet,DatagramSocket socket){
		String q = CMD_QUIT;
		try {
			packet = new DatagramPacket(q.getBytes(), q.length(), 
					InetAddress.getByName(SERVER_IP), SERVER_PORT);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/* receiver ������ ���� */
	public void receiverFinish(Thread th){
		th.interrupt();
	}
	
	/* SET & GET */
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	
	public void setReceiver(Thread th){
		this.receiver=th;
	}
	
	/* SET & GET */
}