package ex01.thread;

public class MainEntry {
	public static void main(String[] args) {
		UserThread t1 = new UserThread("t1");
		Thread t2 = new UserThread("t2");
		Thread t3 = new UserThread("t3");
		
		t1.start(); 	// run() �����Ѵ�
		t2.start();
		t3.start();
	}
}
