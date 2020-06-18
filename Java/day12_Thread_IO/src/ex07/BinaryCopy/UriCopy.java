package ex07.BinaryCopy;
import java.io.*;
import java.net.*;

public class UriCopy {
	public static void main(String[] args) 
			throws MalformedURLException, IOException{
			URL url = new URL("http://dongmoon.kw.ac.kr/wp-content/uploads/2017/05/11-1024x637.jpg");
			InputStream is = url.openStream();	//����ó��
			OutputStream os = new FileOutputStream("KwangWoon.jpg");	// 
			
			
			byte[] buffer = new byte[1024*8];
			
			
			
			while(true){
				int inputData = is.read(buffer);	// buffer ũ�⸸ŭ �о����
				if(inputData == -1){ 
					break;
				}
				else{
					os.write(buffer,0,inputData);	// bufferũ�⸸ŭ 0���ͽ��� 
					
				}
			}
			
			System.out.println("������ ���� �����߽�!!!! �����߽�!!!!!!!");
	}
}
