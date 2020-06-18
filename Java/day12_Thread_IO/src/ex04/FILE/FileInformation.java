package ex04.FILE;
import java.io.*;
import java.util.*;

public class FileInformation {
	public static void main(String[] args) throws IOException {
		File fp = null;
		byte[] fileName = new byte[100];
		String strName;
		
		System.out.print("file name = ");
		System.in.read(fileName); 	// ���ܹ߻�w
		strName = new String(fileName).trim(); // ������ �о ���� �̸� �޾ƿ� ( �������� )
		
		fp = new File(strName);
		
		System.out.println("������ : " + fp.getAbsolutePath());
		System.out.println("ǥ�ذ�� : " + fp.getCanonicalPath());
		System.out.println("���������� : " + new Date(fp.lastModified()));
		System.out.println("����ũ�� : " + fp.length());
		System.out.println("�б�Ӽ� : " + fp.canRead());
		System.out.println("����Ӽ� : " + fp.canWrite());
		System.out.println("���ϰ�� : " + fp.getPath());
		System.out.println("����Ӽ� : " + fp.isHidden());
		
		// ����� memo.txt
		// ������ D:\java..
		
	}
}
