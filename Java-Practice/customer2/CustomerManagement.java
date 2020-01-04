package customer2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/* Customer Management */
public class CustomerManagement implements PublicConstants {
	private HashMap<String, PersonalInfo> customers;
	Scanner sc;

	CustomerManagement(HashMap<String, PersonalInfo> customers) {
		this.customers = customers;
		sc = new Scanner(System.in);
	}

	/* 0. �� ��� ��� */
	public void printCustomers() {
		if (this.customers.size() == 0)
			System.out.println(NO_EXIST_CUSTOMER_MSG);
		else {
			Iterator it = this.customers.keySet().iterator();
			while (it.hasNext()) {
				PersonalInfo customerInfo = customers.get(it.next());
				System.out.println(customerInfo.getName() + "\t" + customerInfo.getGender() + "\t"
						+ customerInfo.getPhoneNum() + "\t" + customerInfo.getPoint());
			}
		}
	}

	/* �ش� Ű�� �̹� �ִ��� Ȯ���ϴ� �޼��� */
	public boolean keyAlreadyExist(String key) {
		for(String cno: this.customers.keySet()) {
			if(cno.equalsIgnoreCase(key)) return true;
		}
		return false;
	}

	public void registerNewCustomer() {
		PersonalInfo newbieInfo = new PersonalInfo();
		String customerNo;
		boolean again = false;
		do {
			if(again) System.out.println(ALREADY_EXIST_PASSWD_MSG);
			System.out.print(">> �� ��ȣ : ");
			customerNo = sc.next();
			again=true;
		}while(keyAlreadyExist(customerNo));
		again=false;
		
		do {
			if(again) System.out.println(">> ��й�ȣ�� ���� �ٸ��ϴ�. �ٽ� �Է����ּ���.");
			System.out.print(">> ��й�ȣ : ");
			newbieInfo.setPassword(sc.next());
			System.out.print(">> ��й�ȣ ��Ȯ�� : ");
			again=true;
		}while(!newbieInfo.getPassword().equals(sc.next()));
		
		System.out.print(">> �ڵ��� ��ȣ : ");
		newbieInfo.setPhoneNum(sc.next());
		System.out.print(">> �� �̸� : ");
		newbieInfo.setName(sc.next());
		System.out.print(">> �� ���� : ");
		newbieInfo.setGender(sc.next());
		System.out.print(">> �� ����Ʈ : ");
		try {
			newbieInfo.setPoint(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(INT_MISMATCH_EXCEPT_MSG);
			newbieInfo.setPoint(sc.nextInt());
		}
		customers.put(customerNo, newbieInfo);
	}
	
	/* 2. �� ���� ���� */

	public void modifyCustomerInfo() {
		Iterator it = customers.keySet().iterator();
		
	}

	/* 3. �� ����Ʈ ��ȸ */

	public void lookupCustomerPoint() {

	}

	/* 4. �� ���� */

	public void deleteCustomer() {

	}

}
