package ex05.problem;

abstract public class Vehicle {
	String str = null;
	public abstract void start();
	public abstract void process();
	public abstract void end();
}


////////////////////
class Bus extends Vehicle{
	public Bus(){
		str = "BUS";
	}
	
	public void start(){
		System.out.println(str);
		System.out.println("�����忡�� ����մϴ�");
	}
	public void process(){
		System.out.println("�����Ƥ��Ƥ������Ƥ���");
	}
	
	public void end(){
		System.out.println("�����忡 �����Ͽ����ϴ�");
	}
}

////////////////////////
class Subway extends Vehicle{
	public Subway(){
		str="Subway";
	}
	
	public void start(){
		System.out.println(str);
		System.out.println("������ ����մϴ�");
	}
	public void process(){
		System.out.println("ĢĢ���� ĢĢ����");
	}
	
	public void end(){
		System.out.println("���� �����Ͽ����ϴ�.");
	}
}

///////////////////
class Bicycle extends Vehicle{
	public Bicycle(){
		str="Bicycle";
	}
	public void start(){
		System.out.println(str);
		System.out.println("�����ŷ� ����մϴ�");
	}
	public void process(){
		System.out.println("������ ������ ���ѳ�����");
	}
	
	public void end(){
		System.out.println("�������� �����Ͽ����ϴ�.");
	}
}


//////////////////////
class Plain extends Vehicle{
	public Plain(){
		str="Plain";
	}
	public void start(){
		System.out.println(str);
		System.out.println("���׿��� ����մϴ�");
	}
	
	public void process(){
		System.out.println("���֤������㹫���t����Ӥ��y��");
	}
	
	public void end(){
		System.out.println("���׿� �����Ͽ����ϴ�.");
	}
}