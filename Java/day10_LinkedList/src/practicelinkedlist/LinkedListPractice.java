package practicelinkedlist;
import java.util.*;

public class LinkedListPractice {
	Scanner sc = new Scanner(System.in);
	LinkedListPractice lp ;
	
	/* SET GET */
	
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public LinkedListPractice getLp() {
		return lp;
	}

	public void setLp(LinkedListPractice lp) {
		this.lp = lp;
	}

	/* SET GET */
	
	public int menu(){
		int select=0;
		
		System.out.println("=====SELECT MENU=====");
		System.out.println("1. �� ���� �߰�");
		System.out.println("2. �� ���� ����");
		System.out.println("3. �� ���� ����");
		System.out.println("4. �� ����Ʈ ���");
		System.out.println("5. ����");
		System.out.println("====================");
		while(true){
			System.out.print("INPUT : ");
			select=sc.nextInt();
			
			if(select>0 && select<6){
				return select;
			}
			else{
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void add(LinkedList list){
		System.out.print("���̸� : "); 
		list.add(sc.next());
		System.out.print("���� ���� : ");
		list.add(sc.next());
		System.out.print("���� �帣 : ");
		list.add(sc.next());
		System.out.print("�뿩 ��¥ : ");
		list.add(sc.next());
	}
	
	public void remove(LinkedList list){
		System.out.print("������ �� �̸� : ");
		String name = sc.next();
		int index=0;
		for(int i=0;i<list.size();i++){
			if(name.equals(list.get(i))){
				System.out.println(name);
				for(int j=0;j<4;j++){
					list.remove(i);
				}
			}
		}
	}
	
	public void modify(LinkedList list){
		System.out.print("������ ���ϴ� ���� : ");
		String buffer = sc.next();
		System.out.print("������ ���� : ");
		String mod = sc.next();
		
		for(int i=0;i<list.size();i++){
			if(buffer.equals(list.get(i))){
				list.set(i, mod);
				break;
			}
		}
	}
	
	public void display(LinkedList list){
		int count=1;
		System.out.println("\n\n====������Ʈ====\n\n");
		for(int i=0;i<list.size();i+=4){
			System.out.println(count + "��° ��");
			System.out.println("���̸� : " + list.get(i));
			System.out.println("�������� : " + list.get(i+1));
			System.out.println("�����帣 : " + list.get(i+2));
			System.out.println("�뿩��¥ : " + list.get(i+3));
			System.out.println("----------------------------------------------");
			count++;
		}
		System.out.println("\n\n");
	}
}
