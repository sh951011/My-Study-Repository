package day180719;

import java.util.LinkedList;
import java.util.Scanner;

/*
 ��ǰ����
 ��ǰ - ��ǰ�ڵ� ��ǰ�� ���� ��ǰ����
 
 �� - �̸� ��ȭ��ȣ ��ٱ���
 
 ��ٱ��� ��ǰ & �� ����
 
  �����UI - 1 ��ǰ�߰� 2 ��ǰ���� 3 ��ǰ��ȸ 4 ��� ��ǰ ���
  
  
  ��ٱ��� - ���� ��ǰ ����
  					- �ٱ��Ϲ�ȣ ��ǰ�� ���� ��ǰ���� ���� �����
 */

public class MainEntry {
	public static void main(String[] args) {
		LinkedList goods = new LinkedList();
		LinkedList customer = new LinkedList();
		LinkedList cart = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int goods_select = 0;
		int select = 0;
		Goods gs = new Goods();
		Customer cs = new Customer();
		Cart ct = new Cart();

		while (true) {
			System.out.println("==============");
			System.out.println("## 1. ��ǰ ����");
			System.out.println("## 2. �� ����");
			System.out.println("## 3. ��ٱ��� ���� ");
			System.out.println("## 4. ���α׷� ����");
			System.out.println("==============");
			do {
				System.out.print("INPUT : ");
				select = sc.nextInt();
			} while (select < 1 || select > 4);

			switch (select) {
			case 1:
				sangpum(goods, gs);
				break;
			case 2:
				gogaeck(customer, cs);
				break;
			case 3:
				jangbaguni(goods, customer, cart, ct);
				break;
			case 4:
				return;
			default:
				break;
			}
		}

	}

	public static void jangbaguni(LinkedList goods, LinkedList customer, LinkedList cart, Cart ct) {
		Scanner sc = new Scanner(System.in);
		int jang_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. ��ٱ��Ͽ� ���");
			System.out.println("## 2. ��ٱ��� ��ȸ");
			System.out.println("## 3. �ڷΰ���");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				jang_select = sc.nextInt();
			} while (jang_select < 1 || jang_select > 3);

			switch (jang_select) {
			case 1:
				ct.add(goods, customer, cart);
				break;
			case 2:
				ct.search_customer_linked_cart(cart);
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	public static void gogaeck(LinkedList customer, Customer cs) {
		Scanner sc = new Scanner(System.in);
		int gogaeck_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. ���߰�");
			System.out.println("## 2. ������");
			System.out.println("## 3. ����ȸ");
			System.out.println("## 4. ��� �� ���");
			System.out.println("## 5. �ڷΰ���");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				gogaeck_select = sc.nextInt();
			} while (gogaeck_select < 1 || gogaeck_select > 5);

			switch (gogaeck_select) {
			case 1:
				cs.add(customer);
				break;
			case 2:
				cs.remove_customer(customer);
				break;
			case 3:
				cs.search_customer(customer);
				break;
			case 4:
				cs.display(customer);
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}

	public static void sangpum(LinkedList goods, Goods gs) {
		Scanner sc = new Scanner(System.in);
		int goods_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. ��ǰ�߰�");
			System.out.println("## 2. ��ǰ����");
			System.out.println("## 3. ��ǰ��ȸ");
			System.out.println("## 4. ��� ��ǰ ���");
			System.out.println("## 5. �ڷΰ���");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				goods_select = sc.nextInt();
			} while (goods_select < 1 || goods_select > 5);

			switch (goods_select) {
			case 1:
				gs.add(goods);
				break;
			case 2:
				gs.remove_goods(goods);
				break;
			case 3:
				gs.search_goods(goods);
				break;
			case 4:
				gs.display(goods);
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}
}