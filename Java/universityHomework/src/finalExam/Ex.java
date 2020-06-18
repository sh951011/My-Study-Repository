package finalExam;

public class Ex {
	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;	// thread1�� thread2�� sharedArea ������ �Ȱ��� ��ü��
		thread2.sharedArea = obj;	// set�������ν� ���� ���� �޸𸮸� �����ϰ� �Ѵ�.
		thread1.start();
		thread2.start();
	}
}

class SharedArea{
	double result;
	boolean isReady;
}

class CalcThread extends Thread{
	SharedArea sharedArea;	// ������ sharedArea �� �ᱹ main�� obj
	public void run(){
		double total = 0.0;
		for(int cnt=1;cnt<100000000;cnt+=2){
			if(cnt / 2 % 2 ==0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		}
		sharedArea.result = total + 4;
		sharedArea.isReady=true; // ����� �������� �˷��ִ� �κ�
		synchronized(sharedArea){
			sharedArea.notify();
		}
	}
}

/* 
�ϳ��� ��ü�� wait�� notify�� �ִٸ� ������ wait -> notify�� �Ǿ�� �Ѵ�.

if(sharedArea.isReady != true)�� ���� ��츦 �����غ���,
���࿡ thread2���� ���������� ���۸��� �ɷ��� thread1�� ��� ����� ������
notify()���� ������ �� �ڿ�,  thread2�� ������ �Ǽ� wait()�� ������ �ȴٸ�,
���α׷��� '���Ѵ��' ���¿� �����Եȴ�.
�̸� �����ϱ� ����, ���� ����� ������ �ʾҴٸ�, if(sharedArea.isReady != true)
�̶�� ������ �༭ wait()�ϰ� �� ���� ��,,

�׷��ٸ� �� wait()�� notify()�� �׻� synchronized ��Ͼȿ� �־�� �ϴ°�??

wait()�� ���� ����ȭ ��Ͼȿ� ���� �ʾҴٰ� �����غ���, wait()�� �� ��, notify()�� �ؾ�
�ϴµ�, �� ������ ���� ���ɼ��� �ִ�. �׷��� ������, wait() -> notify() �� ������ �׻�
�����ϰ� �ϱ� ���� synchronized ��Ͼȿ� �ִ°��� �ʼ��������� �Ͽ�, 
�߰��� ���̴� ���� �����Ѵ�. ������ �̷��� ����ȭ ��Ͼȿ� �ִ���, ��� ����� 
wait()�� notify()�� ������ ���̴� ���� �����Ҽ��� ���� ������ ���� if��ó�� 
�����ڰ� ���� �� �ִ� ��Ȳ�� ���� ó���� ���־���Ѵ�.

��� �̻� ���ȯ �ǰ�
 */

class PrintThread extends Thread{
	SharedArea sharedArea;// ������ sharedArea �� �ᱹ main�� obj
	public void run(){
		if(sharedArea.isReady != true){
			try{
				synchronized(sharedArea){
					sharedArea.wait();
				}
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println(sharedArea.result);
	}
}