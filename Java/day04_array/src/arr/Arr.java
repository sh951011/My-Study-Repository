package arr;

public class Arr {
	public static void main(String[] args) {
		char[] ch;
		ch=new char[4];	// ��� 1
		
		char[] ch2=new char[4]; // ���2
		
		ch[0]='J';
		ch[1]='A';
		ch[2]='V';
		ch[3]='A';
		
		// �迭�� ����   " �迭�̸�.length "
		System.out.println("�迭�� ���� : " + ch.length);
		
		// �迭�� ���� ���
		
		for(int i=0;i<4;i++){
			System.out.print(ch[i]+" ");
		}
	}
}
