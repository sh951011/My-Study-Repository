package day_06;

public class Telephone extends Phone{
	private String when;
	
	public Telephone(String owner,String when) {
		super(owner);
		this.when=when;
	}

	void autoAnswering() {
		super.talk();
		System.out.println("��ȭ ���̴� " + when+"�� �ٽ� ��ȭ�ֽñ� �ٶ��ϴ�.");
	}
}
