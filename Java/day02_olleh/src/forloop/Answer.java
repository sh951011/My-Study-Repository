package forloop;
import java.util.*;

public class Answer {
	public static void main(String[] args) {
		// 3�� �Է¹޾Ƽ� ��� 60�� �̻��̿��� �ϰ�, 
		// �� ���� ������ 40�����ϸ� ���� ���հ�
		int kor=0,eng=0,com=0;
		boolean pass1,pass2;
		boolean kor_pass,eng_pass,com_pass;
		double avg=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("KOR : ");
		kor=sc.nextInt();
		System.out.print("ENG : ");
		eng=sc.nextInt();
		System.out.print("COM : ");
		com=sc.nextInt();
		
		avg=(kor+eng+com)/3.0;
		
		if(avg>=60){
			pass1=true;
		}
		else{
			pass1=false;
		}
		
		if(kor>=40){
			pass2=true;
			kor_pass=true;
		}
		else{
			pass2=false;
			kor_pass=false;
		}
		if(eng>=40){
			pass2=true;
			eng_pass=true;
		}
		else{
			pass2=false;
			eng_pass=false;
		}
		if(com>=40){
			pass2=true;
			com_pass=true;
		}
		else{
			pass2=false;
			com_pass=false;
		}
		
		if(pass1 && pass2){
			System.out.println("�հ�");
		}
		else{
			if(avg>=60){
				if(kor_pass==false){
					System.out.print("���� ���� ");
				}
				if(eng_pass==false){
					System.out.print("���� ���� ");
				}
				if(com_pass==false){
					System.out.print("���� ���� ");
				}
				System.out.println("���� ���� ���հ�");
			}
			else{
				System.out.println("��� �̴޷� ���� ���հ�");
				if(kor_pass==false){
					System.out.print("���� ���� ");
				}
				if(eng_pass==false){
					System.out.print("���� ���� ");
				}
				if(com_pass==false){
					System.out.print("���� ���� ");
				}
			}
		}
	}
}
