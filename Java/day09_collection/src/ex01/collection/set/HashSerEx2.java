package ex01.collection.set;
import java.util.*;

public class HashSerEx2 {
	public static void main(String[] args) {
		Object[] objArr = {"1",new Integer(1),"2","3","4","4","4"};
		
		Set set = new HashSet();		// �θ�κ��� �ڼհ�ü ���� ����
		
		for(int i=0;i<objArr.length;i++){
			set.add(objArr[i]);
		}
		
		System.out.println("set : " + set);	// �ڷ����� �ٸ� 1�� ���� �ٸ��� �ν��Ѵ�.
	}
}
