package first;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Rect rt = new Rect();
		/*
		 Rect��ü�� �����ϰ� �Ǹ� �ڵ����� Rect�� ������ �Լ��� ���� �ǹǷ�
		  main�����µ��� �޼��� ȣ���� �����ְ�
		  �������Լ����� ȣ���� �����ν� ���α׷��� �����ߴ�
		 */
		
		
	}
}

class Rect {
	/* Rect class�� ������ �Լ� (��ü ������ �ڵ� ����) */
	public Rect() {
		int x = 0, y = 0;
		boolean con;
		Scanner sc = new Scanner(System.in); // �Է��� �ޱ� ���� Scanner ��ü ����

		/* booleanŸ���� con�� false�� ���ö����� �ݺ� */
		while (true) {
			System.out.print("INPUT X : ");
			x = sc.nextInt();
			System.out.print("INPUT Y : ");
			y = sc.nextInt();

			inOrNot(x, y);	// (x,y)�� �簢�� �ȿ� ����ִ��� �ƴ����� �Ǻ����ִ� �޼���
			con = cont();       // ��� ������ ������ �ƴ����� �Ǻ����ִ� �޼���

			/* ����ڰ� �����⸦ ���Ѵٸ� �����ֱ� ���� if�� */
			if (con == false) {
				return;
			}
		}

	}

	/* (x,y)�� �簢�� �ȿ� ����ִ��� �ƴ����� �Ǻ����ִ� �޼��� */
	public void inOrNot(int x, int y) {
		if (x > 100 && x < 200 && y > 100 && y < 200) {
			System.out.println("(" + x + "," + y + ")�� �簢�� �ȿ� �ֽ��ϴ�.");
		} else {
			System.out.println("(" + x + "," + y + ")�� �簢�� �ȿ� ���� �ʽ��ϴ�.");
		}

		return;
	}

	/* ��� ������ ������ �ƴ����� �Ǻ����ִ� �޼��� */
	public boolean cont() {
		Scanner sc = new Scanner(System.in);
		String yesno = "";
		boolean con = true;

		do {
			System.out.print("����Ͻðڽ��ϱ�? (Y/N)");
			yesno = sc.next();
		} while (yesno.charAt(0) != 'y' && yesno.charAt(0) != 'Y' && yesno.charAt(0) != 'n' && yesno.charAt(0) != 'N');
/*
  ����ڰ� y,Y,n,N�̿ܿ� �ٸ� ���� �Է����� �� �ٽ� �Է��� �ޱ� ���� do~while�� ó��	
  ���� 4������ ���ĺ��� �ƴ� �ٸ� ���� �Էµȴٸ� while�� ���� ������ true�� �Ǿ� �ٽ� �ݺ��� �ϰ� �ǰ�,
  ���� 4���� ���ĺ� �� �ϳ��� ���� �Է��� �ȴٸ� while�� ���� ������ false�� �Ǿ� do~while���� ���������� �ȴ�.
 */
		
		
		switch (yesno) {
		case "y":
		case "Y":
			System.out.println("��� �����մϴ�");
			con = true;
			break;
		case "n":
		case "N":
			System.out.println("���α׷��� �����ϴ�.");
			con = false;
		default:
			break;
		}
		return con;
	}
}
