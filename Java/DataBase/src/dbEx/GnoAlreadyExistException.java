package dbEx;

public class GnoAlreadyExistException extends RuntimeException{
	public GnoAlreadyExistException(){
		super("�̹� �����ϴ� ����ȣ �Դϴ�.");
	}

	public void ment(){
		System.out.println("\n\n�̹� �����ϴ� ����ȣ����");
		System.out.println("�ٽ� �Է��ϼ��� O   ��a O \n\n");
	}
}