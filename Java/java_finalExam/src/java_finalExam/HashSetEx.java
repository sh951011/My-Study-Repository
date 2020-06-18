package java_finalExam;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hSet = new HashSet<String>();
		
		hSet.add("First");
		hSet.add("Second");
		hSet.add("Third");
		hSet.add("First");
		
		System.out.println("����� ������ �� : " + hSet.size());
		
		Iterator<String> it = hSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
