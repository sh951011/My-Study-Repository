package java_finalExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapEx3 {
	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		hm.put("���ȯ", 100);
		hm.put("�����", 0);
		hm.put("������", 50);
		hm.put("�Ͽ���", 80);
		
		for(int i=0;i<2;i++){
		System.out.print("���� ���� ���� : ");
		Scanner sc = new Scanner(System.in);
		String find = sc.next();
		
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		
			while(it.hasNext()){
				String str = it.next();
				if(str.equals(find)){
					Integer st = hm.get(find);
					System.out.println("����? " + st);
				}
			}
		}
	}
}
