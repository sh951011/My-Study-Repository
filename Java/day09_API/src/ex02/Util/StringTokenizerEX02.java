package ex02.Util;
import java.util.*;

public class StringTokenizerEX02 {
	public static void main(String[] args) {
/*		StringTokenizer token = new StringTokenizer("���ȯ ŷ��ȯ ����ȯ ��ȯ�� ��ȯŴ ��Ŵ SHW@N");
		
		while(token.hasMoreTokens()){	// ���� ��Ұ� �ִٸ�???
			System.out.println(token.nextToken());
		}*/
		
		StringTokenizer token = new StringTokenizer("���=5 | ���ڷ�=3 | ������=1","=",true);
		while(token.hasMoreTokens()){	// ���� token�� �ִٸ�
			String str = token.nextToken();
			
			if(str.equals("=")){	System.out.print("\t");}
			else if(str.equals("|")){	System.out.print("\n");}
			else{	System.out.println(str);}
		}
	}
}

// ���� �����ڸ� �� �־�����, default���� ' ' �̱� ������ �˾Ƽ� ������ ��