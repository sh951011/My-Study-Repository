package ex08.Interface;

public class MainEntry {
	public static void main(String[] args) {
		// 1. �ڱ� �ڽ����� ��ü ����
		BB bb = new BB();
		bb.draw();
		System.out.println(bb.num);
		
		// 2. �θ� �������̽��� ��ü ����
		IDraw bb2 = new BB();
		System.out.println(bb2.num);
		bb2.draw();
	}
	
}
