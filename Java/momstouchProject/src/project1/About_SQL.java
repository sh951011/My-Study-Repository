package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class About_SQL {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* SQL���� ������ ���ִ� method */
	public void connect_SQL() {
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

	/* �޴��ڵ忡 �ش��ϴ� ������ SQL���� �������� method */
	public void bring_SQL(int code, LinkedList component_name, LinkedList component_num, LinkedList component_min) {
		String sql = "SELECT * FROM menu_component WHERE menu_code = " + code;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				component_name.add(rs.getString(2));
				component_num.add(rs.getDouble(3));
				component_min.add(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* �̸��� �ߺ��Ǵ� �͵��� ������ �����ְ� ����Ʈ���� ������ ���ִ� method */
	public void nameOverlap(LinkedList component_name, LinkedList component_num, LinkedList component_min) {
		for (int i = 0; i < component_name.size(); i++) {
			for (int j = i + 1; j < component_name.size(); j++) {
				/* component_name�� i��j index���� �̸��� ���ٸ� �Ʒ��� �����Ѵ� */
				if (component_name.get(i).toString().equals(component_name.get(j).toString())) {
					String str1 = component_num.get(i)
							.toString(); /* LinkedList -> String */
					Double num1 = Double
							.parseDouble(str1); /* String -> Double */
					String str2 = component_num.get(j)
							.toString(); /* LinkedList -> String */
					Double num2 = Double
							.parseDouble(str2); /* String -> Double */

					/* i��°�� j��°�� ���ٸ� �ű⿡ �ش��ϴ� �������� ���ؼ� i��°�� set�� ���ش� */
					component_num.set(i, num1 + num2);

					component_name.remove(j); /* 1. j��°�� ��� ����� */
					component_num.remove(j); /*
												 * 2. j��°�� ����� j+1��°���� ���� ���
												 * LinkedList���� ������ ������Ƿ�
												 */
					component_min.remove(
							j); /* 3. j--�� �������ν� ��ĭ�� �Ѿ������ ������ ������ �ʵ��� ���ش� */
					j--; /* <- ��� ����� ������ ����� */
				}
			}
		}
	}

	public void searchCode(Vector<String> codeBuffer, Vector<Integer> codeReceive) {
		for (int i = 0; i < codeBuffer.size(); i++) {
			String sql = "SELECT menu_code FROM menu WHERE menu_name = '" + codeBuffer.get(i)+"'";
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					codeReceive.addElement(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
