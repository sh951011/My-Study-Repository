package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainEntry implements ServerInterface{
	public static void main(String[] args) {
		/* ���� ���� */
		ServerSocket listener=null;
		Socket socket=null;
		SharedArea obj = new SharedArea();
		boolean start = true;
		/* ���� ���� */
		
		try {
			listener = new ServerSocket(SERVER_PORT);
			while (true) {
				System.out.println("������ ��ٸ��� �ֽ��ϴ� .");
				socket=listener.accept();
				System.out.println("����Ǿ����ϴ�. ");		++obj.clientNum;	
				System.out.println("���� ����� Ŭ���̾�Ʈ ���� " + obj.clientNum + "�� �Դϴ�.");
				
				/* ù ����ø� ����Ǵ� �κ� */
				if (start) {
					ServerIn in = new ServerIn();
					ServerOut out = new ServerOut();
					
					/* SET */
					in.setSocket(socket);
					out.setSocket(socket);
					in.setSharedArea(obj);
					out.setSharedArea(obj);
					/* SET */
					
					/* Thread Start */
					in.start();
					out.start();
					/* Thread Start */
					start=false;
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("MainEntry Class 0");
		}
		
		try {
			listener.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MainEntry Class 1");
		}
		
	}
}
