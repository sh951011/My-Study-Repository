package ex05.API;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point();
		System.out.println("Point pt information");
		System.out.println
		("class name : " + pt.getClass());	//	class�� ������ �˰� ���� ��
		System.out.println("hash code : " + pt.hashCode());		// 16�������� 10������ ���� ���� �� (�ּ�)
		System.out.println("Object String : " + pt.toString());
		System.out.println("Object String : " + pt);
		System.out.println("===============================");
		
		Point pt2 = new Point();
		System.out.println("Point pt information");
		System.out.println("class name : " + pt2.getClass());	//	class�� ������ �˰� ���� ��
		System.out.println("hash code : " + pt2.hashCode());		// 16�������� 10������ ���� ���� �� (�ּ�)
		System.out.println("Object String : " + pt2.toString());
		System.out.println("Object String : " + pt2);
		System.out.println("===============================");
		
		System.out.println("pt2.toString() : toString�� �ǹ� " );
		System.out.println(pt2.getClass().getName() + '@' + Integer.toHexString(pt2.hashCode()));
		/* getClass.getName : Ŭ������ ������ Ŭ������ �̸� */
		
		Point pt3 = new Point();	// ��ü ����, �޸𸮿� �Ҵ�, �������Լ� �ڵ�ȣ���
		
		if(pt.hashCode() == pt3.hashCode()){
			System.out.println("����");
		}
		else{
			System.out.println("�ٸ���");
		}
		
		Point pt4;	// ��ü ����x, �޸𸮿� �Ҵ��� �ȵ�
		pt4=pt;
		
		if(pt.hashCode() == pt4.hashCode()){
			System.out.println("����");
		}
		else{
			System.out.println("�ٸ���");
		}
	}
}
