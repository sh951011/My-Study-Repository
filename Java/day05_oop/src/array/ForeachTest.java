package array;

public class ForeachTest {
	public static void main(String[] args) {
		int[] a={7,1,3,5,2};
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");
		}
		
		System.out.println("\n foreach - Ȯ�� FOR���� ������ô�!!");
		//for (�ڷ��� ������ : �迭�� �Ǵ� �÷��Ǹ�) { �ݺ����๮; }
		for(int item : a){
			System.out.print(item + "\t");
		}
	}
}
