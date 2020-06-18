package ex07.BinaryCopy;
import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		// �бⰴü - FileInputStream
		InputStream is = new FileInputStream("C:/Users/Soohwan/Desktop/��ȯ/Java����/apple.jpg");
		// ���ⰴü - FileOutputStream
		OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/��ȯ/Java����/kiki.png");
		
		byte[] buffer = new byte[1024*8];
		
		long start = System.currentTimeMillis();
		
		while(true){
			int inputData = is.read(buffer);	// buffer ũ�⸸ŭ �о����
			if(inputData == -1){ 
				break;
			}
			else{
				os.write(buffer,0,inputData);	// bufferũ�⸸ŭ 0���ͽ��� 
				
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}