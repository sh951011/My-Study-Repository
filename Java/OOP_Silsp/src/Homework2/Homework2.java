package Homework2;

/*
 * KwangWoon University
 * ������Ű��а� 2014707073 ���ȯ
 * ��ü�������α׷��� �ǽ� Homework2
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/* �����ϴ� ������� ��Ƴ��� �������̽� */
interface Constant{
	public static final int QUIZ_NUM=5;	/* ������ ���� */
	public static final int COUNTRY_NUM=14;	/* encoding�� ����<->���� ���� */
}

/* MainClass */
public class Homework2 {
	public static void main(String[] args) {
		Mapping map = new Mapping();
		HashMap<String, String> pair = map.mapping();
		Game game=new Game(pair);
	}
}

/* ���� ������ �����ϴ� Ŭ���� */
class Game implements Constant{
	HashMap<String, String> pair;	/* <����,����>�� Mapping�� ��ü */
	Scanner sc;	/* �Է¹޴µ� ���� Scanner */
	
	/* Game ������ �Լ� */
	Game(HashMap<String, String> pair){
		this.pair=pair;	
		sc = new Scanner(System.in);
		Set<String> set	=pair.keySet();	/* pair�� Key�κ��� Set�� ��ȯ */
		Iterator it=set.iterator();		/* set�� �˻����� Iterator ���� */
		
		for(int i=0;i<QUIZ_NUM;i++) {
			String country=it.next().toString();	/* it�� �˻��� ����� country�� ���� */
			System.out.print(country + "�� ������ ? : ");	/* ���� ��� */
			String userInput = sc.nextLine();	/* �������� �Է¹ޱ� */
			
			/* ���Ḧ �Է¹����� ���� */
			if(isQuit(userInput)) {
				System.out.println("���� ����..");
				return;
			}
			
			/* ������ ���� �� */
			if(isCorrect(pair.get(country),userInput)) System.out.println("�����Դϴ�!");
			/* ������ �ƴ� �� */
			else {
				System.out.println("�ƴմϴ�!");
				System.out.println("������ " + pair.get(country) +"�Դϴ�!"); /* ����Ȯ���ϱ� ���� */
			}
		}
		
		System.out.println("������ �����մϴ�.");
	}
	
	/* ���Ḧ �Է��ߴ��� Ȯ���ϴ� �Լ� */
	private boolean isQuit(String userInput) {
		return userInput.equals("����");
	}
	
	/* ������ �Է��� ���� ���� ��� ��ġ�ϴ��� Ȯ���ϴ� �Լ� */
	private boolean isCorrect(String rightAnswer,String userInput) {
		return rightAnswer.equals(userInput);
	}
}


/* ������ 5���� <����, ����>�� HashMap�� �߰��ϴ� Ŭ���� */
class Mapping implements Constant{
	
	/* �ܺ� Ŭ�������� ȣ���ؼ� mapping�� �ϴ� �Լ� */
	/* �� �Լ��� ȣ���ϸ� �˾Ƽ� ���ֵ��� ���� */
	public HashMap<String, String> mapping() {
		HashMap<Integer, String> encoding=null;		/* <����,����> encoding */
		HashMap<String, String> capital=null;		/* <����,����> encoding */
		HashMap<String,String> result = new HashMap<String,String>();	/* ������ 5���� <����,����>�� �����ϴ� Map */
		int [] randNums;	/* ������ 5���� ���� �ٸ� ���ڸ� �����ϴ� �迭 */
		
		encoding=encodingCountry();
		capital=encodingCapital();
		randNums=putRandNums();
		
		for(int i=0;i<QUIZ_NUM;i++) {
			String country=encoding.get(randNums[i]);
			result.put(country, capital.get(country));
		}
		
		return result;
	}

	/* randNums �迭�� ���� �ٸ� ������ 5���� ���ڸ� �����ϴ� �Լ� */
	/* ������ 0~COUNTRY_NUM-1�� ���� */
	private int[] putRandNums() {
		Random rand = new Random();
		int [] randNums=new int[QUIZ_NUM];
		
		for(int i=0;i<QUIZ_NUM;i++) {
			int buf=rand.nextInt(COUNTRY_NUM-1);
			if(isExist(randNums,buf)) {
				i--; 
				continue;
			}else {
				randNums[i]=buf;
			}
		}
		return randNums;
	}
	
	/* �ش� ���ڰ� �̹� �迭�� �����ϴ��� üũ�ϴ� �Լ� */
	private boolean isExist(int[] arr,int num) {
		for(int i=0;i<arr.length;i++) {
			if(num==arr[i]) return true;
		}
		return false;
	}
	
	/* <����,����>�� �̸� capital�̶�� ������ �����س��� �Լ� */
	private HashMap<String,String> encodingCapital(){
		HashMap<String, String> capital = new HashMap<String, String>();
		capital.put("������", "�ĸ�");		capital.put("������", "���帮��");		capital.put("�׸���", "���׳�");
		capital.put("����", "����");		capital.put("�ѱ�", "����");		capital.put("�״�����", "�Ͻ��׸���");		capital.put("����", "������");
		capital.put("�߽���", "�߽��ڽ�Ƽ");		capital.put("�̱�", "������");		capital.put("��Ʈ��", "�ϳ���");
		capital.put("�����", "���������");		capital.put("������", "����Ȧ��");		capital.put("����Ʈ", "ī�̷�");		capital.put("��Ż����", "�θ�");

		return capital;
	}
	
	/* <����,����>�� �̸� encoding�̶�� ������ �����س��� �Լ� */
	private HashMap<Integer,String> encodingCountry(){
		HashMap<Integer, String> encoding = new HashMap<Integer, String>();
		encoding.put(0, "������");		encoding.put(1, "������");		encoding.put(2, "�׸���");
		encoding.put(3, "����");		encoding.put(4, "�ѱ�");		encoding.put(5, "�״�����");
		encoding.put(6, "����");		encoding.put(7, "����Ʈ");		encoding.put(8, "�߽���");		encoding.put(9, "�̱�");
		encoding.put(10, "��Ʈ��");		encoding.put(11, "�����");		encoding.put(12, "������");		encoding.put(13, "��Ż����");
		return encoding;
	}
}
