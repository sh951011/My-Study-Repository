//*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		// �� ������ : &, |, ^
		
		int x=7,y=4;
		
		System.out.println(x&y);
		System.out.println(x|y);
		System.out.println(x^y);
		System.out.println("=====");
		boolean flag;
		x=10;
		y=20;
		int z=30;
		flag=(x>y) && (y>z);
		System.out.println(flag);
	}
}
//*/


/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		// shift ������ : <<. >>, <<<
		int x=8, result;
		
		result=x<<2;
	}
}
//*/

/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		// ���� : 
		int su=12345;
		int hour=0, minute=0;
		
		hour=su/60;
		minute=su%60;
		
		System.out.println("hour = " + hour);
		System.out.println("minute = " + minute);
		
	}
}
//*/

/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		// ���� : 
		int pay = 567890;
		int man=0,cheon=0,back=0,sip=0;
		
		man=pay/10000;
		pay=pay%10000;
		cheon=pay/1000;
		pay=pay%1000;
		back=pay/100;
		pay=pay%100;
		sip=pay/10;
		
		System.out.println("�� = " + man);
		System.out.println("õ = " + cheon);
		System.out.println("�� = " + back);
		System.out.println("�� = " + sip);
	}
}
//*/

/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		int x=10,y=20;
		int gob=x*y;
		// ���� ������ : ���� ==> ++, --, ~, ....

		
		System.out.println("x*y = " + gob);
		System.out.println("==============");
		System.out.println("7 / 3 = " + 7/3);
		System.out.println("7 % 3 = " + 7%3);
	}
}
//*/

/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		System.out.println(3+4*5);
		System.out.println((3+4)*5);
		
		// ���� ������ : ���� ==> ++, --, ~, ....
		int x = -6, y;
		y = ~x; // ��Ʈ���� : ��Ʈ���� 0->1 , 1->0 ==> �ᱹ ��� = -(������ +1)
		
		System.out.println("y=" + y);
		System.out.println("x=" + x);
	}
}
//*/

/*
package ex03.operator;

public class Operator {
	public static void main(String[] args) {
		System.out.println(3+4*5);
		System.out.println((3+4)*5);
		
		// ���� ������ : ���� ==> ++, --, ~, ....
		int x = 10, y;
		y = x++;
		
		System.out.println("x=" + x + "\t y=" + y);
	}
}
*/