package ex09.problem3;
import java.util.*;

public class Bus implements Tran {
	double distance=0;
	double last_speed,first_speed;
	final double limit=100;
	int t = 0;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void move() {
		System.out.print("ó�� �ӵ��� �����ּ��� >.< (m/s) : ");
		first_speed=sc.nextDouble();
		
		last_speed=first_speed;
		
		while(last_speed<limit){
			last_speed += accelerater;
			t++;
		}
		distance = ((first_speed+limit)/2) * t;
		stop();
	}

	@Override
	public void stop() {
		System.out.println("������ ������ϴ� >.<");
		System.out.printf("�̵��� �Ÿ��� %.2fm�Դϴ�",distance);
	}

}
