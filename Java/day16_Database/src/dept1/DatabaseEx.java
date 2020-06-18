package dept1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseEx {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* ������ �Լ� */
	public DatabaseEx() throws ClassNotFoundException {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "scott";
		password = "tiger";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
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

	/* ���� */
	public void insert() {
		ArrayList Dept = new ArrayList();
		
		System.out.print("�μ���ȣ : ");
		Dept.add( sc.next());
		System.out.print("�μ���ġ : ");
		Dept.add( sc.next());
		System.out.print("�μ� �̸� : ");
		Dept.add( sc.next());

		insert_Logic(Dept);
	}

	public void insert_Logic(ArrayList Dept) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO DeptTest VALUES('" + Dept.get(0) + "','" +  Dept.get(1) + "','" +  Dept.get(2) + "')";

			
			int result = stmt.executeUpdate(sql);

			System.out.println(result + "���� ���� ���ԵǾ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ���� */

	/* ���� */
	public void delete() {
		System.out.print("�����Ͻ� �μ���ȣ�� �Է����ּ��� : ");
		String deptno = sc.next();

		delete_Logic(deptno);
	}

	public void delete_Logic(String deptno) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE DeptTest WHERE deptno=" + deptno;
			int result = stmt.executeUpdate(sql);

			System.out.println(result + "���� �μ��� �����Ǿ����ϴ�."); // executeQuery :
															// DQL
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ���� */

	/* ��ȸ */

	public void display(){
		String sql = "SELECT * FROM DeptTest";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+ rs.getString(3) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ��ȸ */

	/* ���� */
	public void update() {
		String sql = null;
		Statement stmt = null;
		int choice = 0;
		ArrayList Dept = new ArrayList();

		System.out.print("##�μ���ȣ : ");
		Dept.add(sc.next());

		System.out.println("## �ٲ� ������ �������ּ���");
		System.out.println("## 1. �μ���ȣ");
		System.out.println("## 2. �μ���ġ");
		System.out.println("## 3. �μ��̸�");
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);

		switch (choice) {
		case 1:
			System.out.print("�ٲ� �μ� ��ȣ : ");
			Dept.add(sc.next();
			update_Logic_ChangeNumber(Dept,stmt,sql);
			break;
		case 2:
			System.out.print("�ٲ� �μ� ��ġ : ");
			Dept.add(sc.next();
			update_Logic_ChangeLocation(Dept,stmt,sql);
			break;
		case 3:
			System.out.print("�ٲ� �μ� �̸� : ");
			Dept.add(sc.next();
			update_Logic_ChangeName(Dept,stmt,sql);
			break;
		default:
			break;
		}
	}

	public void update_Logic_ChangeNumber(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + " deptno = '" +  Dept.get(0) + "' WHERE deptno = " +  Dept.get(1);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update_Logic_ChangeLocation(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + "dept_location = '" + Dept.get(0) + "' WHERE deptno = " +Dept.get(1);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update_Logic_ChangeName(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + "dept_name = '" +Dept.get(0) + "' WHERE deptno = " +Dept.get(0);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ���� */

	/* SET & GET */

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* SET & GET */
}