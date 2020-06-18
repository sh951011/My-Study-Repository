package java_finalExam;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		MyStack<String> ms = new MyStack<String>();
		
		s.add("��");
		s.add("��");
		s.add("ȯ");
		s.add("��");
		s.add("��");
		s.add("��");
		s.add("��");
		s.add("��");
		s.add("��");
		s.add("��");
		s.add("��");
		
		s =ms.reverseStack(s);
		
		System.out.println(s);
	}
}

class MyStack<T>{
	public  <T> Stack reverseStack(Stack<T> s) {
		Stack<T> newS = new Stack<T>();

		while (true) {
			T tmp = s.pop();
			
			if(s==null){
				break;
			}else{
				newS.push(tmp);
			}
		}
		
		return newS;
	}
}
