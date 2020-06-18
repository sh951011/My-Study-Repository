package package2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiver extends Thread {
	public void run() {
		// 1. ���� ��Ʈ�� ���� �þ����� ���� ��ü�� ����
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			byte[] buf = new byte[512];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			while (true) {
				
					socket.receive(packet);
					
					System.out.println(new String(buf).trim());

			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2. ���� �����͸� ���� �� ����Ʈ�迭�� �غ�

		// 3. 2�� ������Ѽ� �� ��Ŷ�� �غ�

		// 4. 3�� 1�� ���� ����� ������ ���
	}
}