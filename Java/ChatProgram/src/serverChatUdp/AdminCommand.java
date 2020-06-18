package serverChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� ���� ��ɾ� Ŭ���� (UDP)
 * ������Ž��͵�
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AdminCommand extends Thread implements ServerInterface{
	private SharedArea sArea;
	Thread sender, receiver;
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String command = sc.next();
			int caseNum = whatCommand(command,sArea.ck);
			
			// ��� case�� ���� 
			switch(caseNum){
			case EXIT:
				System.out.println("AdminCommand ����...");
				noticeExitToAllClient();	//	���� ä�ù��� ��� �ο����� �������Ḧ �˸���
				sc.close();
				sender.interrupt();
				receiver.interrupt();
				return;
				
			case SHOW:
				showCurrentClient();
				break;
				
			case BAN:
				banUser();
				break;
			
			case ERROR:
				System.out.println("�������� �ʴ� ��ɾ��Դϴ� ^.^");
				break;
			default:
				System.out.println("SWITCH DEFAULT DETECT!");
				break;
			}
			// ��� case�� ���� 
		}
	}
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */
	/* Thread ���� �κ� */

	/* ���� Ŭ���̾�Ʈ IP�� �����ִ� �޼��� */
	public void showCurrentClient() {
		Set<String> idToSet = sArea.client.keySet();		//	Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ
		Iterator it = idToSet.iterator();		//	clientIP�� Iterator
		int count=0;
		System.out.println("##### ���� ������� Ŭ���̾�Ʈ�� IP ��� #####");
		while (it.hasNext()) {
			String currentID = it.next().toString();
			count++;
			System.out.println(count + "��° Client ID : " + currentID);
			System.out.println(count + "��° Client IP : " + sArea.client.get(currentID));
		}
		System.out.println("\n�� " + count + "���� Client ���� ��...");
		return;
	}

	/* ����� ��� Ŭ���̾�Ʈ���� ���� ���� �޼����� ������ �޼��� */
	public void noticeExitToAllClient(){
		DatagramSocket socket;
		Set<String> idToSet = sArea.client.keySet();		//	Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ
		Iterator it = idToSet.iterator();		//	clientIP�� Iterator
		try {
			socket = new DatagramSocket();
			while(it.hasNext()){
				String notice = "Server Down";
				DatagramPacket packet = new DatagramPacket(notice.getBytes(), notice.getBytes().length,	
						InetAddress.getByName(sArea.client.get(it.next().toString())), CLIENT_PORT);		
				socket.send(packet);	// packet �߻�! 			
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* ���� �� �޼��� */
	public void banUser(){
		DatagramSocket socket;
		Set<String> idToSet = sArea.client.keySet();		//	Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ
		Iterator it = idToSet.iterator();									//	clientIP�� Iterator
		Scanner sc = new Scanner(System.in);
		String id;
		boolean first = true;
		
		// ID�� �Է¹޾Ƽ� �������� �ʴ� ID��� �ٽ� �Է��� �޴´�. 
		do{
			if(first){	// ó���̸�
				System.out.print("������ ID : ");
				id = sc.next();
				first=false;
			}else{	// �߸��Է��ϸ�
				System.out.println("�߸��Է��ϼ̽��ϴ� �ٽ� ");
				System.out.print("������ ID : ");
				id = sc.next();
			}
		}while(!sArea.ck.checkIdExist(id));
		
		// ������� Ŭ���̾�Ʈ���� �˸� 
		try {
			socket = new DatagramSocket();
			String notice = "ADMIN : �� ���� ��";
			DatagramPacket packet = new DatagramPacket(notice.getBytes(), notice.getBytes().length,	
					InetAddress.getByName(sArea.client.get(id)), CLIENT_PORT);		
			socket.send(packet);	// packet �߻�! 			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* ������� Ŭ���̾�Ʈ���� Map���� ���� */
		sArea.client.remove(id);
		sc.close();
		return;
	}
	
	public int whatCommand(String command,Check ck){
		if(sArea.ck.checkServerExit(command)) return 0;			//	��������
		else if(sArea.ck.checkShow(command)) return 1;				//	���� ���� ���
		else if(sArea.ck.checkBanUser(command)) return 2;		//	����
		else if(sArea.ck.checkUserOut()) return 3;							//	������ ��������
		else return -1;																		//	�� ��
	}
	
	/* Set & Get */
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	
	public void setSender(Thread th){
		this.sender=th;
	}
	
	public void setReceiver(Thread th){
		this.receiver=th;
	}
	
	/* Set & Get */
}