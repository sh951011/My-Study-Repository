package JFRAME2;

import java.util.Date;

import Alarm.Music;

public class TimerListener {
	public void dosomething(){
		Date d = new Date();

		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(d.getHours()==11 && d.getMinutes() == 30){
					System.out.println("�ð��ǥ�!!!!!!");
					
					
					Music introMusic = new Music("WayBackHome.mp3", true); // �뷡���
					introMusic.start();
			}
		}
	}
}

/*
���ø��޼ҵ������� �޼ҵ� �����߿� Ư�� ���ۿ� ���� �߻�޼ҵ� ȣ��� �������
�ش� �۾��� �ڽ�Ŭ������ �������̵�� �������� ä�������� �ϴ� ��
-> Ű������ ����!!
*/