package ex05.API;

class Circle{
	int x,y;
}

public class EqualsMethod {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		
		System.out.println("c1 : " + c1.hashCode());
		System.out.println("c2 : " + c2.hashCode());
		
		if(c1==c2)	System.out.println("����");
		else System.out.println("�ٸ���");
		
		int x=3,y=3;
		System.out.println("�⺻ �ڷ��� ��");
		if(x==y){ System.out.println("����"); }
		else{System.out.println("�ٸ���");}
		
		System.out.println("���� �ڷ��� ��");
		String str1 = new String("korea");
		String str2 = new String("Korea");
		
		if(str1==str2) System.out.println("����");
		else System.out.println("�ٸ���");
		
		
		System.out.println("========equals========");
		System.out.println("���� �ڷ��� ��");
		if(str1.equals(str2)){
			System.out.println("����");
		}
		else{
			System.out.println("�ٸ���");
		}
		
		System.out.println("=========equals(��,�ҹ��� ����x)==========");
		System.out.println("���� �ڷ��� ��");
		if(str1.equalsIgnoreCase(str2)){
			System.out.println("����");
		}
		else{
			System.out.println("�ٸ���");
		}
	}
}
