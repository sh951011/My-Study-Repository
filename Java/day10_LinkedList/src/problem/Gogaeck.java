package problem;
import java.util.*;

public class Gogaeck {
	private int password;
	Scanner sc = new Scanner(System.in);

	public Gogaeck(){
		password=0;
	}
	
	public void input(HashMap map,LinkedList list){
		int i=0,j=0;
		String con = new String();
		String name;
		int password;
		for(i=0;i<=j;i++){
			System.out.println("������ ������ �Է����ּ���\n\n");
			System.out.print("NAME : ");
			name=sc.next();
			list.add(name);
			System.out.print("TEL : ");
			list.add(sc.next());
			System.out.print("ADDRESS : ");
			list.add(sc.next());
			System.out.print("PASSWORD : ");
			password=sc.nextInt();
			list.add(password);
			
			//int a=parseInt(list.get(0).toString());
			
			map.put(name,password);
			
			while(true){
				System.out.print("��� �Ͻðڽ��ϱ�?? (Y/N) : ");
				con=sc.next();
				
				if(con.charAt(0)=='Y'){
					j++;
					break;
				}else if(con.charAt(0)=='N'){
					break;
				}else if(con.charAt(0)=='y'){
					j++;
					break;
				}else if(con.charAt(0)=='n'){
					break;
				}
				else{
					System.out.println("�߸� �Է��ϼ̽��ϴ�!!");
				}
			}
		}
	}
	
	public void login(HashMap map,LinkedList list,Gogaeck gg){
		String NAME;
		int PASSWORD;
		
		while(true){
			System.out.println("��ȸ�Ͻ� �̸��� �ش� ��й�ȣ�� �Է����ּ���.\n");
			System.out.print("NAME : ");
			NAME=sc.next();
			System.out.print("PASSWORD : ");
			PASSWORD=sc.nextInt();
			System.out.println("");
			
			if(map.containsKey(NAME)){	// NAME�� �ش��ϴ� ���� map�� ������ �ִٸ�
						if(map.get(NAME).equals(PASSWORD)){	// NAME�ش��ϴ� ���� ������ �ִ� map�� Ű���� PASSWORD�� ���ٸ�
							System.out.println("----------------------------------------");
							System.out.println("\n\n ##" + NAME + "���� �ݰ����ϴ�!!");
							for(int i=0;i<list.size();i++){
								if(NAME.equals(list.get(i))){
									gg.output(list,i);
								}
							}
							break;
						}
						else{
							System.out.println("\n## ��й�ȣ�� Ʋ�Ƚ��ϴ�!!");
							break;
						}
			}
			else{
					System.out.println("\n\n ## �ش� �̸��� �ش��ϴ� ������ ����� �ʽ��ϴ� ��.��");
					
			}
			break;
		}
	}
	
	public void output(LinkedList list,int num){
		System.out.println("NAME  : " + list.get(num));
		System.out.println("TEL  : " + list.get(num+1));
		System.out.println("ADDRESS  : " + list.get(num+2));
	}
}
