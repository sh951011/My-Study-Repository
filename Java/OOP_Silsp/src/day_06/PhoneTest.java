package day_06;

public class PhoneTest {
	public static void main(String[] args) {
		Telephone tp = new Telephone("���ȯ","�� �̵�");
		SmartPhone s= new SmartPhone("���ȯ2","������");
		
		tp.autoAnswering();
		s.playGame();
	}
}