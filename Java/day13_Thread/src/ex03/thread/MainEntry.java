package ex03.thread;

public class MainEntry {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority(); 			// ���׵��� �켱����
		Thread.State state = Thread.currentThread().getState(); 	// ���� ������ ����
		
		System.out.println("���� Thread ID : " + id);	// �ý����� �ο�����
		System.out.println("���� Thread name : " + name);
		System.out.println("���� Thread state : " + state);
		System.out.println("���� Thread priority : " + priority);
		
	}
}
