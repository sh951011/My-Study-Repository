package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerIn extends Thread implements ServerInterface{
	private Socket socket;
	private SharedArea sArea;

	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String msg = in.readLine();	//	�޽����� ����ö����� ���⼭ �����...
				clientBye(msg,sArea);
				synchronized (sArea) {	//	�޽����� ������� �޼����� ������
					forSendMsg(sArea, msg);	//	�޽����������� ���� ȣ��
				}
				System.out.println( "Ŭ���̾�Ʈ : " + msg);	//	Ŭ���̾�Ʈ�� �޼��� ���� Ȯ��
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ServerIn Class 0");
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.getMessage();
			System.out.println("ServerIn Class 1");
		}
	}
	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	
	/* Ŭ���̾�Ʈ ���� ����� */
	private void clientBye(String msg,SharedArea sArea) {
		if (msg.equalsIgnoreCase("bye")) { // Ŭ���̾�Ʈ�� bye��� ĥ ���
			System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ�� �Ф�");
			synchronized (sArea) {
				--sArea.clientNum;
			}
		}
	}

	/* msg�� ������ ���� ȣ�� */
	private void forSendMsg(SharedArea sArea, String msg) {
		sArea.msg = msg; // ����� �޼����� �����޸𸮿� ����
		sArea.isReady = true;
		sArea.notify(); // ���� �� Output�� �����
	}

	/* Set Method */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void setSharedArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set Method */
}
