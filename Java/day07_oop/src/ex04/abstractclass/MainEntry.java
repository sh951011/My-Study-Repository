package ex04.abstractclass;

abstract class Shape{
	double result = 0;
	public abstract double calc();
	public abstract void draw();
	
	public void show(){
		System.out.println("Super class Shape");
	}
	
	/* SET GET */
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	/* SET GET */
}	// shape end

class Circle extends Shape{
	double r=5.0;
	
	public double calc(){
		result=r*r*Math.PI;
		
		return result;
	}
	public void draw(){
		System.out.println("���� ���� : " + result + "�� ���� �׷Ƚ��ϴ�.");
	}
	
	public void draw(String[] name){
		System.out.println(name);
	}
}

class Rect extends Shape{
	int a=4;
	
	public double calc(){
		result= a * a;
		return result;
	}
	
	public void draw(){
		System.out.println("�簢���� ���� : " + result + "�� �簢���� �׷Ƚ��ϴ�.");
	}
	
	public void draw(String[] name){
		System.out.println(name);
	}
}

class Triangle extends Shape{
	int b=4;
	int a=3;
	public double calc(){
		result=a*b/2.0; 
		return result;
	}
	
	public void draw(){
		System.out.println("�ﰢ���� ���� : " + result + "�� �ﰢ���� �׷Ƚ��ϴ�.");
	}
	
	public void draw(String[] name){
		System.out.println(name);
	}
}

public class MainEntry {
	public static void main(String[] args) {
		Circle c = new Circle();
		Shape s = new Circle();
		Shape s2 = new Triangle();
		Shape s3 = new Rect();
		
		// �迭�� �̿��� ����
		Shape[] ss = new Shape[3];
		// Shape ss2 = new Shape(); // ��ü������ ��ü ������ �� ����
		ss[0] = new Circle();
		ss[1] = new Rect();
		ss[2] = new Triangle();
		String[] name = new String[3];
		name = ("Circle", "Rectangle", "Triangle");
		
		for(int i=0;i<ss.length;i++){
			ss[i].draw(name[i]);
		}
		
		s.calc();
		s.draw();
		s2.calc();
		s2.draw();
		s3.calc();
		s3.draw();
	}
}
