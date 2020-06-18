package ex06.wrapper;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		Integer la = new Integer(10);
		Integer lb = new Integer("10");
		String strNum="30";
		int x = 10;
		
		Point pt = new Point();
		
		System.out.println("pt = " +pt);
		System.out.println("pt.toString() = " + pt.toString());
		System.out.println("la = " + la);
		System.out.println("la.hashCode() = " + la.hashCode());
		System.out.println("la.getClass().getName@Integer,toHexString(la.hashCode()) : " + la.getClass().getName() + '@' + Integer.toHexString(la.hashCode()));
		System.out.println("pt.hashCode() = " + pt.hashCode());
		
		/* Boxing vs UnBoxing */
		int y=5;
		double d = 3.3;
		y = (int)d;
			
		int c = la.intValue(); // jdk 4.0 ������ ����ϴ� method
		int e = lb;		// jdk 5.0 ���ĺ��� heap������ �ִ� ��ü�� stack memory�������� ������ �� �ְԉ��
		int num = Integer.parseInt(strNum);
		
		System.out.println(c+strNum);
		System.out.println(c+e);
		System.out.println(la.MAX_VALUE);
		System.out.println(la.MIN_VALUE);
		
		System.out.println(Float.MIN_VALUE);
		System.out.println("================");
		Double dd = new Double(12.34);
		System.out.println(dd.MAX_VALUE);
		System.out.println(dd.MIN_VALUE);
		
		System.out.println("++++++++++++++++");
		c=(int)dd.doubleValue();
		System.out.println("����ȯ�� c�� ���� ? " + c);
		System.out.println("************************");
	}
}