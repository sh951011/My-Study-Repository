package ex04.Synchronized;

public class MainEntry {
	public static void main(String[] args) {
		Atm at = new Atm(1000);

		UserAtm user1 = new UserAtm(at, "���ȯ");
		UserAtm user2 = new UserAtm(at, "��ȯŴ");
		UserAtm user3 = new UserAtm(at, "��Ŵ");

		user1.start();
		user2.start();
		user3.start();
	}
}

/* ATM START */
class Atm {
	private int money;

	public Atm(int money) { // ������ �Լ�
		this.money = money;
	}

	/* �Ա� �Լ� */
	public void deposit(int amount, String name) {
		synchronized (this) {
			money += amount;
			System.out.println(name + " : �Աݱݾ� " + amount);
		}
	}
	/* �Ա� �Լ� */

	/* ��� �Լ� */
	public void withdraw(int amount, String name) {
		synchronized (this) {
			if (money > amount) {
				Thread.yield();
				money -= amount;
				System.out.println(name + " : ��ݱݾ� " + amount);
			} else {
				System.out.println("ERROR!! �ݾ��� �����մϴ�!!!");
			}
		}
	}
	/* ��� �Լ� */

	/* ���� �ܰ� �Լ� */
	public void getMoney() {
		System.out.println("                                          �ܾ��� : " + money + " �Դϴ�.");
	}
	/* ���� �ܰ� �Լ� */
}
/* ATM END */

/* UserAtm START */
class UserAtm extends Thread {
	Atm obj;
	boolean flag = false;

	/* ������ �Լ� */
	public UserAtm(Atm obj, String name) {
		super(name);
		this.obj = obj;
	}

	@Override
	public void run() { // ������ ������ ������ �־�ߵ�
		for (int i = 0; i < 2; i++) {
			try {
				sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (flag) {

				obj.deposit((int) (Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();

			} else {

				obj.withdraw((int) (Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();
			}
		}

		flag = true;
	} // for end

}
/* UserAtm END */