package method;
import java.util.*;

class A{
	int x,y;
	public void setData(int x,int y){
		System.out.println(x + ", " + y);
	}
}

public class InstanceMethod {
	public void disp(){
		System.out.println("name = SooHwan");
	}
	
	public static void main(String[] args) {
		InstanceMethod im = new InstanceMethod(); // �̰� �ٷ� Instance Method!!
												  // ��ü�� ���� ����ϴ� Method!!
		A obj = new A();
		obj.setData(4,5);
		im.disp();		// Scanner�� ����ó�� ���� �ȴٰ� ����!!
	}
}

/*
 ���� �߿��� �κ�!!!!! InstanceMethod�� ���� ���� ö���ϰ� ������ ��!!
 */
