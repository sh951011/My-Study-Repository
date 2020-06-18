package serverChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� ���� ����üũŬ���� (UDP)
 * ������Ž��͵�
 */

import java.util.Iterator;
import java.util.Set;

public class Check  implements ServerInterface{
	SharedArea sArea;
	/* ���������� üũ�ϴ� �޼��� */
	public boolean checkBanUser(String command){
		if (command.toUpperCase().equals("BAN")) {
			return true;
		}
		return false;
	}
	
	/* �ش� ID�� �����ϴ��� üũ�ϴ� �޼��� */
	public boolean checkIdExist(String id){
		Set<String> ipToSet = sArea.client.keySet();		//	Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ
		Iterator it = ipToSet.iterator();									//	clientIP�� Iterator
		while(it.hasNext()){
			if(id.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	

	/* ���� ip�� �̹� �־��� ip���� �˻� */
	public boolean checkIpExist(String ip) {
		Set<String> idToSet = sArea.client.keySet();		//	Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ
		Iterator it = idToSet.iterator();		//	clientIP�� Iterator
		while (it.hasNext()) {
			if (ip.equals(sArea.client.get(it.next())))
				return true;
		}
		return false;
	}
	
	/* �������Ḧ �ߴ��� �˷��ִ� �޼��� */
	public boolean checkUserOut() {
		if (sArea.msg.toString().toUpperCase().equals("QUIT")) {
			return true;
		} else
			return false;
	}
	
	/* ���� ���� Ű���尡 ���Դ��� Ȯ�� */
	public boolean checkServerExit(String command) {
		if (command.toUpperCase().equals("EXIT")) {
			sArea.exit = true;
			return true;
		}
		return false;
	}

	/* ���� Ŭ���̾�Ʈ ��� Ű���尡 ���Դ��� Ȯ�� */
	public boolean checkShow(String command) {
		if (command.toUpperCase().equals("SHOW")) {
			return true;
		}
		return false;
	}


	/* Set & Get */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set & Get */
}
