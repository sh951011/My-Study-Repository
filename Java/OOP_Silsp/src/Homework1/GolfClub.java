package Homework1;

public class GolfClub{
	String name;			//	�����ڿ� ���� �ٸ��� �����Ǵ� �ʵ�
	public GolfClub() {		//	���ڰ� ���� ������
		this.name="7�� ���̾�";	// default ������ "7�� ���̾�"�� �ش�
	}
	
	public GolfClub(int num) {	// int�� ���� �ϳ��� �޴� ������
		this.name=num+"�� ���̾�"; // ���� int�� ���ڿ� string ���ļ� �����Ѵ�
	}
	
	public GolfClub(String name) { // string�� ���� �ϳ��� �޴� ������
		this.name=name;	//	�״�� name�� �����Ѵ�
	}
	
	public void print() {
		System.out.println(name+"�Դϴ�.");
	}
}
