package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.EventChagneView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMain extends JFrame {

	private JPanel contentPane;
	private JPanel pnView;
	public static JLabel lblAdmin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewMain frame = new ViewMain();
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
	public ViewMain() {
		
		EventChagneView ev=new EventChagneView(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(Color.WHITE);
		pnMenu.setBounds(0, 0, 250, 561);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(new Color(67, 97, 238));
		pnTitle.setBounds(0, 0, 250, 80);
		pnMenu.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Topic Manager");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_manage_accounts_white_24dp.png"));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 250, 80);
		pnTitle.add(lblNewLabel);
		
		JButton btnHome = new JButton("Màn Hình Chính");
		btnHome.addActionListener(ev);
		btnHome.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_home_black_18dp.png"));
		btnHome.setFont(new Font("Arial", Font.PLAIN, 15));
		btnHome.setBorder(new LineBorder(new Color(176, 224, 230), 1, true));
		btnHome.setBackground(new Color(255, 195, 0));
		btnHome.setBounds(10, 107, 230, 60);
		pnMenu.add(btnHome);
		
		JButton btnQuanly = new JButton("Quản Lý Đề Tài");
		btnQuanly.addActionListener(ev);
		btnQuanly.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_topic_black_18dp.png"));
		btnQuanly.setFont(new Font("Arial", Font.PLAIN, 15));
		btnQuanly.setBorder(new LineBorder(new Color(176, 224, 230), 1, true));
		btnQuanly.setBackground(new Color(255, 195, 0));
		btnQuanly.setBounds(10, 196, 230, 60);
		pnMenu.add(btnQuanly);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(ev);
		btnDong.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_logout_black_18dp.png"));
		btnDong.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDong.setBorder(new LineBorder(new Color(176, 224, 230), 1, true));
		btnDong.setBackground(new Color(255, 195, 0));
		btnDong.setBounds(10, 379, 230, 60);
		pnMenu.add(btnDong);
		
		JButton btnTQ = new JButton("Tổng Quát");
		btnTQ.addActionListener(ev);
		btnTQ.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_analytics_black_18dp.png"));
		btnTQ.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTQ.setBorder(new LineBorder(new Color(176, 224, 230), 1, true));
		btnTQ.setBackground(new Color(255, 195, 0));
		btnTQ.setBounds(10, 286, 230, 60);
		pnMenu.add(btnTQ);
		
		lblAdmin = new JLabel("");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\admin.png"));
		lblAdmin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAdmin.setBounds(10, 516, 230, 34);
		pnMenu.add(lblAdmin);
		
		pnView = new JPanel();
		pnView.setBorder(new LineBorder(new Color(67, 97, 238)));
		ViewHome vh=new ViewHome();
		pnView.setBounds(251, 0, 733, 561);
		setView(vh);
		contentPane.add(pnView);
		pnView.setLayout(null);
	}
	public void viewHome() {
		ViewHome vh=new ViewHome();
		setView(vh);
	}
	public void viewManeger() {
		ViewManager vmn=new ViewManager();
		setView(vmn);
	}
	public void viewGenerality() {
		ViewGenerality vmn=new ViewGenerality();
		setView(vmn);
	}
	public void viewLogin() {
		ViewAccess vac=new ViewAccess();
		dispose();
		vac.setVisible(true);
	}
	public void setView(JPanel newview) {
		newview.setBounds(0, 0,733,561);
		pnView.removeAll();
		pnView.add(newview);
		pnView.validate();
		pnView.repaint();
	}
}
