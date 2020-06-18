package third;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		int a=0,b=0;
		char mode='0';
		Scanner sc = new Scanner(System.in);
		
		/* a,b ���ڰ� �Է¹ޱ� */
		System.out.print("## ù��° ���ڸ� �Է����ּ��� : ");
		a=sc.nextInt();
		System.out.print("## �ι�° ���ڸ� �Է����ּ��� : ");
		b=sc.nextInt();
		/* + - * / �Է¹ޱ� �� �� 4���� �ƴ� �� ����ó��  */
		do{
			System.out.print("## (+) : ���ϱ� (-) : ���� (*) : ���ϱ� (/) : ������ ");
			mode=sc.next().charAt(0);
		}while(mode != '+' && mode != '-' && mode != '*' && mode != '/');
		
		/* operate ������� */
		operate(a,b,mode);
	}

	/* �Է¹��� ���꿡 ���� �ش� ��ü ���� �� �������ְ� ����� ��� �޼��� ȣ�� */
	public static void operate(int a, int b, char mode) {
		int result = 0;

		/* + �Է½� Add() ��ü ���� �� ���ϱ� ���� */
		if (mode == '+') {
			Add add = new Add();
			result = add.calculate(a, b);
			display(result);
		}
		/* - �Է½� Sub() ��ü ���� �� ���� ���� */
		else if (mode == '-') {
			Sub sub = new Sub();
			result = sub.calculate(a, b);
			display(result);
		}
		/* * �Է½� Mul() ��ü ���� �� ���ϱ� ���� */
		else if (mode == '*') {
			Mul mul = new Mul();
			result = mul.calculate(a, b);
			display(result);
		}
		/*/ �Է½� Div() ��ü ���� �� ������ ���� */
		else if (mode == '/') {
			Div div = new Div();
			result = div.calculate(a, b);
			
			if (!(result == -1)) {
				display(result);
			}
			/* 0���� ���� �� return�� -1 �ϵ��� �����س����Ƿ� */
			/* 0���� ���� �ÿ� ���� */
			else{
				System.out.println("## 0���δ� ���� �� �����ϴ�.");
			}
		}

		return;
	}

	/* �������� ��� �޼��� */
	public static void display(int result) {
		System.out.println("## ���� ����� " + result + "�Դϴ�.");
	}
}