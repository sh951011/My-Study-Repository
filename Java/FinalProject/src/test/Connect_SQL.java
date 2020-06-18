package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

public class Connect_SQL {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* ������ �Լ� */
	public Connect_SQL() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		username = "scott";
		password = "tiger";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("�����ͺ��̽��� ������ ���� �ʾҽ��ϴ�");
		} else {
			System.out.println("�����ͺ��̽��� ����Ǿ����ϴ�!!");
		}
	}
	/* ������ �Լ� */
	
	/* �޴��ڵ忡 �ش��ϴ� ������ �����´� */
	public void bring_SQL(int code,LinkedList component_name,LinkedList component_num,LinkedList component_min){
		String sql = "SELECT * FROME menu_component WHERE menu_code = " + code;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				component_name.add(rs.getString(2));
				component_num.add(rs.getInt(3));
				component_min.add(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
