package test;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		// uiȭ�鿡�� code�� ������ �Ѿ�´�
		// for(int i=0;i<����;i++){
		//	code�� �ش��ϴ� ��ǰ�� �߰�
		// }
		LinkedList component = new LinkedList();
		int code=301;
		int amount=2;
		Connect_SQL cs = new Connect_SQL();	// sql����
		Overlap ov = new Overlap();
		
		/* ������ŭ �����Ѵ� */
		for(int i=0;i<amount;i++){
			cs.bring_SQL(code,component);
		}
		
		ov.plus(component);
		
		for(int i=0;i<component.size();i++){
			System.out.println(component);
		}
	}
}
