package ex01.thread;

public class UserThread extends Thread{
	String name;
	
	public UserThread(String name){
		this.name = name;
	}

	@Override
	public void run() {	// ���� ������ �����(������)
	//	System.out.println(name);
	//	System.out.println("start �޼ҵ忡 ���� run()�� �����ȴ� (������)");
			for(int i=0;i<=10;i++){
				if(i==7){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name);
				}
				System.out.println(i);
			}
	}
}
