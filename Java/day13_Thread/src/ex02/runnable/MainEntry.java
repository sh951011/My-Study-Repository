package ex02.runnable;

public class MainEntry {
	public static void main(String[] args) {
		new Thread(new UserRunnable("ur")).start();
		new Thread(new UserRunnable("ur2")).start();
		new Thread(new UserRunnable("ur3")).start();
	}
/*	UserRunnable ur = new UserRunnable("SooHwan");
	UserRunnable ur2 = new UserRunnable("SooHwan2");
	Thread t1 = new Thread(ur);	//	runnable���� start�� ���⶧���� ������ش�
	Thread t2 = new Thread(ur2);	//	runnable���� start�� ���⶧���� ������ش�
	
	t1.start();
	t2.start();
	*/
}