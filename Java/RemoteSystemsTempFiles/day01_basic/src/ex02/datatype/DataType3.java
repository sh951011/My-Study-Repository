//*
package ex02.datatype;

public class DataType3 {
	public static void main(String[] args) {
		short sh = 32767; // -32768 ~ 32767 
		int num = 32769; // -21�� ~ 21��
		
		num=sh; // int = short ����
		System.out.println("sh="+sh);
		System.out.println("num="+num);
		
		num=32769;
		// ū �ڷ����� ���� �ڷ����� �������� ����� ����ȯ�� �ؾ��Ѵ�.
		// ������ �ս� �߻�
		sh=(short)num;
		System.out.println(sh); // -32767�� ���´�
		// 0 1 2 .. 32767
		// -1 -2 ... -32768
		//���� �ΰ��� ��(circle)�̶�� �����ϸ�, -������ ��Ŭ�� ���Եȴ�. 2��ŭ ���̰� ���� -������ �ι��������� -32767
	}
}
//*/


/*


public class DataType3 {
	public static void main(String[] args) {
		short sh = 32767; // -32768 ~ 32767 
		int num = 32769; // -21�� ~ 21��
		
		num=sh; // int = short ����
		System.out.println("sh="+sh);
		System.out.println("num="+num);
		
		num=32769;
		// ū �ڷ����� ���� �ڷ����� �������� ����� ����ȯ�� �ؾ��Ѵ�.
		// ������ �ս� �߻�
		sh=(short)num;
		System.out.println(sh); // -32767�� ���´�
		// 0 1 2 .. 32767
		// -1 -2 ... -32768
		//���� �ΰ��� ��(circle)�̶�� �����ϸ�, -������ ��Ŭ�� ���Եȴ�. 2��ŭ ���̰� ���� -������ �ι��������� -32767
	}
}
//*/