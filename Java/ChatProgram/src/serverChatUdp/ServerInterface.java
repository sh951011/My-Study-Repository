package serverChatUdp;

/*
 * 2019-02-05
 * ���� ä�����α׷� ���� �������� �������̽� (UDP)
 * ������Ž��͵�
 */

public interface ServerInterface {
	//	��� ��ɾ�
	public static final int ERROR=-1;
	public static final int EXIT=0;
	public static final int SHOW=1;
	public static final int BAN=2;
	public static final int USER_OUT=3;
	
	//	��Ʈ��ȣ
	public static final int SERVER_PORT=4000;
	public static final int CLIENT_PORT=3000;
}