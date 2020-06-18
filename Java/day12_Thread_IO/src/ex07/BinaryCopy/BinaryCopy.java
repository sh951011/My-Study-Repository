package ex07.BinaryCopy;
import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File("C:/Windows/explorer.exe");  //������ - �������
		File dist = new File("C:/Users/Soohwan/Desktop/��ȯ/explorer.bin"); //������ - ������ ��ġ
		int count;
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream  bis = null;
		BufferedOutputStream  bos = null;
		System.out.println("== ���ȯ ==");
		try {
			fis = new FileInputStream(src);  //���� �Է� ����Ʈ ��Ʈ�� ����
			fos = new FileOutputStream(dist); //���� ��� ����Ʈ��Ʈ�� ����
			bis = new BufferedInputStream(fis);  //���� �Է½�Ʈ�� ����
			bos = new BufferedOutputStream(fos); //���� ��½�Ʈ�� ����
			
			while( (count = bis.read())  != -1 ) {
				bos.write((char)count);
			} // end while
			
			System.out.println("���� ���� ����");
			bis.close();			bos.close();			fis.close();			fos.close();
		} catch (Exception e) {
			System.out.println("���� ���� ���� �߻�~~~~");
		}
			
	}
}
