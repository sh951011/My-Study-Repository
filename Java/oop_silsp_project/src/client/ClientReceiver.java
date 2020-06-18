package client;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� ä�����α׷� Ŭ���̾�Ʈ ���� Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientReceiver extends Thread implements ClientInterface {
	private SharedArea sArea;
	private DatagramPacket packet;
	private byte[] buf;
	private DatagramSocket socket;

	public ClientReceiver() {
		sArea=null;
		buf=new byte[512];
		
		try {
			socket=new DatagramSocket(CLIENT_PORT);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		packet=new DatagramPacket(buf,buf.length);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				socket.receive(packet);

				/* ����� */
				if(checkQuit(new String(buf))){
					return;
				}
				
				sArea.getTextArea().append(new String(buf) + "\n");
				//System.out.println(new String(buf));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkQuit(String str){
		if(str.toUpperCase().equals(CMD_QUIT)){
			return true;
		}
		return false;
	}
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
