package ex07.Interface;

interface A{
	int x = 90;	// int x == final int x (interface����)�⺻������ �����ִ´� ������..
	final int y = 7777;
	
	public void show();	// public abstract void show(); abstract ���� ������ - ������ �߻�method
	public abstract void disp();
}	// A END

interface B{
	void view();
}	// B END

interface C{
	String name = "happy";
	public void draw();
}

class Rect implements C{
	public void draw(){
		System.out.println(name + "�� �ݰ�����");
	}
}

interface D extends B{
	
}

public class MainEntry {
	public MainEntry() {
	
	}
}