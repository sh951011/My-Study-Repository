package day_02;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		double width,h,area;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է��ϼ��� : ");
		width=sc.nextDouble();
		System.out.print("���� ���� �Է��ϼ��� : ");
		h=sc.nextDouble();
		area=(width*h)/2;
		
		System.out.println("���̴� " + area +"�Դϴ�.");
	}
}
