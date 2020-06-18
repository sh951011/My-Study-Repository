package second;

public class MainEntry {
	public static void main(String[] args) {
		int aArray[] = new int[] { 1, 2, 3, 4, 5 }; 	// a��� �迭�� �����ϰ� {1,2,3,4,5}�� �־��ش�
		int bArray[] = new int[] { 9, 8, 7, 6, 5 }; 	// b��� �迭�� �����ϰ� {9,8,7,6,5}�� �־��ش�
		int aArrayAddress[] = aArray;	 // a�� a�迭�� �ּ��̹Ƿ� �� �ּҸ� ���� �������ش� (swap�� ����)
		int bArrayAddress[] = bArray; 	// b�� b�迭�� �ּ��̹Ƿ� �� �ּҸ� ���� �������ش� (swap�� ����)
		Swap sw = new Swap();

		printArray(aArray, bArray); 
		
		/* swap */
		aArray = sw.changeArrayAddress(bArrayAddress); 	// a�迭 �ּ� -> b�迭 �ּҷ� ����
		bArray = sw.changeArrayAddress(aArrayAddress); 	// b�迭 �ּ� -> a�迭 �ּҷ� ����
		/* swap */
		
		System.out.println("=====swap=====\n");
		printArray(aArray, bArray);
	}
	
	/* ���ڷ� ���� �迭���� ������ִ� �޼��� */
	private static void printArray(int[] a, int[] b) {
		System.out.print("## �迭 aArray : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
		System.out.print("## �迭 bArray : ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("\n");
	}
}

class Swap {
	/* ���ڷ� ���� �迭�� �ּҷ� �ٲ��ִ� �޼��� */
	public int[] changeArrayAddress(int changeAddress[]) {
		return changeAddress;
		// �ٲ��ְ� ���� �迭�� �ּҸ� �޾� return���ش�
	}
}