package ex02.IO;
import java.io.*;

public class Four {
	public static void main(String[] args) throws IOException {
		char mode=0;
		int num1=0,num2=0;

		InputStream is =System.in;
		
		System.out.println("+,-,*,/ �� �����ϼ���.");
		mode=(char) is.read();
		
		is.read();	is.read();
		
		System.out.print("���� 1�� �Է����ּ���.");
		num1=is.read();
		
		is.read();	is.read();
		
		System.out.print("���� 2�� �Է����ּ���.");
		num2=is.read();
		
		switch(mode){
		case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println(num1/(double)num2);
			break;
		default:
				break;
		}
	}
}
