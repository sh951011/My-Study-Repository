package dbEx;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		DbOrcl dbo = new DbOrcl();
		main_while(dbo);
	}
	
	/* ���ο��� ���� ���Ϲ� ���� ��ġ */
	public static void main_while(DbOrcl dbo){
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
				try{
					dbo.insert();
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
					dbo.update();
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 3:
				dbo.delete();
				break;
			case 4:
				dbo.display();
				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
