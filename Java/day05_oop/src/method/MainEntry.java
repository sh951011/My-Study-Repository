package method;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {	// ������(������)
		int a=0;
		String str="KimSooHwan";
		Scanner sc = new Scanner(System.in);

		System.out.print("INPUT X : ");
		int x=sc.nextInt();
		System.out.print("INPUT Y : ");
		int y=sc.nextInt();
		
		a=add(x,y);
		
		System.out.println(a);
	}
	
	// 1) �Ű����� ����, ����Ÿ�� ���� ���
	public static void display(){
		System.out.println("yo-yo-�ȳ��ϼ�-yo");
	}
	
	// 2) �Ű����� �ְ�, ����Ÿ�� ���� ���
	public static void plus(int x,int y,String name){
		int sum=x+y;
		System.out.println("SUM= "+(x+y)+", "+ name);
	}
	
	public static void problem1(int x,int y,String str){
		for(int i=x-1;i<y;i++){
			System.out.print(str.charAt(i)+" ");
		}
	}
	
	// 3) �Ű����� ����, ����Ÿ�� �ִ� ���(������)
	public static int add(int x,int y){
		int sum=0;
		
		sum=x+y;
		
		return sum;
	}
}