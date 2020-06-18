package chatPackage2;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Class : ȸ������ Ŭ����
 */

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {
	private JPanel contentPane; 	/* ���� */
	private JTextField tf_JoinId; 		/* ���̵� */
	private JTextField tf_JoinName; 		/* �̸� */
	private JPasswordField pf_JoinPw; 		/* �н����� */
	private UserDao dao;
	
	public Join(UserDao dao) {
		this.dao=dao;
		setTitle("ȸ������");
		setBounds(630, 250, 300, 205); 	/* Join â ������ ���� */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);



		JLabel lblID = new JLabel(" I D :");
		lblID.setBounds(39, 28, 27, 15);
		panel.add(lblID);



		tf_JoinId = new JTextField();
		tf_JoinId.setBounds(96, 25, 116, 21);
		panel.add(tf_JoinId);
		tf_JoinId.setColumns(10);



		JLabel lblNewLabel = new JLabel("PW :");
		lblNewLabel.setBounds(39, 59, 26, 15);
		panel.add(lblNewLabel);



		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setBounds(39, 90, 45, 15);
		panel.add(lblNewLabel_1);



		tf_JoinName = new JTextField();
		tf_JoinName.setBounds(96, 87, 116, 21);
		panel.add(tf_JoinName);

		tf_JoinName.setColumns(10);
		JButton btnJoinOk = new JButton("�Ϸ�");

		btnJoinOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!dao.idAlreadyExist(tf_JoinId.getText())) {
						dao.insert(tf_JoinId.getText(), 
								new String(pf_JoinPw.getPassword()),tf_JoinName.getText());
						JOptionPane.showMessageDialog(null, "ȸ������ ����!!");
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵� �Դϴ�!!");
						tf_JoinId.setText("");
						tf_JoinName.setText("");
						pf_JoinPw.setText("");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJoinOk.setBounds(42, 118, 97, 23);
		panel.add(btnJoinOk);
		JButton btnJoinBack = new JButton("���");
		btnJoinBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnJoinBack.setBounds(148, 118, 97, 23);
		panel.add(btnJoinBack);

		pf_JoinPw = new JPasswordField();
		pf_JoinPw.setBounds(96, 56, 116, 21);
		panel.add(pf_JoinPw);
	}
}
