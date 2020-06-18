package fourth;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		int a = 0, b = 0;
		char mode = '0';
		Scanner sc = new Scanner(System.in);

		System.out.print("## ù��° ���ڸ� �Է����ּ��� : ");
		a = sc.nextInt();
		System.out.print("## �ι�° ���ڸ� �Է����ּ��� : ");
		b = sc.nextInt();

		/* ������ ��� �̿ܿ� �Է¹޾��� �� ����ó�� */
		do {
			System.out.print("## (+) : ���ϱ� (-) : ���� (*) : ���ϱ� (/) : ������ ");
			mode = sc.next().charAt(0);
		} while (mode != '+' && mode != '-' && mode != '*' && mode != '/');

		operate(a, b, mode);
	}

	/* �������� ������ �̷������ �޼��� */
	public static void operate(int a, int b, char mode) {
		int result = 0;
		StrategyPattern strategy = new StrategyPattern();		//	���������� �߽��� �Ǵ� sp ��ü����

		/*
		 * # �������� ��� ���� interface�� �̿��Ͽ� ����ϴ� ������ �˰��ִµ�, ������ �־��� ������ abstract
		 * class ��������� �־ abstract class�� �̿��� �������� ��� ���ϴ� ������ ������ ��ü�� ��Ȳ�� �°�
		 * �����Ͽ� ����Ѵ�.
		 */

		/* +�϶��� Add() ��ü ���� */
		if (mode == '+') {
			strategy.setCal(new Add());
		}
		/* -�϶��� Sub() ��ü ���� */
		else if (mode == '-') {
			strategy.setCal(new Sub());
		}
		/* *�϶��� Mul() ��ü ���� */
		else if (mode == '*') {
			strategy.setCal(new Mul());
		}
		/*/�϶��� Div() ��ü ���� */
		else if (mode == '/') {
			strategy.setCal(new Div());
		}
		
		/*
		 �տ��� ���ϴ� ��ü�� ���������Ƿ�, 
		 ������ �ش� ��ü�� �ش��ϴ� 
		 setValue()�� calculate()�� �����Ѵ� 
		  */
		
		strategy.doSetValue(a, b);
		result = strategy.doCalculate(a, b);

		
		/* 0���� ���� ��� �Ұ��� �ϹǷ�, ����ó�� */
		if (result == -1) {
			System.out.println("## 0���δ� ���� �� �����ϴ�.");
		} else {
			display(result);
		}

		return;
	}

	/* �������� display���ִ� �޼��� */
	public static void display(int result) {
		System.out.println("## ���� ����� " + result + "�Դϴ�.");
	}
}