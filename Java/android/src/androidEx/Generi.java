package androidEx;

import java.util.ArrayList;

public class Generi {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Person<String> soohwan = new Person<String>();
		
		list.add("a");
		list.add("b");
		list.add(3);// <- String���� Ÿ�� ������ �״µ� 3�� �־��༭ ����
	}
}

class Person <T>{
	public T info;
}
