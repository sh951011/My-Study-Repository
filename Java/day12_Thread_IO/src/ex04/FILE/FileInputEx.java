package ex04.FILE;
import java.io.*;
import java.util.*;

public class FileInputEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try{
		//	OutputStream os = new FileOutputStream("mome.txt");	�����
			// OutputStream os = new FileOutputStream("C:\\Users\\Soohwan\\Desktop\\��ȯ\\Workspace\\day12_Thread,IO\\mome.txt");
			OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/��ȯ/Workspace/day12_Thread,IO/mome.txt");
			
			while(true){
				System.out.print("���ڿ� �Է� ��� : ");
				String str = sc.nextLine() + "\r\n";
				
				if(str.equalsIgnoreCase("EXIT\r\n")){
					break;
				}
				
				os.write(str.getBytes());	// ���ܹ߻�, �о���� ���� str�� ���� (getBytes()��ŭ ���ּ���)
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
