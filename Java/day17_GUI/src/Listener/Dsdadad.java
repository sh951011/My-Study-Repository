package Listener;

import java.util.Scanner;

public class Dsdadad {
	public int add(int a,int b){
		
		return 0;
	}
	
	public void print(){
		int sum=0;
		System.out.println("print");
		
		sum=add(10,20);
		
		return;
	}
	
	public char swit(){
		return 'c';
	}

	public static void main(String[] args) {
		int num=0;
		Scanner sc = new Scanner(System.in);

		
		switch(num){
		case 1:
			System.out.println("1�� ����");
			break;
		case 2:
			System.out.println("2�� ����");
			break;
		case 3:
			System.out.println("3�� ����");
			break;
		case 4:
			System.out.println("4�� ����");
			break;
			default:
				System.out.println("�߸��Է�");
				break;
		}
		
		
		System.out.println("INPUT : ");
		num=sc.nextInt();
	}
}
