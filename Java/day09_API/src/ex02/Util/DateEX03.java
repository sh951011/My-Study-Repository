package ex02.Util;
import java.util.*;

public class DateEX03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();	// Calendar�� ��ü ������ �Ұ��ϱ� ������ �̷� ������
																				// system�� ���� �ִ� ��¥ ����
		System.out.println(c.get(Calendar.YEAR) + "��");
		System.out.println((c.get(Calendar.MONTH)+1) + "��");	// MONTH�� 0���� �����ϱ⶧���� +1�� ���־�� �Ѵ�
		System.out.println(c.get(Calendar.DATE) + "��");
		System.out.println("===================");
		
		Date date = new Date();
		int h = date.getHours();
		int m = date.getMinutes();
		int s = date.getSeconds();
		System.out.println("����ð��� " + h  +" �� " + m + "��" + s +  "�� �Դϴ�." );
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c2.set(2017, 12,20,0,0);
		
		if(c1.after(c2)){
			System.out.println("���� �ð��� 2017�� 1�� 1�� �����Դϴ�.");
		}
		else if(c1.before(c2)){
			System.out.println("���� �ð��� 2017�� 1�� 1�� �����Դϴ�.");
		}
		else if(c1.equals(c2)){
			System.out.println("���� �ð��� 2017�� 1�� 1�� �Դϴ�.");
		}
	}
}
