//*
package ex00.scanner;

import java.util.Scanner;

public class Scan {
	public static void main(String[] args) {
		// System.in : ǥ���Է� 
		int num=0;
		String Name="0";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Inteager : ");
		num=sc.nextInt();
		System.out.print("Input Name : ");
		Name=sc.nextLine();
		
		System.out.println(num);
		System.out.println(Name);
	}
}
//*/