package ex02.Interface2;

public class MainEntry {
	public static void main(String[] args) {
		// 1. �ڱ� �ڽ����� ��ü ����
		MultiClass mc = new MultiClass();
		mc.testView();
		mc.draw();
		System.out.println("=================");
		// 2. �θ�� ��ü ���� - Shape, IDraw, Test
		Test t = new MultiClass();	// Test�� interface�̱⶧����
		t.testView();
		System.out.println(t.str);
		System.out.println("=================");
		
		Shape s = new MultiClass();
		s.show();
		System.out.println(s.result);
		System.out.println("=================");
	}
}
