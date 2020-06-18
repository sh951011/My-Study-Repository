package ex01.DatabaseSkill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseEx {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	String dept_name;
	String dept_location;
	String dept_num;
	Scanner sc = new Scanner(System.in);

	/* ������ �Լ� */
	public DatabaseEx() {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "scott";
		password = "tiger";
		dept_name=null;
		dept_location=null;
		dept_num=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("������ ���� �ʾҽ��ϴ�");
		} else {
			System.out.println("����Ǿ����ϴ�!!");
		}
	}
	/* ������ �Լ� */

	/* ���� */
	public void insert() {
		System.out.print("�μ���ȣ : ");
		this.dept_num = sc.next();
		System.out.print("�μ���ġ : ");
		this.dept_location = sc.next();
		System.out.print("�μ� �̸� : ");
		this.dept_name = sc.next();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO DeptTest VALUES('" + dept_num + "','"+ dept_location + "','"  + dept_name +"')";

			int result = stmt.executeUpdate(sql);

			System.out.println(result +"���� ���� ���ԵǾ����ϴ�."); 

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* ���� */
	
	/* ���� */
	public void delete(){
		String deptno=null;
		
		System.out.print("�����Ͻ� �μ���ȣ�� �Է����ּ��� : ");
		deptno=sc.next();
		
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE DeptTest WHERE deptno=" + deptno ;
			int result = stmt.executeUpdate(sql);
			
			System.out.println(result +"���� �μ��� �����Ǿ����ϴ�."); // executeQuery : DQL
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
	public void update(){
		String sql = null;
		Statement stmt;
		int choice=0;
		
		System.out.print("##�μ���ȣ : ");
		String dept_num=sc.next();
		
		System.out.println("## �ٲ� ������ �������ּ���");
		System.out.println("## 1. �μ���ȣ");
		System.out.println("## 2. �μ���ġ");
		System.out.println("## 3. �μ��̸�");
		do{
			choice = sc.nextInt();
		}while(choice<1 || choice>3);
		
		switch(choice){
		case 1:
			System.out.print("�ٲ� �μ� ��ȣ : ");
			String change_num=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET " +" deptno = '" + change_num +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"���� ���� �����Ǿ����ϴ�."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.print("�ٲ� �μ� ��ġ : ");
			String change_location=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET " + "dept_location = '" + change_location +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"���� ���� �����Ǿ����ϴ�."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.print("�ٲ� �μ� �̸� : ");
			String change_name=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET "+ "dept_name = '" + change_name +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"���� ���� �����Ǿ����ϴ�."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			default : 
			
				break;
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