package fourth;

public class Div extends Calc{
	/* ������ ���� */
	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		/* 0���δ� ���� �� �����Ƿ� ����ó���� ���� */
		if (!(b == 0)) {
			return (a / b);
		}else{
			/* 0���� �������� -1 ��ȯ */
			return -1;
		}
	}
}
