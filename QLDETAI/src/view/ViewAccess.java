package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EventAccess;
import model.Account;
import model.AccountDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class ViewAccess extends JFrame {

	private JPanel contentPane;
	private static JPanel pnRoot;
	private JTextField txtUser;
	private JPasswordField txtPass;
	public static JPanel pnLogin;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewAccess frame = new ViewAccess();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ViewAccess() {
		EventAccess ev = new EventAccess(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 95, 115));
		panel.setBounds(0, 0, 375, 411);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_public_white_48dp.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 84, 355, 131);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Topic Manager");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 235, 355, 58);
		panel.add(lblNewLabel_1);

		pnRoot = new JPanel();
		pnRoot.setBounds(374, 0, 375, 411);
		pnRoot.setLayout(null);

		pnLogin = new JPanel();
		pnLogin.setBounds(0, 0, 375, 411);
		pnLogin.setBackground(new Color(33, 158, 188));

		pnLogin.setLayout(null);

		txtUser = new JTextField();
		txtUser.setText("UserName");
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Arial", Font.PLAIN, 13));
		txtUser.setBorder(null);
		txtUser.setBackground(new Color(33, 158, 188));
		txtUser.setBounds(132, 93, 200, 25);
		pnLogin.add(txtUser);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_account_circle_white_24dp.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 80, 65, 52);
		pnLogin.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(132, 118, 200, 2);
		pnLogin.add(separator);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_password_white_24dp.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(57, 129, 65, 52);
		pnLogin.add(lblNewLabel_1_1);

		txtPass = new JPasswordField();
		txtPass.setText("PassWord");
		txtPass.setForeground(Color.WHITE);
		txtPass.setBorder(null);
		txtPass.setEchoChar('✮');
		txtPass.setBackground(new Color(33, 158, 188));
		txtPass.setBounds(132, 142, 200, 25);
		pnLogin.add(txtPass);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(132, 167, 200, 2);
		pnLogin.add(separator_1);

		JCheckBox chkAH = new JCheckBox("Ẩn Mật Khẩu");
		
		chkAH.setForeground(Color.WHITE);
		chkAH.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtPass.setEchoChar('✮');
				} else {
					txtPass.setEchoChar((char) 0);
				}
			}
		});
		chkAH.setFont(new Font("Arial", Font.PLAIN, 12));
		chkAH.setBackground(new Color(33, 158, 188));
		chkAH.setBounds(132, 200, 97, 23);
		pnLogin.add(chkAH);

		JButton btnDN = new JButton("Đăng Nhập");
		btnDN.addActionListener(ev);
		btnDN.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_exit_to_app_black_18dp.png"));
		btnDN.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDN.setBackground(new Color(241, 250, 238));
		btnDN.setBounds(57, 243, 123, 31);
		pnLogin.add(btnDN);

		JButton btnDK = new JButton("Đăng Ký");
		btnDK.addActionListener(ev);
		btnDK.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_person_add_black_18dp.png"));
		btnDK.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDK.setBackground(new Color(241, 250, 238));
		btnDK.setBounds(209, 243, 123, 31);
		pnLogin.add(btnDK);

		JButton btnT = new JButton("Thoát");
		btnT.addActionListener(ev);
		btnT.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_disabled_by_default_black_18dp.png"));
		btnT.setFont(new Font("Arial", Font.PLAIN, 12));
		btnT.setBackground(new Color(241, 250, 238));
		btnT.setBounds(57, 285, 275, 31);
		pnLogin.add(btnT);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(57, 278, 275, 2);
		pnLogin.add(separator_2);
		pnRoot.add(pnLogin);
		contentPane.add(pnRoot);
	}

	public void signUp() {
		ViewSignup suv = new ViewSignup();
		FromView(suv);
	}

	public void exit() {
		System.exit(0);
	}

	public static void FromView(JPanel pnnew) {
		pnRoot.removeAll();
		pnRoot.add(pnnew);
		pnnew.setBounds(0, 0, 375, 411);
		pnRoot.validate();
		pnRoot.repaint();
	}

	public void checklogin() {
		String username = txtUser.getText();
		String password = new String(txtPass.getPassword());
		Account acc = new Account(username, password);
		StringBuilder sb = new StringBuilder();

		if (username.equals("")) {
			sb.append("Tài Khoản Không Được Để Trống\n");
		} else if (password.equals("")) {
			sb.append("Mật Khẩu Không Được Để Trống\n");
		}
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(this, sb.toString(), "Thất Bại", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			try {
				AccountDAO accCheck = new AccountDAO();
				Account accreal = accCheck.checkData(acc);
				if (accreal != null) {
					dispose();
					ViewMain vm = new ViewMain();
					vm.lblAdmin.setText(accreal.getName());
					vm.setVisible(true);
					JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công");
				} else {
					JOptionPane.showMessageDialog(this, "Sai Tài Khoản hoặc Mật Khẩu", "Thất bại",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}
