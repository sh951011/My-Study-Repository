package ex01.collection.set;
import java.util.*;

/* Set : ��������, �ߺ� ��� x */
public class HashSetEx1 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();		// String���θ� �����Ұž�! ��� �ǹ� ��, <>�� type ����
		 
		hs.add("���ȯ��");
		hs.add("Ŵ");
		hs.add("��Ŵ");
		hs.add("���ȯ");
		hs.add("Ŵ");
		
		HashSet<Integer> hs2 = new HashSet<Integer>();		// type������ �ы��� �⺻ �ڷ����� �ƴ� class �ڷ������� ������ �־� �Ѵ�
		hs2.add(200);
		hs2.add(100);
		hs2.add(30);
		
		Iterator it2 = hs2.iterator();
		
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		System.out.println("=================");
		
		System.out.println("��� ���� : " + hs.size());		// set�� �ߺ��� ���� �ʱ⶧���� "Ŵ"�� �ѹ��� ����ȴ�
		
		Iterator it = hs.iterator();
		while(it.hasNext()){		// ���� ��Ұ� �ִٸ�
			System.out.println(it.next()); 	// ��Ҹ� �����ͼ� �����	, set�� ������ ���� ������ ������ ���Ƿ� �����Ǽ� ���´�.
		}
		
		System.out.println("=================");
		for(Object item : hs){
			System.out.println(item);
		}
	}
}
