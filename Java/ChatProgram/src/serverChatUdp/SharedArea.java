package serverChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� ���� �����޸� Ŭ���� (UDP)
 * ������Ž��͵�
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* ���� �ٸ� Ŭ���������� ���� ���� */
public class SharedArea {
	HashMap<String,String> client = new HashMap();		//	<ID,IP>
	byte[] msg = new byte[512];	// Server���� Receive�� Sender�� �����ϴ� �޼���
	boolean isReady=false;		// msg�� ���� ������ true
	boolean exit=false;	// ���� ���Ḧ ���� ����
	Check ck = new Check();
}