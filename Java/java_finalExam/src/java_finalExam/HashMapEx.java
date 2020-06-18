package java_finalExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String,String>();
		int i=1;
		
		hm.put("apple", "���");
		hm.put("banana", "�ٳ���");
		hm.put("grape", "����");
		hm.put("pineapple", "���ξ���");
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()){
			String key = it.next();
			String val = hm.get(key);
			System.out.println(i+"��° key : "+key +"\n"+i+"��° value : "+val);
			i++;
		}	
	}
}
