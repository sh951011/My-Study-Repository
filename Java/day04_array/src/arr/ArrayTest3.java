package arr;
import java.util.*;

public class ArrayTest3 {
	public static void main(String[] args) {
		// ����1] Ư������ ��� ������ ���ϴ� ���α׷� �ۼ� (��,30�� ����)
		// ���� ���Ƿ� �� �� Ȯ���� 20%�� ����
		// ����� ���� 1~100������ ���� ������ ��
		int i=0;
		int NUM=30;
		double prob=0;
		int[]num = new int[NUM];
		int[] how_many= new int[NUM];
		int total=0;
		double average=0;
		
		for(i=0;i<NUM;i++){
			prob=Math.random();
			if(prob<=0.2){
				num[i]++;
				how_many[i]=(int)(Math.random()*100)+1;
			}
		}
		
		for(i=0;i<NUM;i++){
			if(num[i]==1){
				total+=how_many[i];
			}
		}
		average=total/(double)NUM;
		
		System.out.printf("�̹� ���� ������ �����  %.2f�Դϴ�",average);
	}
}
