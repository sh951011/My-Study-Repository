package day_07;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class TestDemo {
	public static void main(String[] args) {
		Car myCar = new Car("�׷���");
		Car yourCar = new Car("�׷���");

		Date d = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		String s = MessageFormat.format("{2}, {1}, ��¥ : {0} ", sdf1.format(d), myCar, "���ȯ");
		System.out.println(s);

		StringTokenizer st = new StringTokenizer(s, " ,[]:");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}