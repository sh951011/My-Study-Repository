package ex01.Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// DBMS�� �����ϱ� ���ؼ��� � ������ �ʿ��մϱ�????
// DBMS�� IP�ּҿ� ��Ʈ
// â������ο��� �����ϱ� ���� ���̵� ��� scott / tifer

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "scott";
		String password = "tifer";
		Connection conn = null; 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT NUMBER : ");
		int num=sc.nextInt();
		System.out.print("INPUT "	+ "NAME : ");
		String name =sc.next();
		System.out.print("INPUT PRICE : ");
		int price=sc.nextInt();
		System.out.print("INPUT DESCRIPTION : ");
		String des=sc.next();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO test VALUES("+num+",'"+name+"',"+price+",'"+des+"')";	// �ʹ� �������� �ٸ� ����� ����
		//	String sql = "INSERT INTO test VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);		// ?�� �Ų�� ���� preparedstatement�� �ϴ� �޾Ƶΰ�,
/*			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setString(4, des);  // �䷱ ����� �ִٴ� �͵� ����!! 
*/			
			
			Statement stmt = conn.createStatement();		// stmt�� ������ ���� executeUpdate : DML -> ����� ������ ���� ���ڵ��� ����
			stmt.executeQuery(sql);
			//int result = pstmt.executeUpdate(sql);
			//System.out.println(result + "���� ���� ����޾ҽ��ϴ�.");	// 									  executeQuery : DQL -> 
																															//   									  execute : DDL
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

/*
 �ڹ� Ŭ�������� ��Ƽ� ������� ������ jar
 
������Ʈ���� ~~.jar������ �������� ���

���� ��õ�帮�� ���
-> ������Ʈ ���ο� ������ �־�ΰ� �������� �� ��
 
 
 
 ====================

 1. Connection ��ü ȹ��
 2. ���� SQL������ Statement��ü�� �غ�
 3. ��ô
 
 */



























