package ex02.IO;
import java.io.*;

public class KeyInput {
	public static void main(String[] args) {
		InputStream is = System.in;	//	ǥ���Է�
		int num;
		
		try{
			System.out.print("���� ���� �Է� : ");
			num=is.read();
			System.out.println(num);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
