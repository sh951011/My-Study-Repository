package day_05;

public class prac2 {
	public static int[] reverse(int[] org) {
		// �� �ڵ�
		/*
		for(int i=0;i<org.length;i++) {
			for(int j=0;j<=i;j++) {
					int buf=org[i];
					org[i]=org[j];
					org[j]=buf;
			}
		}
		*/
		// ������ �ڵ� -> for���� Ȯ ����
		
		for(int i=0;i<(org.length/2);i++) {
			int tmp;
			tmp=org[i];
			org[i]=org[org.length-1-i];
			org[org.length-1-i]=tmp;
		}
		
		return org;
	}
	
	public static void main(String[] args) {
		int[] num= {1,3,5,7,9};
		
		System.out.println("## Original\n");
		for(int n: num)
			System.out.print(n+ " ");
		
		System.out.println("\n\n## Reverse\n");
		num=reverse(num);
		for(int n: num)
			System.out.print(n+ " ");
	}
}
