package method;

import java.util.*;

class b{
	public static void set(){
		System.out.println("2�ð� 30�� ���ҵ�ƾ�~!@!!#@!$@~$");
	}
}

public class StaticMethod {
	public static void main(String[] args) {
		show();
		b.set();
	}
	
	public static void show(){
		System.out.println("2�ð� 30�� ���ҵ�ƾ�~!@!!#@!$@~$");
	}
}

/*
��ü��.�Լ��̸�() -> ȣ���� ( ���� class �Ҽ��� �ƴҶ� )
�Լ��̸�() -> ȣ���� ( ���� class �Ҽ��� �� )

�տ� static ���δ� -> static �Լ�
�տ� static �Ⱥ��δ� -> instance �Լ�
*/