package ex08.Problem;

import java.util.*;
import java.io.*;

public class MainEntry {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Student st = new Student();
		LinkedList student = new LinkedList();
		LinkedList non_student = new LinkedList();
		Scanner sc = new Scanner(System.in);
		OutputStream os = new FileOutputStream("C:/IDE/person.txt");
		String cont;
		char mode=' ';
		
		while(true){
			st.input();
			st.list(non_student, student);
			st.file(non_student, student, os);
			
			System.out.println("��� �Ͻðڽ��ϱ�??? (y/n)");
			cont=sc.next();
			mode=cont.charAt(0);
			switch(mode){
			case 'y' : case 'Y':
				System.out.println("��� �����մϴ�.\n");
				break;
			case 'n' : case 'N' :
				System.out.println("����");
				return;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		
		}
	}
}
