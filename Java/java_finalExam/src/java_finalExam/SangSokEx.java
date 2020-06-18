package java_finalExam;

public class SangSokEx {
	public static void main(String[] args) {
		Shape s1 = new Shape(); // 1��
		Shape s2 = new Circle(); // 2��
		Shape s3 = new Rect(); // 3��
	}
}

class Shape{
	public Shape(){
		System.out.println("Shape");
		draw();
	}
	
	public void draw(){
		System.out.println("Shape draw");
	}
}

class Circle extends Shape{
	public void draw(){
		System.out.println("Circle draw");
	}
}

class Rect extends Shape{
	public void draw(){
		System.out.println("Rect draw");
	}
}

/*
 �̷� ������ �ְ� 1�� ���� ��� 2�� ���� ��� 3�� ������ �϶�� �߰���� ����
 ������ 54�� ������ 18�� �������� �׷��� 
 */
