package day180719;
import java.util.*;

public class Goods {
	int code;
	String name;
	int price;
	String information;
	Scanner sc = new Scanner(System.in);
	
	
	/* ��ǰ �߰� */
	public void add(LinkedList goods){
		System.out.print("INPUT CODE : ");
		code=sc.nextInt();
		System.out.print("INPUT NAME : ");
		name=sc.next();
		System.out.print("INPUT PRICE : ");
		price=sc.nextInt();
		System.out.print("INPUT INFORMATION : ");
		information=sc.next();
		
		goods.add(code);
		goods.add(name);
		goods.add(price);
		goods.add(information);
	}
	/* ��ǰ �߰� */
	
	
	/* ��ǰ���� */
	public void remove_goods(LinkedList goods){
		int remove_code=0;
		
		System.out.print("�����Ͻ� ��ǰ �ڵ带 �Է����ּ��� : ");
		remove_code=sc.nextInt();
		
		for(int i=0;i<goods.size()-3;i+=4){
			if((int)goods.get(i)==remove_code){
				for(int j=0;j<4;j++){
					goods.remove(i);
				}
			}
		}
	}	
	/* ��ǰ���� */
	
	/* ��ǰ��ȸ */
	public void search_goods(LinkedList goods){
		int search_code=0;
		
		System.out.print("��ȸ�Ͻ� ��ǰ �ڵ带 �Է����ּ��� : ");
		search_code=sc.nextInt();
		
		
		for(int i=0;i<goods.size()-3;i+=4){
			if((int)goods.get(i)==search_code){
				System.out.println("CODE : " + goods.get(i));
				System.out.println("NAME : " + goods.get(i+1));
				System.out.println("PRICE : " + goods.get(i+2));
				System.out.println("INFORMATION : " + goods.get(i+3));
			}
		}
	}
	/* ��ǰ��ȸ */
	
	/*  ��� ��ǰ�� ��� */
	public void display(LinkedList goods){
		for(int i=0;i<goods.size()-3;i+=4){
			System.out.println("==============");
			
			System.out.println("CODE : " + goods.get(i));
			System.out.println("NAME : " + goods.get(i+1));
			System.out.println("PRICE : " + goods.get(i+2));
			System.out.println("INFORMATION : " + goods.get(i+3));
			
			System.out.println("==============");
		}
	}
	
	/* SET & GET */
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	/* SET & GET */
	
}
