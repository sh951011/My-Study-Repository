package multicastChat;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Class : SQL Query�� ���� Ŭ����
 */

import java.awt.EventQueue;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao implements ChatInterface {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	UserData user;
	ArrayList<UserData> userList;

	/* UserDao ������ */
	UserDao() {
		con = new OracleDBConnector().getCon();
		pstmt = null;
		rs = null;
		user = null;
		userList = null;
	}
	

	/* UserData �� ������ �ִ� ArrayList �� ��ȯ */
	public ArrayList<UserData> select() throws Exception {
		/* ���� Query �� */
		String sql = "SELECT * FROM CUSTOMER";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		userList = new ArrayList<>();
		
		/* Database Table���� */
		/* id,pw,name�� �޾ƿͼ� */
		/* UserData�� ��ü�� ���� */
		while (rs.next()) {
			user = new UserData();
			user.setId(rs.getString("ID"));
			user.setPw(rs.getString("PW"));
			user.setName(rs.getString("NAME"));
			userList.add(user);
		}
		return userList;
	}

	public boolean idAlreadyExist(String tf_JoinId) throws SQLException {
		/* ���� Query�� */
		String sql = "SELECT ID FROM CUSTOMER";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		/* TABLE���� ID�鸸 �޾ƿͼ� �˻� */
		while (rs.next()) {
			/* �Ѱܹ��� ID�� ������ true ��ȯ */
			if (tf_JoinId.equals(rs.getString("ID"))) {
				return true;
			}
		}
		/* �Ѱܹ��� ID�� �ٸ��� false ��ȯ */
		return false;
	}

	/* ȸ�����Կ� �����ϰ� �ȴٸ� �߻��Ǵ� �޼��� */
	public int insert(String id, String pw, String name) {
		int loginOk;
		try {
			String sql = "INSERT INTO CUSTOMER VALUES ('" + id + "','" + pw + "','" + name + "')";
			pstmt = con.prepareStatement(sql);
			loginOk = pstmt.executeUpdate();
		} catch (Exception e) {
			return EXCEPTION_OCCUR;
		}
		return loginOk;
	}

	/* ȸ�����ԵǾ����� Ȯ���ϱ� ���Ͽ� ���� �޼��� */
	public boolean loginCheck(String id, String pw) throws Exception {
		userList = this.select(); /* ��� id, pw data�� ���� */
		for (UserData user : userList) { // ���鼭 ��ġ�ϴ� data�� �ִ��� Ȯ��
			if (id.equals(user.getId()) && pw.equals(user.getPw()))
				return true;
		}
		return false;
	}

	/* �α����� ���������� �߻� */
	public void loginSuccess(String id) throws Exception {
		for (UserData user : userList) {
			if (id.equals(user.getId())) {
				String loginName = user.getName();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							/* IP �ּ�(224.0.0.1 ~ 239.255.255.255) �� ǥ�� UDP ��Ʈ ��ȣ�� ���� => �߿��� */
							InetAddress address = InetAddress.getByName(MULTICAST_IP); // ��Ƽĳ��Ʈ �׷� ��Ģ!!
							new Messenger(id, loginName, address, PORT);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				break;
			}
		}
	}
}