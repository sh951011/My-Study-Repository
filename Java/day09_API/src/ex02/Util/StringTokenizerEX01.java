package ex02.Util;
import java.util.*;

public class StringTokenizerEX01 {
	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("���ȯ/��ȯŴ/��ȯ��/ŷ��ȯ/����ȯ","/");
		
		while(token.hasMoreTokens()){	// ���� token�� �ִٸ�  �� �������� / �� �ִٸ�
			System.out.println(token.nextToken());
		}
	}
}
