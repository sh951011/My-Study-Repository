package dept3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/* ������ �Լ� */
public class Gogaeck {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* ������ �Լ� �����ͺ��̽��� ���� ��� */
	public Gogaeck() {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
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

	/* ���� UI */
	public void insert() {
		String sql = "SELECT * FROM gogaeck";
		
		System.out.print("����ȣ : ");
		int gno=sc.nextInt();
		System.out.print("���̸� : ");
		String gname=sc.next();
		System.out.print("�ֹι�ȣ : ");
		String jumin=sc.next();
		System.out.print("���ϸ��� : ");
		int mileage=sc.nextInt();
		
		System.out.println(insert_Logic(gno,gname,jumin,mileage,sql) + "���� ���� ���ԵǾ����ϴ�.");
	}
	/* ���� UI */

	/* ���� LOGIC */
	public int insert_Logic(int gno,String gname,String jumin,int mileage,String sql) {
		boolean gno_Exist=false;
		boolean isNot13=false;
		Statement stmt = null;
		/*  gno �ߺ�üũ */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getInt(1)){
					gno_Exist=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*  gno �ߺ�üũ */
		
		if(gno_Exist){
			throw new GnoAlreadyExistException();
		}
		
		
		if(jumin.length() != 13){
			isNot13=true;
		}
		if(isNot13){
			throw new isNotJuminException();
		}

		try {
			sql = "INSERT INTO gogaeck VALUES('" + gno + "','" + gname + "','" + jumin + "','"+ mileage + "')";

			int result = stmt.executeUpdate(sql);

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* ���� LOGIC */

	/* ���� UI */
	public void delete() {
		System.out.print("�����Ͻ� ����ȣ�� �Է����ּ��� : ");
		int gno = sc.nextInt();

		System.out.println(delete_Logic(gno) + "���� �μ��� �����Ǿ����ϴ�.");
	}
	/* ���� UI */

	/* ���� LOGIC */
	public int delete_Logic(int gno) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE gogaeck WHERE GNO=" + gno;
			int result = stmt.executeUpdate(sql);

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* ���� LOGIC */

	/* ��ȸ */

	public void display() {
		String sql = "SELECT * FROM gogaeck";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ��ȸ */

	/* ���� UI */
	public void update() {
		String sql = null;
		Statement stmt = null;
		int choice = 0;
		int gno=0,change_gno=0,change_mileage=0;
		String change_gname=null,change_jumin=null;
		

		System.out.print("##����ȣ : ");
		gno=sc.nextInt();

		System.out.println("## �ٲ� ������ �������ּ���");
		System.out.println("## 1. ����ȣ");
		System.out.println("## 2. ���̸�");
		System.out.println("## 3. �ֹι�ȣ");
		System.out.println("## 4. ���ϸ���");
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > 4);

		switch (choice) {
		case 1:
			System.out.print("�ٲ� �� ��ȣ : ");
			change_gno=sc.nextInt();
			System.out.println(update_Logic_ChangeGno(stmt, sql,gno,change_gno) + "���� ���� �����Ǿ����ϴ�.");
			break;
		case 2:
			System.out.print("�ٲ� �� �̸� : ");
			change_gname=sc.next();
			System.out.println(update_Logic_ChangeGname(stmt, sql,gno,change_gname) + "���� ���� �����Ǿ����ϴ�.");
			break;
		case 3:
			System.out.print("�ٲ� �ֹ� ��ȣ : ");
			change_jumin=sc.next();
			System.out.println(update_Logic_ChangeJumin(stmt, sql,gno,change_jumin) + "���� ���� �����Ǿ����ϴ�.");
			break;
		case 4:
			System.out.print("�ٲ� ���ϸ��� : ");
			change_mileage=sc.nextInt();
			System.out.println(	update_Logic_ChangeMileage(stmt, sql,gno,change_mileage) + "���� ���� �����Ǿ����ϴ�.");
			break;
		default:
			break;
		}
	}
	/* ���� UI */

	/* ���� LOGIC */
	
	/* ����ȣ���� */
	public int update_Logic_ChangeGno(Statement stmt, String sql,int gno,int change_gno) {
		boolean gno_Exist=false;
		/*  gno �ߺ�üũ */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getInt(1)){
					gno_Exist=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*  gno �ߺ�üũ */
		
		/* gno �ߺ� �߻��� GnoAlreadyExistException �߻� */
		if(gno_Exist){
			throw new GnoAlreadyExistException();
		}
		
		
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + " gno = '" + change_gno + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* �̸����� */
	public int update_Logic_ChangeGname(Statement stmt, String sql,int gno,String change_gname) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "gname = '" + change_gname + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* �ֹκ��� */
	public int update_Logic_ChangeJumin( Statement stmt, String sql,int gno,String change_jumin) {
		boolean isNot13=false;
		
		if(change_jumin.length() != 13){
			isNot13=true;
		}
		if(isNot13){
			throw new isNotJuminException();
		}

		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "jumin = '" + change_jumin + "' WHERE gno = " +gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* ���ϸ��� ���� */
	public int update_Logic_ChangeMileage(Statement stmt, String sql,int gno,int change_mileage) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "MILEAGE = '" + change_mileage + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* ���� LOGIC */

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/* SET & GET */
}