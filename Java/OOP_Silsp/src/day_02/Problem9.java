package day_02;

import java.util.Scanner;

/*
 * ���� ���� ���
 * - �ּ� 140
 * - ���� 70�̻�
 * - ���� / �Ϲ� ���� 30 �̻��̰ų� (���� + �Ϲ�)�� 80�̻��̰ų�
 */

public class Problem9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean limit=false, major=false, etc=false;
		
		System.out.print("���� �̼� ���� �Է� : ");
		int majorInt=sc.nextInt();
		System.out.print("���� �̼� ���� �Է� : ");
		int cocInt=sc.nextInt();
		System.out.print("�Ϲ� �̼� ���� �Է� : ");
		int etcInt=sc.nextInt();
		
		major=(majorInt>69) ? true : false;
		etc=((cocInt>29 && etcInt>29) || (cocInt+etcInt>79)) ? true : false;
		limit=((majorInt+cocInt+etcInt)>139) ? true:false;

		
		String str=(limit && major && etc) ? "����" : "�Ұ���"; 

		System.out.println("\n���� " + str + "�մϴ�.");
	}
}
