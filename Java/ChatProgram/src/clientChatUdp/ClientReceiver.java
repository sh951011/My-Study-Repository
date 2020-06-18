package clientChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� Ŭ���̾�Ʈ ���� Ŭ���� (UDP)
 * ������Ž��͵�
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientReceiver extends Thread implements ClientInterface{
	private SharedArea sArea;
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(CLIENT_PORT);
			while (true) {
				if(sArea.quit){
					return;
				}
				byte[] buf = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				System.out.println(new String(buf));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
