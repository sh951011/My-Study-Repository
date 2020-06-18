package package1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeptUI extends JFrame {
	protected JTextField textField1;
	protected JTextField textField2;
	protected JTextField textField3;
	protected JTextField textField4;
	protected JTextArea textArea;
	protected JButton mybtn;
	private JPanel jp = new JPanel();
	DeptInsert dt = new DeptInsert();
	String sql;

	public DeptUI() {
		setTitle("Text Area Test");
		setSize(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mybtn = new JButton("�߰�");
		textField1 = new JTextField(20);
		textField2 = new JTextField(20);
		textField3 = new JTextField(20);
		textField4 = new JTextField(20);

		textField1.setText("(����ȣ)");
		textField2.setText("(���̸�)");
		textField3.setText("(�ֹι�ȣ)");
		textField4.setText("(���ϸ���)");

		textField1.addMouseListener(new MyListener());
		textField2.addMouseListener(new MyListener());
		textField3.addMouseListener(new MyListener());
		textField4.addMouseListener(new MyListener());

		mybtn.addActionListener(new MyListener());
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		jp.add(textField4);
		add(jp, BorderLayout.NORTH);
		add(mybtn, BorderLayout.AFTER_LAST_LINE);

		add(scrollPane, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	/* ������ */
	class MyListener implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = textField1.getText() + "\t" + textField2.getText() + "\t" + textField3.getText();

			/* ���⼭ �ؽ�Ʈ���� ��Ʈ������ �Ѱܺ��Կ� */
			System.out.println(dt.insert_Logic(textField1.getText(), textField2.getText(), textField3.getText(),
					textField4.getText()) + "���� ���� �߰��Ǿ����ϴ�.");

			/* ���⼭ �ؽ�Ʈ���� ��Ʈ������ �Ѱܺ��Կ� */

			textArea.append(text + "\n");
			textField1.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == textField1) {
				textField1.setText("");
			}
			else if (e.getSource() == textField2) {
				textField2.setText("");
			}
			else if (e.getSource() == textField3) {
				textField3.setText("");
			}
			else if (e.getSource() == textField4) {
				textField4.setText("");
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
/*			if (e.getSource() == textField1) {
				textField1.setText("");
			}
			else if (e.getSource() == textField2) {
				textField2.setText("");
			}
			else if (e.getSource() == textField3) {
				textField3.setText("");
			}
			else if (e.getSource() == textField4) {
				textField4.setText("");
			}*/
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}