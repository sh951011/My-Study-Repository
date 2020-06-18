package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* ������ �Լ� */
public class DeptInsert {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	public DeptInsert() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		username = "scott";
		password = "tifer";

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

	/* ���� LOGIC */
	public int insert_Logic(String gno,String gname,String jumin,String mileage) {
		String sql = "SELECT * FROM gogaeck";
		boolean gno_Exist=false;
		boolean isNot13=false;
		Statement stmt = null;
		/*  gno �ߺ�üũ */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getString(1)){
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
}