package third;

import java.util.Scanner;

public class Div {
	int a, b;

	/* �Է¹��� a,b�� �ش� ��ü a,b�� �־��ش�. */
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/* ������ ���� */
	public int calculate(int a, int b) {
		/* 0���� ���� �� ����ó���� ���� */
		if (!(b == 0)) {
			return (a/b);
		} else {
			return -1;
		}
	}
}
