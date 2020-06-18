package chatProgram;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Class : ����Ŭ DB�� �����ϴ� Ŭ����
 */

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnector implements ChatInterface{
	private String url;
	private String username;
	private String password;
	private Connection con = null;
	
	/* Oracle Database�� �����ϴ� ������ */
	OracleDBConnector() {
		url=null;
		username=null;
		password=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* ���� �� ��ǻ�� IP�� SID�� ������� */
			url = "jdbc:oracle:thin:@" + DATABASE_IP +":1521:"+DATABASE_SID;	
			username = "scott";	/* DB Test ID */
			password = "tiger";	/* DB Test Password */
			con = DriverManager.getConnection(url, username, password); /* ���� */
			System.out.println(InetAddress.getLocalHost()); /* IP�� Ȯ���ϱ� ���� print */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Get Method */
	public Connection getCon() {
		return con;
	}
}