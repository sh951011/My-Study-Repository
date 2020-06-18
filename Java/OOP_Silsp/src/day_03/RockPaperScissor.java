package day_03;

import java.util.Scanner;

// 1. �� ����� ������ ���鼭 , s,r,p�� �Է��Ѵ�
// 2. ���������� ����

public class RockPaperScissor {
	public static void main(String[] args) {
		String p1, p2;
		boolean again=false;

		do {
			if(again) {
				System.out.println("�����ϴ�! �ٽ� ���ּ���!");
			}
			do {
				p1=input(1);
			} while (againInput(p1));
			do {
				p2=input(2);
			} while (againInput(p2));
			again=true;
		} while (cont(p1, p2));

		System.out.println(winner(p1, p2) + "�� �̰���ϴ�!!");
		return;
	}
	public static boolean againInput(String str) {
		if(!(str.equals("r") || str.equals("p") || str.equals("s")))	return true;
		else return false;
	}
	
	public static String input(int num) {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.print(">>> People" + num +" : ");
		str = sc.next();
		return str;
	}

	public static boolean cont(String p1, String p2) {
		if (p1.equals(p2))
			return true;
		else
			return false;
	}

	public static String winner(String p1, String p2) {
		if (p1.equals("r")) {
			if (p2.equals("p"))
				return "People2";
			else if (p2.equals("s"))
				return "People1";
		}
		if (p1.equals("p")) {
			if (p2.equals("s"))
				return "People2";
			else if (p2.equals("r"))
				return "People1";
		}
		if (p1.equals("s")) {
			if (p2.equals("p"))
				return "People1";
			else if (p2.equals("r"))
				return "People2";
		}
		return "����";
	}
}