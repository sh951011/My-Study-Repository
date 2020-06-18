package multicastChat;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Interface : ���������� ����ϴ� ����������� ����
 */

public interface ChatInterface {
	public static final int PORT=8000;		/* ��ſ� ���Ǵ� Port */
	public static final String DATABASE_IP="192.168.56.1";		/* DataBase�� ����Ǿ� �ִ� PC IP */
	public static final String MULTICAST_IP="224.128.1.5";		/* ��Ƽĳ��Ʈ ��ſ� ���Ǵ� IP */
	public static final int EXCEPTION_OCCUR=0;	/* Exception�� �߻����� �� ��ȯ�� */
	public static final String DATABASE_SID="orcl";
}
