package package2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSender1 extends Thread {
	// 1. �����غ�
	// 2. ���� �����͸� byte[]�� �غ�
	// 3. �������� ���������͸� �Ǿ DatagramPacket �غ�
	// 4. 3�� 1�� �÷����� �߻�
	public void run() {
		Scanner sc = new Scanner(System.in);
		DatagramPacket packet1;
		DatagramPacket packet2;
		DatagramPacket packet3;
		DatagramPacket packet4;
		DatagramPacket packet5;
		try {
			System.out.println("ä�����α׷�!!");
			while (true) {
				String msg = "��!!!! : " + sc.next();
				// 1. �����غ�
				DatagramSocket socket = new DatagramSocket();
				// 2. ���� �����͸� byte[]�� �غ�

				byte[] buf = msg.getBytes();
				// 3. �������� ���������͸� �Ǿ DatagramPacket �غ�
				packet1 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.23"), 5000);
				packet2 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.55"), 9000);
				packet3 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.25"), 11000);
				packet4 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.26"),7000);
				packet5 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.45"), 8000);
				
				try {
					socket.send(packet1);
					socket.send(packet2);
					socket.send(packet3);
					socket.send(packet4);
					socket.send(packet5);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 4. 3�� 1�� �÷����� �߻�
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

/*
 * UDP ������ �����ϱ�
 * 
 * UDP�����͸� �����Ϸ���, UDP�����ʹ� ������ �����ͱ׷� �̶�� �θ��� ����Ⱑ ���󰡷��� Ȱ�ַΰ� �ʿ��Ѱ�ó�� UDP�����ͱ׷���
 * ���ư����� UDP�����ͱ׷��� ���� �� �ִ� Ȱ�ַΰ� �ʿ��ѵ� �׳༮�� UDP�����̴�
 * 
 * ���, �츮�� �� ��
 * 
 * 1. UDP���� �غ� 2. ���� ������ �غ� 3. ���� �����͸� UDP�����ͱ׷����� �غ� 4. �߻�!
 * 
 */