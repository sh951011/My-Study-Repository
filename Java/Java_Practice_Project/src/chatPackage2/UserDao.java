package chatPackage2;

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

	UserDao() {
		con = null;
		pstmt = null;
		rs = null;
		user = null;
		userList = null;
	}

	/* UserData �� ������ �ִ� ArrayList �� ��ȯ */
	public ArrayList<UserData> select() throws Exception {
		String sql = "SELECT * FROM CUSTOMER";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		userList = new ArrayList<>();
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
		String sql = "SELECT * FROM CUSTOMER";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			if (tf_JoinId.equals(rs.getString("ID"))) {
				return true;
			}
		}
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
		userList = this.select();
		for (UserData user : userList) {
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