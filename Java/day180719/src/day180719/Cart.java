package day180719;

import java.util.*;

public class Cart {
	Scanner sc = new Scanner(System.in);
	/* ��ǰ �߰� */
	public void add(LinkedList goods, LinkedList customer, LinkedList cart) {
		String name = null;
		String phone_number = null;
		String goods_name;
		String buffer;
		char yes_or_no;
		boolean find=false;
		boolean login = false;

		/* �� �̸�, ����ȣ �̿��ؼ� �α��� */
		System.out.print("������ �̸��� �Է����ּ���. : ");
		name = sc.next();
		for (int i = 0; i < customer.size() - 2; i += 3) {
			if (name.equals((String) customer.get(i))) {
				System.out.print("������ �� ��ȣ�� �Է����ּ���. :");
				phone_number = sc.next();
				if (phone_number.equals((String) customer.get(i + 1))) {
					login = true;
					if (login) {
						System.out.println("�α��ο� �����ϼ̽��ϴ�!!");
					} else {
						System.out.println("�α��ο� �����ϼ̽��ϴ�!!");
						return;
					}
				}
			}
		}
		/* �� �̸�, ����ȣ �̿��ؼ� �α��� */

		while (true) {

			System.out.print("���Ͻô� ��ǰ���� �Է����ּ��� : ");
			goods_name = sc.next();

			for (int i = 1; i < goods.size() - 2; i += 4) {
				if (goods_name.equals((String) goods.get(i))) {
					find=true;
					System.out.println("## ��ǰ�� : " + goods.get(i));
					System.out.println("## ���� : " + goods.get(i + 1));
					System.out.println("## ��ǰ���� : " + goods.get(i + 2));
					System.out.println("## ��ǰ�ڵ� : " + goods.get(i - 1));
��
					System.out.print("\n�ش� ��ǰ�� ��ٱ��Ͽ� �����ðڽ��ϱ�??? (y/n)");
					buffer = sc.next();
					yes_or_no = buffer.charAt(0);

					switch (yes_or_no) {
					case 'y':
					case 'Y':
						cart.add(name);	// �� �̸�
						cart.add(phone_number);	// �� �� ��ȣ
						cart.add(goods.get(i)); // ��ǰ��
						cart.add(goods.get(i + 1)); // ����
						cart.add(goods.get(i - 1)); // ��ǰ�ڵ�
						
						/* ��ٱ��Ͽ� ���� ��ǰ ���� */
						for(int j=0;j<4;j++){
							goods.remove(i-1); // ��ǰ������ ã�µ� ��ǰ���� 2��° ����̹Ƿ� i-1���� 4�� ����
						}
						
						break;

					case 'n':
					case 'N':

						break;

					default:
						break;
					}

				}
			}
			if(!find){
				System.out.println("�ش��ϴ� ��ǰ�� �����ϴ� ��.��");
			}
			
			System.out.print("��� �Ͻðڽ��ϱ�?? �׸��ν÷��� N�� �����ּ��� : ");
			buffer = sc.next();
			yes_or_no = buffer.charAt(0);
			switch (yes_or_no) {
			case 'n':
			case 'N':
				return;
			default:
				break;
			}
		}
	}
	/* ��ǰ �߰� */
	
	/* �� ��ٱ��� ��ȸ */
	public void search_customer_linked_cart(LinkedList cart){
		String customer_name;
		
		System.out.print("��ٱ��� ��ȸ�Ͻ� ���̸��� �Է����ּ��� : ");
		customer_name = sc.next();
		
		System.out.println("=====" + customer_name +"���� ��ٱ��� ����Ʈ=====");
		
		for(int i=0;i<cart.size()-4;i+=5){
			if(customer_name.equals((String)cart.get(i))){
			System.out.println("========================");
			
			System.out.println("�� �̸� : " + cart.get(i));
			System.out.println("�� �� ��ȣ : " + cart.get(i+1));
			System.out.println("������ ��ǰ�� : " +cart.get(i+2) );
			System.out.println("������ ��ǰ ���� :  " + cart.get(i+3));
			System.out.println("������ ��ǰ �ڵ� :  " + cart.get(i+4));
			
			System.out.println("========================");
			}
		}
	}
	/* �� ��ٱ��� ��ȸ */

}
