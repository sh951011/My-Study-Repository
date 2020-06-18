package ex01.api;

public class StringBufferEX01 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();	// �ʱ� �뷮 16
		int start,end;
		start=sb.hashCode();
		System.out.println("length               ��                  capacity");
		System.out.println("------------------------------------------------------------");
		int len=sb.length();
		int size=sb.capacity();
		System.out.println("     " + len + "                    ��                       " + size);
		
		System.out.println("------------------------------------------------------------");
		
		sb.append("kosta");
		len=sb.length();
		size=sb.capacity();
		System.out.println("     " + len + "                    ��                       " + size);
		
		System.out.println("------------------------------------------------------------");
		
		sb.append("happyvirus");
		len=sb.length();
		size=sb.capacity();
		System.out.println("     " + len + "                  ��                       " + size);
		
		System.out.println("------------------------------------------------------------");
		
		sb.append("1234567890");
		len=sb.length();
		size=sb.capacity();
		System.out.println("     " + len + "                  ��                       " + size);
		
		System.out.println("\n ===========================\n");
		
		end=sb.hashCode();
		System.out.println("ù �ּ� :  " +start + "\n");
		System.out.println("�� �ּ� :  " + end + "\n");
		
		
		System.out.println(" =========================== \n");
		
		System.out.println("����� �°� �ϱ� trimToSize\n");
		
		sb.trimToSize();
		len=sb.length();
		size=sb.capacity();
		System.out.println("length               ��                  capacity");
		System.out.println("------------------------------------------------------------");
		System.out.println("     " + len + "                  ��                       " + size);
	}
}
