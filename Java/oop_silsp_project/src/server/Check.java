package server;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ��ɾ� üũ Ŭ����
 *  2014707073 ������Ű��а� ���ȯ
 */


import java.util.Iterator;
import java.util.Set;

public class Check  implements ServerInterface{
	SharedArea sArea;	// �����޸� ��ü
	
	public Check() {
		sArea=null;
	}
	
	/* ���������� üũ�ϴ� �޼��� */
	public boolean checkBanUser(String command){
		/* BAN�� ������ true ��ȯ */
		if (command.equalsIgnoreCase(CMD_BAN)) {	
			return true;	
		}
		return false;
	}	
	
	/* �������Ḧ �ߴ��� �˷��ִ� �޼��� */
	public boolean checkUserOut() {
		if (sArea.msg.toString().equalsIgnoreCase(CMD_QUIT)) {
			return true;
		} else
			return false;
	}
	
	/* ���� ���� Ű���尡 ���Դ��� Ȯ�� */
	public boolean checkServerExit(String command) {
		if (command.equalsIgnoreCase(CMD_EXIT)) {
			sArea.exit = true;
			return true;
		}
		return false;
	}

	/* ���� Ŭ���̾�Ʈ ��� Ű���尡 ���Դ��� Ȯ�� */
	public boolean checkShow(String command) {
		if (command.equalsIgnoreCase(CMD_SHOW)) {
			return true;
		}
		return false;
	}	
	
	/* �ش� ID�� �����ϴ��� üũ�ϴ� �޼��� */
	public boolean checkIdExist(String id){
		/* Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ */
		Set<String> ipToSet = sArea.client.keySet();		
		
		/* clientIP�� Iterator */
		Iterator it = ipToSet.iterator();									
		
		/* id�� �ش��ϴ� Key�� �ִ����� �˻� */
		while(it.hasNext()){
			if(id.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	

	/* ���� ip�� �̹� �־��� ip���� �˻� */
	public boolean checkIpExist(String ip) {
		/* Key�� Set���� ��ȯ -> Iterator�� ���� ��ȯ */
		Set<String> idToSet = sArea.client.keySet();
		
		/* clientIP�� Iterator */
		Iterator it = idToSet.iterator();
		
		/* ip�� �ش��ϴ� Key�� �ִ��� �˻� */
		while (it.hasNext()) {
			if (ip.equals(sArea.client.get(it.next())))
				return true;
		}
		return false;
	}

	/* �����޸� Set �޼��� */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
