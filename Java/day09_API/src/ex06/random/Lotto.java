package ex06.random;
import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		int num=7;
		int[] lotto_num = new int[num];		//1~45
		int[] user_num = new int[num];
		int count=0;
		boolean overlap=false;
		
		for(int i=0;i<num;i++){
			lotto_num[i] = (int)(Math.random() *45+1);
			for(int j=1;j<=i;j++){
				if(lotto_num[i]==lotto_num[j-1]){
					overlap=true;
				}
			}
			if(overlap){
				i--;
			}
			overlap=false;
		}
		
		for(int i=0;i<num;i++){
			user_num[i] = (int)(Math.random() *45+1);
			for(int j=1;j<=i;j++){
				if(user_num[i]==user_num[j-1]){
					overlap=true;
				}
			}
			if(overlap){
				i--;
			}
			overlap=false;
		}
		
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				if(user_num[i]==lotto_num[j]){
					count++;
				}
			}
		}

		
		for(int i=0;i<num-1;i++){
			System.out.println("�ζ� ��÷ " + (i+1) + "��° ��ȣ : " + lotto_num[i]);
		}
    	System.out.println("�ζ� ��÷ ����� ��ȣ : " + lotto_num[num-1]);
    	
    	System.out.println("=====================");
    	
		for(int i=0;i<num-1;i++){
			System.out.println("���� " + (i+1) + "��° ��ȣ : " + user_num[i]);
		}
    	System.out.println("���� ����� ��ȣ : " + user_num[num-1]);
    	System.out.println("=====================");
    	System.out.println(count + "���� ���ڰ� ��ġ�մϴ�");
	}
}
