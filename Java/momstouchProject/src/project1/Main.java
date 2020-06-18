package project1;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		LinkedList component_name = new LinkedList(); // ��� �̸� ������ ����Ʈ
		LinkedList component_num = new LinkedList(); // ��� ������ ������ ����Ʈ
		LinkedList component_min = new LinkedList(); // ��� �����ð��� ������ ����Ʈ
		About_SQL sql = new About_SQL(); // SQL������ �޼ҵ尡 �ִ� Ŭ����
		Vector<Integer> receiveCode = new Vector<Integer>(3, 4); // 3���� �ʱ�
																	// ��������ϰ�
																	// ��ĥ������ 4����
																	// �߰��Ѵ� (�ڵ带
																	// �޴�
																	// Vector)
		Vector<String> codeBuffer = new Vector<String>(3, 4);
		sql.connect_SQL();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI(codeBuffer, component_name, component_num, component_min);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}