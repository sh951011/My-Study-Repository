package ex05.problem;
import java.util.*;
import java.io.*;

public class Sawon {
	Scanner sc = new Scanner(System.in);
	
	public void file() throws FileNotFoundException{
		OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/��ȯ/Workspace/day12_Thread,IO/Sawon.txt");
		String str =new String();
		String space = "  ";
		try{
			while(true){
				System.out.println("�����÷��� �������� exit�� �����ּ��� (��ҹ��� ���x)");
				
				System.out.print("�̸� : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());
				
				System.out.print("���� : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());
				
				System.out.print("�μ� : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());

			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
