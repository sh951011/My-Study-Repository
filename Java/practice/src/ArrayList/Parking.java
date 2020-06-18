package ArrayList;
import java.util.*;

public class Parking {
	protected int customer_number;
	protected int chargePerHour;
	Scanner sc = new Scanner(System.in);
	
	protected Parking(){
		customer_number=1;
		chargePerHour=5000;
	}
	
	/* �����ð� �Է� */
	protected void IN(LinkedList INLIST){
		int number=0;
		INLIST.add(customer_number);
		do{
			System.out.print(customer_number + "�� ������ ���� �ð��� �Է����ּ��� (example : 12�� 30�� -> 12(�������� �Է�)) : ");
			number=sc.nextInt();
		}while(number<0 || number>24);
		INLIST.add(number);
		customer_number++;
	}
	/* �����ð� �Է� */

	
	/* �����ð� �Է� */
	protected int OUT(LinkedList OUTLIST){
		int number=0;
		boolean False=false;
		do{
			if(False){
				System.out.println("�ش� ����ȣ�� �������� �ʽ��ϴ�!");
				False=false;
			}
			System.out.print("�� �� ������ ���� �ð��� �Է��Ͻðڽ��ϱ�?? : ");
			number=sc.nextInt();
			False=true;
		}while(number>customer_number || customer_number<0);
		OUTLIST.add(number);
		System.out.print(number + "������ ���� �ð��� �Է����ּ��� (example : 12�� 30�� -> 13(�ø����� �Է�)) : ");
		OUTLIST.add(sc.nextInt());
		
		return number;
	}	
	/* �����ð� �Է� */
	
	/* ��ݰ�� */
	protected void calculate_charge(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		int charge=0;
		int number=0;
		int in_time=0;
		
		number=OUT(OUTLIST);
		for(int i=0;i<OUTLIST.size();i+=2){
			if(number==(int)INLIST.get(i)){
				number=(int)INLIST.get(i);
				in_time=(int)INLIST.get(i+1);
			}
		}
		
		for(int i=0;i<OUTLIST.size();i+=2){
				if(number==(int)OUTLIST.get(i)){
					CALCULATELIST.add(INLIST.get(i));	// ����ȣ���� �߰�
					charge=((int)OUTLIST.get(i+1) - in_time)*chargePerHour;	// (�����ð� - �����ð�) x �ð��� ���
					CALCULATELIST.add(charge);		// ����߰�
					System.out.println(number+"�� ������ ����� " + charge + "�� �Դϴ�.");
					return;
				}
		}
	}
	/* ��ݰ�� */
	
	
	/* ������Ʈ ���� */
	protected void remove_list(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		int number=0;
		
		System.out.print("��� ���Ե� �����Ͻðڽ��ϱ�?? : ");
		number=sc.nextInt();
		
		/* INLIST ���� */
		for(int i=0;i<INLIST.size();i+=2){
			if((int)INLIST.get(i)==number){
				for(int j=0;j<2;j++){
					INLIST.remove(i);
				}
				break;
			}
		}
		
		/* OUTLIST ���� */
		for(int i=0;i<OUTLIST.size();i+=2){
			if((int)OUTLIST.get(i)==number){
				for(int j=0;j<2;j++){
					OUTLIST.remove(i);
				 }
				 break;
			}
		}
		
		/* CALCULATELIST ���� */
		for(int i=0;i<CALCULATELIST.size();i+=2){
			if((int)CALCULATELIST.get(i)==number){
				for(int j=0;j<2;j++){
					CALCULATELIST.remove(i);
				}
			}
		}
	}
	
	/* ������Ʈ ���� */
	
	/*  ������Ʈ ��� */
	protected void display(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		boolean out=false;		// ����Ϸ��� ���� �������� true �ƴϸ� false
		int out_customer_number=0;
		int cal_customer_number=0;
		System.out.println("====================================");
		System.out.println("Welcome to Soo-Hwan`s Parking Management Program");
		System.out.println("====================================\n\n");
		
		System.out.println("���� �� " +( customer_number-1 ) +"���� ���Ե鲲�� �������� �ý����� �̿����ּ̽��ϴ�.");
		
		for(int i=0;i<INLIST.size();i+=2){
			/* out���� �ƴ��� �Ǻ� */
			for(int j=0;j<OUTLIST.size();j+=2){
				/* INLIST�� �ش��ϴ� ����ȣ�� ������ OUTLIST���� ã�´� */
				if(INLIST.get(i)==OUTLIST.get(j)){
					out=true;
					out_customer_number=j;
					/* INLIST�� �ش��ϴ� ����ȣ�� ������ CALCULATELIST���� ã�´�*/
					for(int k=0;k<CALCULATELIST.size();k+=2){
						if(INLIST.get(i)==CALCULATELIST.get(k)){
							cal_customer_number=k;
						}
					}
					break;
				}
				else{
					out=false;
				}
			}
			
			/* ��� */
			System.out.println("\n");
			System.out.println("==================================");
			if(out){
				System.out.println(INLIST.get(i)+"�� ������ ����");
				System.out.println("���� �ð� : " + INLIST.get(i+1));
				System.out.println("���� �ð� : " + OUTLIST.get(out_customer_number+1));
				System.out.println("�ΰ��� ��� : " + CALCULATELIST.get(cal_customer_number+1));
			}
			else{
				System.out.println(INLIST.get(i)+"�� ������ ����");
				System.out.println("���� �ð� : " + INLIST.get(i+1));
				System.out.println("�����ð� : ���� �������� �����̽��ϴ�.");
				System.out.println("�ΰ��� ��� : ���� �������� �����̽��ϴ�.");
			}
			System.out.println("==================================");
			/* ��� */
		}
	}
	

	/* SET GET */
	
	
	protected int getCustomer_number() {
		return customer_number;
	}

	protected void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	protected int getChargePerHour() {
		return chargePerHour;
	}

	protected void setChargePerHour(int chargePerHour) {
		this.chargePerHour = chargePerHour;
	}
	
	/* SET GET */

}
