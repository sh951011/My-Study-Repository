package day_02;

import java.util.Scanner;

/*
 * Ű����� �Էµ� ���� ���� �߿��� ¦���� �����Ͽ� ����ϴ� ���α׷�
 * do~while�� ���
 */

public class P121problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0, result = 0;
		do {
			System.out.print("���� �Է� : ");
			num=sc.nextInt();
			if(num%2==0 && num>0)	result+=num;
		} while (num > -1);
		System.out.println("\nOUTPUT : " + result);
	}
}
