package serverChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� ���� ���� Ŭ���� (UDP)
 * ������Ž��͵�
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;

public class UdpServerReceive extends Thread implements ServerInterface {
	private SharedArea sArea;

	/* Thread ���� �κ� start */
	/* Thread ���� �κ� start */
	/* Thread ���� �κ� start */
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(SERVER_PORT);
			while (true) {
				DatagramPacket packet = new DatagramPacket(sArea.msg, sArea.msg.length);
				socket.receive(packet);
				System.out.println(sArea.msg);
				/* ���� ���� ip���� üũ */
				if (!sArea.ck.checkIpExist(packet.getAddress().getHostAddress().toString())) {
					newUser(packet);
				}
				synchronized (sArea) {
					// System.out.println(packet.getAddress() + "�κ��� ���ο� �޼���
					// ����");
					wakeSender(); // Sender ����

					/* ip�� �������Ḧ �Ͽ����� üũ */
					if (sArea.ck.checkUserOut()) {
						userOut(packet, socket);
					}

					/* ���� */
					if (sArea.exit) {
						sReceiveFinish();
						return;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Thread ���� �κ� End */
	/* Thread ���� �κ� End */
	/* Thread ���� �κ� End */

	/* �޼����� �ް� �� Sender�� ���� */
	public void wakeSender() {
		synchronized (sArea) {
			sArea.isReady = true;
			sArea.notify();
			
		}
	}

	/* ip�� ID�� ã�� �޼��� */
	public String findIdByIp(String ip) {
		Set<String> idToSet = sArea.client.keySet(); // Key�� Set���� ��ȯ ->
														// Iterator�� ���� ��ȯ
		Iterator it = idToSet.iterator(); // clientIP�� Iterator
		while (it.hasNext()) {
			String id = it.next().toString(); // �ӽ÷� id�� Ŭ���̾�Ʈ ID�� ����Ѵ�
			if (ip.equals(sArea.client.get(id))) { // id�� clientIP�� IP���� �Ѱܹ���
													// ip�� ���Ͽ�
				return id; // ��ġ�ϴ� ip�� ã�´ٸ� �ش� id�� return
			}
		}
		System.out.println("findIdByIp���� ERROR!!"); // while���� ������� ������ �����̹Ƿ�
													// sysout���� Ȯ��
		return "ERROR";
	}

	/* ���ο� ������ ������ �� */
	public void newUser(DatagramPacket packet) {
		synchronized (sArea) {
			sArea.client.put(new String(sArea.msg).trim(), packet.getAddress().getHostAddress().toString());
			System.out.println(packet.getAddress().getHostAddress().toString() + " : ���ο� ip�� �����Ͽ����ϴ�.");
			/*
			 * ���ο� ip�� ������ Map ������ client�� ( <Key,Value> == <ID, IP> ) ����
			 * <K,V>�� �߰��Ѵ�
			 */
		}
	}

	/* ���� ���� ���� �� */
	public void userOut(DatagramPacket packet, DatagramSocket socket) {
		String outIP = packet.getAddress().toString();
		String outID = findIdByIp(outIP); // ���������ϴ� ip�� �̿��Ͽ� id�� ã�´�
		System.out.println("���������� IP : " + outIP);
		System.out.println("���������� ID : " + outID);

		// Ŭ���̾�Ʈ ���Ḧ ����
		String quit = "QUIT";
		try {
			DatagramPacket quitPacket = new DatagramPacket(quit.getBytes(), quit.length(), InetAddress.getByName(outIP),
					CLIENT_PORT);
			socket.send(packet); // packet �߻�!
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		synchronized (sArea) {
			sArea.client.remove(outID);
		}
		/*
		 * ���������ϴ� ip�� id�� ã�Ƽ� ������ �˸��� clientIP���� �����Ѵ�
		 */
	}

	/* sReceive ���� */
	public void sReceiveFinish() {
		System.out.println("##### ���� #####");
		synchronized (sArea) {
			sArea.notify();
		}
	}

	/* Set & Get */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set & Get */
}