package day_06;

public class MainEntry {
	public static void main(String[] args) {
		Person[] p = {new Person("ȫ�浿",20),new Student("���ȯ", 25,2014707073),new ForeignStudent("Ishmanof",40,12010101,"ī���彺ź")};
		
		for(Person item : p) {
			System.out.println("## " + item.getClass().getSimpleName());
			item.print();
			System.out.println();
		}
	}
}
