package day_02;

import java.util.Scanner;

public class OddOrEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("num : ");
		int num=sc.nextInt();
		
		str = (num%2==0) ?"¦��"  : "Ȧ��";
		
		System.out.println(str+"�Դϴ�.");
		
	}
}
