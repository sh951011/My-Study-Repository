package Generic;

public class Main {
	public static void main(String[] args) {
		Box box = new Box();
		box.setData("���ڿ��� �ϳ� ���� �� �ִ� ��ü");
		System.out.println(box.getData());
	}
	
	public static <A> void print(A a,A b){
		boolean result = a.equals(b);
		System.out.println(result);
	}
}

class Box{
	// ���1
	Object data;
	public Object getData(){
		return data;
	}
	public void setData(Object data){
		this.data = data;
	}

}

class  Box2<A>{
	// ���2
	A data;
	public A getData(){
		return data;
	}
	public void setData(A data){
		this.data = data;
	}
}

// ȣ���ÿ� Ÿ���� ������ �� �ִ� ���� : Generic