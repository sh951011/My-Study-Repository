package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerOut extends Thread implements ServerInterface{
	private Socket socket;
	Scanner sc;
	private SharedArea sArea;

	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	public void run() {
		sc = new Scanner(System.in);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			/* while */
			while (true) {
				synchronized (sArea) {
					threadWait(sArea);	//	������ wait();
					if (sArea.isReady) { // �غ� �Ǹ� ����, �ƴϸ� �ٽ� wait();
						sendMsgToClient(out,sArea);
						initializeSharedArea(sArea);
					}
				}
			}
			/* while */
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ServerOut Class 1");
		}

		sc.close();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 2");
		}
	}
	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	
	/* Ŭ���̾�Ʈ���� �޼����� �Ѹ� */
	private void sendMsgToClient(BufferedWriter out,SharedArea sArea) {
		String msg = sArea.msg; // �������� Ŭ���̾�Ʈ�� �޼��� ������
		try {
			out.write(msg + "\n");
			out.flush(); // out�� ��Ʈ�� ���ۿ� �ִ� ��� ���ڿ� ����
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 3");
		}
	}
	
	/* ������ Wait���·� ���� */
	private void threadWait(SharedArea sArea) {
		try {
			sArea.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 0");
		}
	}
	
	/* �����޸� �ʱ�ȭ */
	private void initializeSharedArea(SharedArea sArea) {
		sArea.isReady = false;
		sArea.msg=null;
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
