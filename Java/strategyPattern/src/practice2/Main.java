package practice2;
import java.util.Scanner;

abstract class Calc{   //�߻�Ŭ����
   int a, b;

   public void setValue(int a, int b){
      this.a=a;
      this.b=b;
   }
   
   public abstract int calculate(int a, int b);
}

/* ���� */
class Add extends Calc{
   public int calculate(int a, int b) {
      return a+b;
   }
}

class Sub extends Calc{
   public int calculate(int a, int b) {
      return a-b;
   }
}

class Mul extends Calc{
   public int calculate(int a, int b) {
      return a*b;
   }
}

class Div extends Calc{
   public int calculate(int a, int b) {
      if(b!=0) {   return a/b;   }   
      else {   return -1;   }
   }
}
/* ���� */


public class Main {
   public static void main(String[] args) {
      int a, b;   //�ǿ�����
      int Result;   //��갪 ��ȯ���� ����
      char operator;   //������
      String Operator;   
      Scanner sc = new Scanner(System.in);
      
      System.out.print("�� ������ �����ڸ� �Է��Ͻÿ�>>");
      a = sc.nextInt();
      b = sc.nextInt();
      Operator = sc.next();   //����� �� �ٿ� ���� 3�� �Է�
      
      operator=Operator.charAt(0);
      
      Result=judge(a, b, operator);
      result(b, Result);
      sc.close();
   }
   
   public static int judge(int a, int b, char operator) {   //�����ڸ� �Ǵ��Ͽ� � ����� ���� ����
      int result = 0;
      Calc cal = null;

      if (operator == '+') {
        cal= new Add();
      }
      else if (operator == '-') {
         cal=new Sub();
      }
      else if (operator == '*') {
         cal=new Mul();
      }
      else if (operator == '/') {
         cal=new Div();
      }
      
      cal.setValue(a, b);
     result= cal.calculate(a, b);
      
      return result;
   }
   
   public static void result(int b, int Result) {   //������ ���� 0�� �ż� ������ �߻��� ���� �ƴ� ��츦 �����ؼ� ����� ���
      if(b==0)
         System.out.print("0���� ���� �� �����ϴ�.");
      else
         System.out.print(Result);
   }
}
