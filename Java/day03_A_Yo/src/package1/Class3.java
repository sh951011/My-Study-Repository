package package1;
import java.util.*;

public class Class3 {
	// ����1] ����ó�� ���α׷��� ���� �ֱ� (do_while �̿�)
	// �Է¹޴� ������ do_while �̿��Ͽ� 0~100������ ������ �Է�
	public static void main(String[] args) {
		int kor=0,eng=0,com=0;
		int total=0;
		double average=0;
		char kor_grade='0',eng_grade='0',com_grade='0';
		int kor_score=0,eng_score=0,com_score=0;
		int count=0;
		boolean recur;
		
		Scanner sc = new Scanner(System.in);
		
		do{
			if(count==0)	recur=false;
			else	recur=true;
			
			if(recur){
				System.out.println("----------------------");
				System.out.println("FAIL!! �ٽ� �Է����ּ��� (0~100 ������ ���� �Է����ּ���)");
				System.out.println("----------------------");
			}
			
			System.out.print("���� ������ �Է��ϼ��� : ");
			kor=sc.nextInt();
			System.out.print("���� ������ �Է��ϼ��� : ");
			eng=sc.nextInt();
			System.out.print("���� ������ �Է��ϼ��� : ");
			com=sc.nextInt();
			
			count++;
		}while(kor<0 || kor>100 || eng<0 || eng>100 || com<0 || com>100);
		
		if(kor>89 && kor<101){
			kor_grade='A';
			kor_score=4;
		}
		else if(kor>59 && kor<90){
			kor_grade='B';
			kor_score=3;
		}
		else if(kor>49 && kor<60){
			kor_grade='C';
			kor_score=2;
		}
		else{
			kor_grade='F';
			kor_score=0;
		}
		
		if(eng>89 && eng<101){
			eng_grade='A';
			eng_score=4;
		}
		else if(eng>59 && eng<90){
			eng_grade='B';
			eng_score=3;
		}
		else if(eng>49 && eng<60){
			eng_grade='C';
			eng_score=2;
		}
		else{
			eng_grade='F';
			eng_score=0;
		}
		
		if(com>89 && com<101){
			com_grade='A';
			com_score=4;
		}
		else if(com>59 && com<90){
			com_grade='B';
			com_score=3;
		}
		else if(com>49 && com<60){
			com_grade='C';
			com_score=2;
		}
		else{
			com_grade='F';
			com_score=0;
		}
		
		total=com_score+kor_score+eng_score;
		average=total/3.0;
		
		System.out.println("===================================");
		System.out.println("������ ������ " + kor_grade + "�Դϴ�");
		System.out.println("������ ������ " + eng_grade + "�Դϴ�");
		System.out.println("������ ������ " + com_grade + "�Դϴ�");
		System.out.println("===================================");
		System.out.printf("��� ������  %.2f�Դϴ�",average);
	}
}