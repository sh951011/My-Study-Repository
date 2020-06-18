package ArrayList;
import java.util.*;

public class MainEntry extends Parking {
	public static void main(String[] args) {
		Parking pk = new Parking();
		LinkedList INLIST = new LinkedList();
		LinkedList OUTLIST = new LinkedList();
		LinkedList CALCULATELIST = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int mode = 0;
		boolean FAIL = false;
		/*
					index										    0+2*i						1+2*i						
					-------------------------------------------------------------------
					INLIST										����ȣ				�����ð�
					OUTLIST									����ȣ				�����ð�
					CALCULATELIST					����ȣ				�ΰ��ȿ��
					
					-> 0 �� ¦���� index���� 3������ LIST�� ��� ����ȣ�� �� �����Ƿ�,�� ����ȣ�� �������� ���õ� ������ ã�´�
					-> Ȧ���� index���� ���� �����ϰ� �;��� ������ ��������Ƿ�, 0 �� ¦���� index�� ��ġ�Ǵ� �������� ã�� ��ġ�Ǵ� index+1�� �ش��ϴ� ������ ������Ų��.
					-> ����ȣ�� �߰��� ������ �ϳ��� �þ��. 1,2,3 ���� �Է��ϰ� 2�� �����ϴ��� ���� ���� 4���� �ο��޴´�.
		 
		 */

		System.out.println("====================================");
		System.out.println("Welcome to Soo-Hwan`s Parking Management Program");
		System.out.println("====================================");

		while (true) {
			System.out.println("\n");
			System.out.println("## 1. �� �߰�");
			System.out.println("## 2. ���� �ð� �Է� �� ��� ���");
			System.out.println("## 3. �� ���� ����");
			System.out.println("## 4. �� ��� ����");
			System.out.println("## 5. ���α׷� ����");
			System.out.println("\n");
			do {
				if (FAIL) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					FAIL = false;
				}
				System.out.print("SELECT MODE : ");
				mode = sc.nextInt();
				FAIL = true;
			} while (mode < 1 || mode > 5);
			FAIL=false;
			
			switch (mode) {
			case 1:
				pk.IN(INLIST);
				break;
			case 2:
				pk.calculate_charge(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 3:
				pk.remove_list(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 4:
				pk.display(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 5:
				return;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
}
