package ex01.api;

public class StringBufferEX02 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		
		/* �ڿ� �߰� */
		sb.append(" is  pencil");
		System.out.println(sb);
		
		/* �߰��� ���ϴ� ���� �߰� */
		sb.insert(8, "my");
		System.out.println(sb);
		
		/* ���ϴ� ��ġ�� ��ü */
		sb.replace(8, 10, "your");
		System.out.println(sb);
		
		/* ���� */
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		/* �ݴ�� �ٲٱ� */
		sb.reverse();
		System.out.println(sb);
		
		/* ~���̱��� ¥����*/
		sb.setLength(5);
		System.out.println(sb);
	}
}
