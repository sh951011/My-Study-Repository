package Homework1;

public class HW1Demo {	
	public static void main(String[] args) {
		
		System.out.println("## 164p (6)");
		
		Complex c1 = new Complex(2.0);	//	�Ǽ��� ���ڷ� �ִ� ��ü
		c1.print();
		Complex c2 = new Complex(1.5,2.5);	//	�Ǽ�, ��� �� �� �ִ� ��ü
		c2.print();
		
		System.out.println("\n## 164p (7)");
		
		GolfClub g1 = new GolfClub();	//	���ڰ� ���� ��ü
		g1.print();
		
		GolfClub g2 = new GolfClub(8);	//	int�� ���� ��ü
		g2.print();
		
		GolfClub g3 = new GolfClub("����");	//	String�� ���� ��ü
		g3.print();
	}
}
