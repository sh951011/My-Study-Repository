package ex04.print;

public class PrintTest {
	public static void main(String[] args) {
		double num=123.4567;
		
		System.out.println(num);
		System.out.printf("%f\n",num);
		System.out.printf("%f\n",35.6);
		System.out.printf("%f \t %d \t %c\n",77.77,100,'F');
		System.out.printf("%f\n",12.345678953); // �Ҽ��� 6�ڸ� �̻��̸� 7�ڸ����� �ݿø��ȴ�
		System.out.printf("%10.2f\n",12.3456
				
				78453); // %��ü�ڸ���.�Ҽ����ڸ��� (�ݿø�)
		System.out.printf("%1.4f\n",12.3456789); // 1�� �����߾ 2�ڸ� �̹Ƿ� ���õȴ� 
	}
}
