package package1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		main_while();
	}
	
	
	/* ���ο��� ���� ���Ϲ� ���� ��ġ */
	public static void main_while(){
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		while (true) {
			System.out.println("## 1. ���������");
			System.out.println("## 2. ����������");
			System.out.println("## 3. ����������");
			System.out.println("## 4. �������ȸ");
			System.out.println("## 5. ����");
			do {
				choice = sc.nextInt();
			} while (choice < 1 || choice > 5);

			switch (choice) {
			case 1:
				new DeptUI();
				try{
					
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 2:
				try{
	
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
