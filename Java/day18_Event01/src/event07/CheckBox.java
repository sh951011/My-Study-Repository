package event07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBox extends JFrame {
	private JButton buttonOK;
	private JCheckBox onion, cheese, tomato;

	public CheckBox() {
		setTitle("üũ�ڽ� �׽�Ʈ");
		setSize(300, 130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("�ܹ��ſ� ������ �߰��ҷ�?");
		JPanel tooPanel = new JPanel();
		tooPanel.add(label);
		add(tooPanel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		onion = new JCheckBox("����");
		onion.addMouseListener(new MyListener());
		panel.add(onion);

		cheese = new JCheckBox("ġ��");
		cheese.addMouseListener(new MyListener());
		panel.add(cheese);

		tomato = new JCheckBox("�丶��");
		tomato.addMouseListener(new MyListener());
		panel.add(tomato);
		add(panel, BorderLayout.CENTER);

		buttonOK = new JButton("OK");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(buttonOK);
		add(bottomPanel, BorderLayout.SOUTH);
		buttonOK.addActionListener(new MyListener());

		setVisible(true);
	}

	class MyListener implements ActionListener, MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == onion) {
				cheese.setSelected(false);
				tomato.setSelected(false);
			}
			if (e.getSource() == cheese) {
				onion.setSelected(false);
				tomato.setSelected(false);
			}
			if (e.getSource() == tomato) {
				cheese.setSelected(false);
				onion.setSelected(false);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

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

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonOK) {
				String msg = "";
				if (onion.isSelected()) {
					msg += "����\n";
				}
				if (cheese.isSelected()) {
					msg += "ġ��\n";
				}
				if (tomato.isSelected()) {
					msg += "�丶��\n";
				}
				msg = "������ �ɼ��� ������ �����ϴ�.\n" + msg;
				System.out.println(msg);
				onion.setSelected(false);
				cheese.setSelected(false);
				tomato.setSelected(false);
			}
		}
	}

	public static void main(String[] args) {
		new CheckBox();
	}
}