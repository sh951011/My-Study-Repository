package method;
import java.util.*;

public class MethodTest3 {
	public static void main(String[] args) {
		int[] arr={0,0,0,0,0};
		int p_1=0;
		double p_2=0;
		String p_3=null;
		Scanner sc = new Scanner(System.in);
		String str=null;
		// ���� 3��
		System.out.println("===========����3��============");
		for(int i=0;i<5;i++){
			System.out.println("arr["+i+"] = "+pro3(arr,i));
		}
		
		// ���� 4��
		System.out.println("===========����4��============");
		p_1=pro4_1();
		p_2=pro4_2();
		p_3=pro4_3();
		System.out.println("int ��� "+p_1);
		System.out.println("DOUBLE ��� "+p_2);
		System.out.println("STRING ��� "+p_3);
		
		
		
		// ���� 5��
		System.out.println("===========����5��============");
		System.out.print("INPUT X :");
		int x=sc.nextInt();
		System.out.print("INPUT Y :");
		int y=sc.nextInt();
		System.out.print("INPUT STRING :");
		str=sc.next();
		pro5(x,y,str);
	}
	
	// ���� 3��
	public static int pro3(int[] arr,int x){
		arr[x]=x+1;
		
		return arr[x];
	}
	
	// ���� 4��
	public static int pro4_1(){
		System.out.print("INPUT X : (INT)");
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		
		return x;
	}
	
	public static double pro4_2(){
		System.out.print("INPUT Y : (DOUBLE)");
		Scanner sc = new Scanner(System.in);
		double y=sc.nextDouble();
		
		return y;
	}
	
	public static String pro4_3(){
		System.out.print("INPUT STRING : ");
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		
		return str;
	}
	
	public static void pro5(int x,int y,String str){
		if(x>y){
			for(int i=x-1;i<y;i++){
				System.out.print(str.charAt(i));
			}
		}
		else{
			for(int i=y-1;i<x;i++){
				System.out.print(str.charAt(i));
			}
		}
	}
}
