/* default constructor & API */

package ex02.dEfault;

public class MainEntry {
	/**
	 * 
	 * @param args ������ �ƹ����� �Ѱ� ���� �ʽ��ϴ�
	 * @param x ���� ���ϴ� ���� ù ��° ������ ����
	 * @param y ���� ���ϴ� ���� �� ��° ������ ����
	 * @param multiply ������ x�� y�� �� ������ ���� �����ϴ� ����
	 */
	public static void main(String[] args) {
		int x,y,multiply=1;
		char ch='A';
		String msg;
		
		x=5; y=10;
		msg="Hello Java";
		multiply=multiply(x,y);
		System.out.println("x = " + x + ", y = " + y + ", mul = " + multiply);
	}

	public static int multiply(int x, int y) {
		return x*y;
	}
}
