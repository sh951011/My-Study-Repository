package fourth;

public class StrategyPattern{
	Calc cal;
	/* Add,Div.. �� ���ϴ� ������ ������ �� cal�� ��ü�� set���ִ� �޼��� */
	public void setCal(Calc cal) {
		this.cal = cal;
	}	
	
	/* cal�� set�� �س��� ��ü�� setValue�� ã�ư��� ������ �޼��� */
	public void doSetValue(int a, int b) {
		// TODO Auto-generated method stub
		cal.setValue(a, b);
	}

	/* cal�� set�� �س��� ��ü�� calculate�� ã�ư��� ������ �޼��� */
	public int doCalculate(int a, int b) {
		// TODO Auto-generated method stub
		int result=0;
		
		result=cal.calculate(a, b);
		
		return result;
	}
}

/*
 StrategyPattern()�� ��ü�� �����ϰ�,
 �̸� ������ Calc Ÿ���� cal ������ ���ϴ� ��ü�� ���� �� �ִ�
 setCal(Calc cal) �޼��带 �����ΰ�, ���ϴ� ���꿡 �ش��ϴ� ��ü�� 
 setCal(Calc cal) �޼���� cal�� �־��ش�. 
 �̷��� ������ �ϸ� ���� new Add() ��ü�� ������ �Ǿ��ٸ�,
 StrategyPattern()�� ��ü�� setValue�� �����ϸ�
 cal.setValue(a,b) �� ������ �� ���̰� �̴� ��ǻ�
 -> Add Ŭ������ setValue�� �����ϴ� �Ͱ� ����.
 �̷� ������� calculate()�� ������ �ȴ�.
 
 ��, �Ȱ��� Ŭ����, �Ȱ��� �޼��带 ����ϸ鼭, �����ϴ� ��ü�� �ٲ��ָ�,
 ���ϴ� �ٸ� ����� ���� �� �ִ�.
 */
