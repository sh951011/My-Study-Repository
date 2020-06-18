package ex02_oop;

/* Point Start */
class Point{
	/* ������� */ 	// ���������� �����ϸ� default �ڵ� ����
	private int x,y;	
	
	public Point(){ // ������ �Լ� - default constructor
		x=y=100;
	}
	
	public Point(int... x){	// �Ű����� ���� 
		// x=x; �̷� ������ ���ָ� ��� x�� ���ϴ� �������� ��ǻ�Ͱ� �𸣰� �ȴ�.
		// �׷��� ������ �� ��ɾ� "this"
		this.x=x; // this�� �ϰ� ���� �ߴ� x�߿� ���� 
	}
	
	/* setter,getter method Start */
	public void setX(int xx){
		x=xx;
	}
	
	public int getX(){
		return x;
	}
	
	public void setY(int yy){
		y=yy;
	}
	
	public int getY(){
		return y;
	}
	/* setter,getter method End */
}
/* Point End */

class Circle{
	private int x,y,r;

	public Circle(){	// ������ �Լ� - ������� �ʱ�ȭ ��� return type�� ����!!
		x=10;
		y=20;
		r=3;
	}
	
	// ������ �� ���ڸ� ������ �������Լ�, �Ű����� ��� �� ���� �������Լ�
	public Circle(int r){
		this.r=r;
	}
	public Circle(int x,int y,int r){
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	public void display(){
		System.out.println(x + ", " + y + ", " + r);
	}
	
	/* setter,getter method Start */
	public void setX(int xx){
		x=xx;
	}
	public void setY(int yy){
		y=yy;
	}
	public void setR(int rr){
		r=rr;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	} 
	public int getR(){
		return r;
	}
	/* setter,getter method Start */
}

/* private�� ���� ��� */
public class Oop {
	public static void main(String[] args) {
		Point pt = new Point();
		pt.setX(100);
		pt.setY(20);
		//cc.setX(100);
		//cc.setY(40);
		//cc.setR(5);
		
		Circle c2 = new Circle(5,5,5);
		c2.display();
		Circle c3 = new Circle(5,5,10);
		c3.display();
		
		// System.out.println("pt.x = " + pt.getX() + ", pt.y = " + pt.getY());
	}
}
