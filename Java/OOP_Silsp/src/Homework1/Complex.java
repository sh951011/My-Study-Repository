package Homework1;

public class Complex{
	double silsu,heosu; // �Ǽ��� ��� field
	


	public void setHeosu(double heosu) {
		this.heosu = heosu;
	}






	public Complex(double silsu,double heosu) { // �Ǽ�, ��� �� �� �ִ� ������
		this.silsu=silsu;
		this.heosu=heosu;
	}
	
	public void print() {
		System.out.println(silsu+" + "+heosu+"i");
	}
}