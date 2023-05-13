package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.EventSignup;
import model.Account;
import model.AccountDAO;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class ViewSignup extends JPanel {
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtPassCF;
	private JTextField txtAdminname;

	/**
	 * Create the panel.
	 */
	public ViewSignup() {

		EventSignup ev = new EventSignup(this);

		setBackground(new Color(33, 158, 188));
		setLayout(null);

		txtUser = new JTextField();
		txtUser.setText("UserName");
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUser.setBorder(null);
		txtUser.setBackground(new Color(33, 158, 188));
		txtUser.setBounds(124, 116, 200, 25);
		add(txtUser);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\84984\\Documents\\CODE_Java\\QLDETAI\\icon_image\\outline_account_circle_white_24dp.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 103, 65, 52);
		add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(124, 141, 200, 2);
		add(separator);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\84984\\Documents\\CODE_Java\\QLDETAI\\icon_image\\outline_password_white_24dp.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 152, 65, 52);
		add(lblNewLabel_1);

		txtPass = new JPasswordField();
		txtPass.setText("PassWord");
		txtPass.setForeground(Color.WHITE);
		txtPass.setBorder(null);
		txtPass.setBackground(new Color(33, 158, 188));
		txtPass.setBounds(124, 165, 200, 25);
		txtPass.setEchoChar('✮');
		add(txtPass);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(124, 190, 200, 2);
		add(separator_1);

		JCheckBox chkAH = new JCheckBox("Ẩn Mật Khẩu");
		chkAH.setSelected(true);
		chkAH.setForeground(Color.WHITE);
		chkAH.setFont(new Font("Arial", Font.PLAIN, 12));
		chkAH.setBackground(new Color(33, 158, 188));
		chkAH.setBounds(124, 265, 97, 23);
		add(chkAH);

		JButton btnDN = new JButton("Đăng Nhập");
		btnDN.addActionListener(ev);
		btnDN.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDN.setBackground(new Color(241, 250, 238));
		btnDN.setBounds(49, 350, 275, 31);
		add(btnDN);

		JButton btnDK = new JButton("Đăng Ký");
		btnDK.addActionListener(ev);
		btnDK.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDK.setBackground(new Color(241, 250, 238));
		btnDK.setBounds(49, 295, 275, 31);
		add(btnDK);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(49, 337, 275, 2);
		add(separator_2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(
				"C:\\Users\\84984\\Documents\\CODE_Java\\QLDETAI\\icon_image\\outline_password_white_24dp.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(49, 206, 65, 52);
		add(lblNewLabel_1_1);

		txtPassCF = new JPasswordField();
		txtPassCF.setText("PassWord");
		txtPassCF.setEchoChar('✮');
		txtPassCF.setForeground(Color.WHITE);
		txtPassCF.setBorder(null);
		txtPassCF.setBackground(new Color(33, 158, 188));
		txtPassCF.setBounds(124, 219, 200, 25);
		add(txtPassCF);

		chkAH.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtPass.setEchoChar('✮');
					txtPassCF.setEchoChar('✮');
				} else {
					txtPass.setEchoChar((char) 0);
					txtPassCF.setEchoChar((char) 0);
				}
			}
		});

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(124, 244, 200, 2);
		add(separator_1_1);

		txtAdminname = new JTextField();
		txtAdminname.setText("AdminName");
		txtAdminname.setForeground(Color.WHITE);
		txtAdminname.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAdminname.setBorder(null);
		txtAdminname.setBackground(new Color(33, 158, 188));
		txtAdminname.setBounds(124, 66, 200, 25);
		add(txtAdminname);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\84984\\Documents\\CODE_Java\\QLDETAI\\icon_image\\outline_admin_panel_settings_white_24dp.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(49, 53, 65, 52);
		add(lblNewLabel_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(124, 91, 200, 2);
		add(separator_3);
	}

	public void login() {
		ViewAccess.FromView(ViewAccess.pnLogin);
	}

	public void signup() {
		String pass = new String(txtPass.getPassword());
		String passcf = new String(txtPassCF.getPassword());
		String user = txtUser.getText();
		String name = txtAdminname.getText();
		try {
			StringBuilder sb = new StringBuilder();

			if (pass.equals("") || passcf.equals("") || user.equals("") || name.equals("")) {
				sb.append("Vui Lòng Nhập Đầy Đủ Thông Tin");
			} else if (pass.length() < 8||pass.length()>20) {
				sb.append("Mật KHẩu Có Ít Nhất 8 kí tự Và Không Quá 20 kí tự");
			} else if (user.length() < 8||user.length()>20) {
				sb.append("Tài Khoản Có Ít Nhất 8 kí tự Và Không Quá 20 kí tự");
			} else if (!pass.equals(passcf)) {
				txtPassCF.setText("");
				sb.append("Nhập Lại Mật Khẩu Không Đúng");
				txtPass.setText("");
			}
			if (sb.isEmpty()) {
				Account acc = new Account();
				acc.setUser(user);
				acc.setPass(pass);
				acc.setName(name);
				AccountDAO dao = new AccountDAO();
				dao.addAccount(acc);
				sb.append("Đăng Ký Thành Công");
			}
			JOptionPane.showMessageDialog(this, sb.toString());
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Tài Khoản Đã Được Sử Dụng");
		}
	}
}
