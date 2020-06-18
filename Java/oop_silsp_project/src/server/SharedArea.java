package server;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� �����޸� Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* ���� �ٸ� Ŭ���������� ���� ���� */
public class SharedArea {
	HashMap<String, String> client;
	byte[] msg;
	boolean isReady; 
	boolean exit; 
	Check ck;

	public SharedArea() {
		client = new HashMap();	// <ID,IP>
		msg = new byte[512];			// Server���� Receive�� Sender�� �����ϴ� �޼��� 
		isReady = false;						// ������ ����ȭ�� ���� ����
		exit = false;								// ���� ���Ḧ ���� ����
		ck = new Check();					// Server�� user ��ɾ üũ�ϱ� ���� ��ü ����
	}
}