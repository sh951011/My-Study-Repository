package exception;

public class Exception1 {
	public static void main(String[] args) {
		try{
			int x=5,y=0;
			int result=x/y; // ����ó�� (������ �߻��� �� �ִ� �ڵ�)
			
			System.out.println("result = " + result);
		}catch(ArithmeticException e){
			System.out.println("0���� ���� �� �����ϴ�. ArithmeticException");
		}catch(Exception e){
			e.printStackTrace(); // �ܰ������� ���ܸ� ã�Ƽ� �����
			System.out.println("0���� ���� �� �����ϴ�. Exception");
		}
	}
}
/*
c���� if������ ���� ��~~�� ��Ȳ�� ���ԵǸ� ��~~�ϰ� ó���ض��̴�.
�Ͱ� try�� ���� �Ͼ �� �ִ� ��Ȳ�� ��� �ڵ��̰�, �ΰ� catch�κ��̴�.
Exception�� �߿��� ���� �Ʒ��� ���������� Exception�� �־�� �Ѵٴ� ���̴�.

���� ��� Exception��
A{
	B{
		C
	}
}

��� ��ġ��

catch(C)
catch(B)
catch(A)
�� �ξ�� �Ѵ�
*/