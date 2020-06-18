package server;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� ä�����α׷� ���� �۽� Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UdpServerSender extends Thread  implements ServerInterface{
	private SharedArea sArea;
	private DatagramSocket socket;
	
	public UdpServerSender() {
		sArea=null;
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	/* Thread ���� �κ� start */
	/* Thread ���� �κ� start */
	/* Thread ���� �κ� start */
	@Override
	public void run() {
		try {
/* 
	�޼����� �ȵ��Դٸ� ������ wait ���°� �� ���̰� 
	�޼����� ���Դٸ� �ϴ� �޼����� ��ü������ �ѷ������ ���̱� ������
	Sender�� ��ü while�κ��� ����ȭ �κ����� �����Ѵ�.
*/
			while (true) {
				synchronized(sArea){
					Set<String> idToSet = sArea.client.keySet();		//	id �κи� Set���� ��ȯ -> Iterator�� ���� ��ȯ
					Iterator it = idToSet.iterator();									//	client ID �˻��� Iterator
					Set<String> testSet = sArea.client.keySet();	
					Iterator testIt = testSet.iterator();						
					
					/* ���� �޽����� ���Դٸ� */
					if (sArea.isReady) {
						while(testIt.hasNext()){
							String str = testIt.next().toString();
							System.out.println("ID : "+ str);
							System.out.println("IP : "+ sArea.client.get(str));
						}
						
						
						System.out.println(new String(sArea.msg).trim());
						byte[] buf =new byte[512];
						buf = new String(sArea.msg).trim().getBytes(); // Ŭ���̾�Ʈ�� ���� msg�� receive���� �ް� ���⼭ �ѷ��ش� 
						// clientIP�� �����س��� Ŭ���̾�Ʈ ip�� ������ ������ŭ ������
						
						while (it.hasNext()) { 
							 // buf�� ������ msg��  Ŭ���̾�Ʈ ip�� ������ ���� �غ� sArea.clientIP.get(sArea.it.next())��
							 //  Map������ clientIP���� sArea.it (clientIP�� Iterator)�� ���� Key ���� ID�� �̿��Ͽ� IP�� ã�´�
							DatagramPacket packet = new DatagramPacket(buf, buf.length,	
									InetAddress.getByName(sArea.client.get(it.next().toString())), CLIENT_PORT);
							socket.send(packet);	// packet �߻�! 
						}
						initiateSharedArea();	// �޽����� �ѷ��ְ� �� �� �ʱ�ȭ
					} else { 
						try {
							sArea.wait();	// �޽����� ������ �ʾҴٸ� ������ wait
						} catch (InterruptedException e) {
							System.out.println("Sender ����...");
							return;
						}
					}
					/* �������� */
					if(sArea.exit){
						return;
					}
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/* Thread ���� �κ� End */
	/* Thread ���� �κ� End */
	/* Thread ���� �κ� End */

	public void initiateSharedArea(){
		sArea.isReady = false;
		sArea.msg = null;
	}
	
	/* SharedArea ��ü ���� �޼��� */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}