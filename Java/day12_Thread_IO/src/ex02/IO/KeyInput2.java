package ex02.IO;
import java.io.*;

public class KeyInput2 {
	public static void main(String[] args) throws IOException {
		int num1=0,num2=0;
		
		System.out.println("������ �Է� ���� Ctrl + Z�� ��������");
		
		while(true){
			num1=System.in.read();
			System.out.println((char)num1);
			if(num1==26){
				return;
			}
		}
	}
}
