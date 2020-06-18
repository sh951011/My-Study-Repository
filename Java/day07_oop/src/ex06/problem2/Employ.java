package ex06.problem2;
import java.util.*;

public abstract class Employ {
	int num=0;
	Scanner sc = new Scanner(System.in);
	String[] name;
	int[] department;
	int[] position;
	String[] phone_number;

	
	public void input() {
		System.out.print("## �Է��Ͻ� ����� ����ΰ��� ??? : ");
		num=sc.nextInt();
		
		name = new String[num];
		department = new int[num];
		position = new int[num];
		phone_number = new String[num];
	}
	
	public Employ(){
		input();
		
		for(int i=0;i<num;i++){
			System.out.print("## ��� �̸��� �Է����ּ��� : ");
			name[i]=sc.next();
			
			/* �μ� �Է� */
			do{
				System.out.println("## �μ��� �������ּ���");
				System.out.println("## 1. SOFTWARE");
				System.out.println("## 2. HARDWARE");
				System.out.println("## 3. MARKETING");
				department[i]=sc.nextInt();
			}while(department[i]<0 || department[i]>3);
			
			/* ���� �Է� */
			do{
				System.out.println("## ������ �������ּ���");
				System.out.println("## 1. ����");
				System.out.println("## 2. ����");
				System.out.println("## 3. �븮");
				position[i]=sc.nextInt();
			}while(position[i]<1 || position[i]>3);
			
			/* �� ��ȣ �Է� */
			System.out.print("�Է��Ͻ� ����� �ڵ��� ��ȣ�� �Է����ּ��� : ");
			phone_number[i]=sc.next();
		}
	}

	
	
	/* SET GET START */
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getDepartment() {
		return department;
	}

	public void setDepartment(int[] department) {
		this.department = department;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public String[] getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String[] phone_number) {
		this.phone_number = phone_number;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	/* SET GET END */
}

/* ���� */
class Allowance extends Employ{
	int[] _allowance = new int[num];
	String[] _department = new String[num];
	String[] _position = new String[num];
	
	public Allowance(){
		for(int i=0;i<num;i++){
			if(department[i]==1){	// SOFTWARE
				_department[i]="SOFTWARE";
				if(position[i]==1){	// ����
					_allowance[i]=5000000;
					_position[i]="����";
				}
				else if(position[i]==2){	// ����
					_allowance[i]=3500000;
					_position[i]="����";
				}
				else if(position[i]==3){	// �븮
					_allowance[i]=2500000;
					_position[i]="�븮";
				}
			}
			else if(department[i]==2){	// HARDWARE
				_department[i]="HARDWARE";
				if(position[i]==1){	// ����
					_allowance[i]=4000000;
					_position[i]="����";
				}
				else if(position[i]==2){	// ����
					_allowance[i]=3000000;
					_position[i]="����";
				}
				else if(position[i]==3){	// �븮
					_allowance[i]=2000000;
					_position[i]="�븮";
				}
			}
			else if(department[i]==3){	// MARKETTING
				_department[i]="MARKETTING";
				if(position[i]==1){	// ����
					_allowance[i]=3500000;
					_position[i]="����";
				}
				else if(position[i]==2){	// ����
					_allowance[i]=2500000;
					_position[i]="����";
				}
				else if(position[i]==3){	// �븮
					_allowance[i]=1800000;
					_position[i]="�븮";
				}
			}
		}
	}
	
	/* SET GET START */


	public int[] get_allowance() {
		return _allowance;
	}

	public void set_allowance(int[] _allowance) {
		this._allowance = _allowance;
	}
	
	/* SET GET END */
}

/* Ŀ�̼� */
class Commission extends Allowance{
	double[] _commission = new double[num];
	double[] result = new double[num];
	 
	public void show(){
		for(int i=0;i<num;i++){
			/* HARDWARE �������� MARKETTING �������� 10%�� Ŀ�̼��� ���´� */
			if(department[i]==2 || department[i]==3){
				_commission[i]=_allowance[i]/(10.0);
			}
			
			result[i]=_allowance[i]+_commission[i];
		}
		
		System.out.println("=========================");
		for(int i=0;i<num;i++){
				System.out.printf("%s %s���� �̹� �� ������ %.2f�Դϴ�.\n",name[i],_position[i],result[i]);
				System.out.printf("%s %s���� %s�μ��̼ż� Ŀ�̼��� %.2f�Դϴ�\n",name[i],_position[i],_department[i],_commission[i]);
				System.out.printf("%s %s���� ����ó : %s\n",name[i],_position[i],phone_number[i]);
				System.out.println("=========================");
		}
	}

	/* SET GET START */
	
	public double[] get_commission() {
		return _commission;
	}

	public void set_commission(double[] _commission) {
		this._commission = _commission;
	}

	public double[] getResult() {
		return result;
	}

	public void setResult(double[] result) {
		this.result = result;
	}
	
	/* SET GET END */
}