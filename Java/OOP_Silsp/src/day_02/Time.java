package day_02;

import java.util.Scanner;

public class Time {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num=sc.nextInt();
		
		int hour=num/3600;
		num-=hour*3600;
		int minute=num/60;
		num-=minute*60;
		int sec=num;
		
		System.out.println(hour+"�ð� "+minute+"��" +sec+"��");
	}
}