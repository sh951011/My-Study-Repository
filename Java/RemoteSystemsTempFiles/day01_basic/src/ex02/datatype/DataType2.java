package ex02.datatype;

public class DataType2 {
	public static void main(String[] args) {
		String str = "A";	// ���ڿ�, " ", 2byte -> A\0 
		char ch = 'A';	// ���� , ' ', 1byte 
		char ch2=67; // �ƽ�Ű�ڵ尪 67�� �ش��ϴ� ���ڷ� ����
		int su=20;
		String aa="Happy"; // �ڹٴ� c���� �ٸ��� ���ڿ� data type�� �����Ѵ�
		double d=12.345;
		
		System.out.println((int)ch); // ����ȯ �ϴ¹� c���� ����
		System.out.println(ch2);
		System.out.println(su);
		System.out.println(aa);
		System.out.println(str);
		System.out.println(d);
		System.out.println(ch+ch2); // 132�� ������ �ȴ�
		System.out.println(ch + "," + ch2); // A,C�� �и��Ǿ� ���´�
		
		for(int i=65;i<=90;i++){
			System.out.println((char)i);
		}
		
		System.out.println("\n\n boolean type");
		boolean flag=true;
		System.out.println(flag);
	
	}
}
