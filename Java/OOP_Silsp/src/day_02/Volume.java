package day_02;

import java.util.Scanner;

public class Volume {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double pie=3.14;
		
		System.out.print("������ : ");
		int r = sc.nextInt();
		System.out.print("���� : ");
		int h = sc.nextInt();
		
		double volume=(r*r*pie)*h;
		
		System.out.println("Volume : " + volume);
	}
}
