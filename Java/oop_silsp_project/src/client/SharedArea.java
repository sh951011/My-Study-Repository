package client;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 *  19�⵵ 1�б� ��ü�������α׷��ֽǽ� ���� ������Ʈ
 *  Title : ���� ä�����α׷� 
 *  Class : ���� ä�����α׷� Ŭ���̾�Ʈ ���� �޸� Ŭ���� (UDP)
 *  2014707073 ������Ű��а� ���ȯ
 */

public class SharedArea {
	private boolean quit=false;
	private JTextField textField;
	private JTextArea textArea;
	
	
	/* Set & Get Method */
	
	public boolean isQuit() {
		return quit;
	}
	public void setQuit(boolean quit) {
		this.quit = quit;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	/* Set & Get Method */
	
}
