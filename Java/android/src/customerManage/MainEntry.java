package customerManage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int mode = -1;
		String title = "\\t### Customer Management Program ###\\n";
		String[] menu = {"## 0. �� ��� ���",
						 "## 1. �ű� �� ���",
						 "## 2. �� ���� ����",
						 "## 3. �� ����Ʈ ��ȸ",
						 "## 4. �� ���� ����",
						 "## 5. �� ����",
						 "## 6. ���α׷� ����"}; 
		
		/* User Interface */
		System.out.println(title);
		do {
			for(int i = 0;i < 7; i++)
				System.out.println(menu[i]);
		}while(mode<0 || mode>6);
		
		return;
	}
}
