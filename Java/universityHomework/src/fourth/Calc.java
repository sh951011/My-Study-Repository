package fourth;

public abstract class Calc {	
	int a,b;	// �������� �� �ʵ�
	
	/* 4���� Ŭ���� ��� ���� �����̹Ƿ� �������� �������ش� */
	public  void setValue(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	/* ���� �ٸ� ���Ǹ� ���� ���̹Ƿ� �߻�޼���� ���ܵд� */
	public abstract  int calculate(int a,int b);
}
