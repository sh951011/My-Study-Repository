package server;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� ä�� ���α׷� ���� Main Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
 */

public class ServerMain  implements ServerInterface{
	public static void main(String[] args) {
		SharedArea sArea = new SharedArea();
		UdpServerSender sSender = new UdpServerSender();
		UdpServerReceive sReceive = new UdpServerReceive();
		AdminCommand aCommand = new AdminCommand();
		
		/* ���� SharedArea ��ü�� �����ϰ� �� */
		sSender.setsArea(sArea);
		sReceive.setsArea(sArea);
		aCommand.setsArea(sArea);
		sArea.ck.setsArea(sArea);
		aCommand.setSender(sSender);
		aCommand.setReceiver(sReceive);
		/* ���� SharedArea ��ü�� �����ϰ� �� */
		
		try {
			/* Server Thread Start! */
			sSender.start();
			sReceive.start();
			aCommand.start();
			/* Server Thread Start! */
			
			/* Thread Return Together */
			sSender.join();
			sReceive.join();
			aCommand.join();
			/* Thread Return Together */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
}