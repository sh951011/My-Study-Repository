package ex01.DatabaseSkill;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		DatabaseEx de = new DatabaseEx();
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (true) {
			System.out.println("## 1. �μ����");
			System.out.println("## 2. �μ�����");
			System.out.println("## 3. �μ�����");
			System.out.println("## 4. �μ������ȸ");
			System.out.println("## 5. ����");
			do {
				choice = sc.nextInt();
			} while (choice < 1 || choice > 5);

			switch (choice) {
			case 1:
				de.insert();
				break;
			case 2:
				de.update();
				break;
			case 3:
				de.delete();
				break;
			case 4:
				de.display();
				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
