package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.EventViewInfo;
import model.Topic;
import model.TopicDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewInfo extends JFrame {
	private StringBuilder error;
	private JPanel contentPane;
	private JTextField txtMDT;
	private JTextField txtTDT;
	private JTextField txtTG;
	private JTextField txtLV;
	private JTextField txtNCB;
	private JComboBox cbbQL;
	private JTextField txtLH;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewInfo frame = new ViewInfo();
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
	public ViewInfo() {
		EventViewInfo ev = new EventViewInfo(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnItem = new JPanel();
		pnItem.setLayout(null);
		pnItem.setBorder(new LineBorder(Color.ORANGE));
		pnItem.setBounds(10, 54, 664, 278);
		contentPane.add(pnItem);

		JLabel lblMa = new JLabel("M\u00E3 \u0110\u1EC1 T\u00E0i");
		lblMa.setForeground(new Color(128, 237, 153));
		lblMa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMa.setBounds(10, 23, 86, 25);
		pnItem.add(lblMa);

		JLabel lblTen = new JLabel("T\u00EAn \u0110\u1EC1 T\u00E0i");
		lblTen.setForeground(new Color(128, 237, 153));
		lblTen.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTen.setBounds(10, 80, 86, 25);
		pnItem.add(lblTen);

		JLabel lblTG = new JLabel("T\u00E1c Gi\u1EA3");
		lblTG.setForeground(new Color(128, 237, 153));
		lblTG.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTG.setBounds(10, 142, 86, 25);
		pnItem.add(lblTG);

		JLabel lblLV = new JLabel("L\u0129nh V\u1EF1c");
		lblLV.setForeground(new Color(128, 237, 153));
		lblLV.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLV.setBounds(10, 205, 86, 25);
		pnItem.add(lblLV);

		JLabel lblNCB = new JLabel("N\u0103m C\u00F4ng B\u1ED1");
		lblNCB.setForeground(new Color(128, 237, 153));
		lblNCB.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNCB.setBounds(385, 142, 98, 25);
		pnItem.add(lblNCB);

		JLabel lblQL = new JLabel("Qu\u1EA3n L\u00FD");
		lblQL.setForeground(new Color(128, 237, 153));
		lblQL.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQL.setBounds(385, 205, 98, 25);
		pnItem.add(lblQL);

		cbbQL = new JComboBox();
		cbbQL.setModel(new DefaultComboBoxModel(new String[] { "Lựa Chọn", "Nhà Nước", "Tỉnh", "Huyện" }));
		cbbQL.setForeground(Color.ORANGE);
		cbbQL.setBounds(511, 205, 98, 25);
		pnItem.add(cbbQL);

		txtMDT = new JTextField();
		txtMDT.setForeground(Color.ORANGE);
		txtMDT.setColumns(10);
		txtMDT.setBounds(96, 23, 170, 25);
		pnItem.add(txtMDT);

		txtTDT = new JTextField();
		txtTDT.setForeground(Color.ORANGE);
		txtTDT.setColumns(10);
		txtTDT.setBounds(96, 80, 285, 25);
		pnItem.add(txtTDT);

		txtTG = new JTextField();
		txtTG.setForeground(Color.ORANGE);
		txtTG.setColumns(10);
		txtTG.setBounds(96, 142, 225, 25);
		pnItem.add(txtTG);

		txtLV = new JTextField();
		txtLV.setForeground(Color.ORANGE);
		txtLV.setColumns(10);
		txtLV.setBounds(96, 205, 279, 25);
		pnItem.add(txtLV);

		txtNCB = new JTextField();
		txtNCB.setForeground(Color.ORANGE);
		txtNCB.setColumns(10);
		txtNCB.setBounds(493, 144, 131, 25);
		pnItem.add(txtNCB);

		txtLH = new JTextField();
		txtLH.setForeground(Color.ORANGE);
		txtLH.setColumns(10);
		txtLH.setBounds(493, 23, 161, 25);
		pnItem.add(txtLH);

		JLabel lblLinH = new JLabel("Liên Hệ");
		lblLinH.setForeground(new Color(128, 237, 153));
		lblLinH.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLinH.setBounds(385, 23, 98, 25);
		pnItem.add(lblLinH);

		JPanel pnBtn = new JPanel();
		pnBtn.setLayout(null);
		pnBtn.setBorder(new LineBorder(Color.ORANGE, 1, true));
		pnBtn.setBounds(10, 347, 664, 53);
		contentPane.add(pnBtn);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(ev);
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_cancel_presentation_black_18dp.png"));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDelete.setBackground(Color.ORANGE);
		btnDelete.setBounds(10, 11, 130, 31);
		pnBtn.add(btnDelete);

		JButton btnUpdate = new JButton("Sửa");

		btnUpdate.addActionListener(ev);
		btnUpdate.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_edit_note_black_18dp.png"));
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 12));
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setBounds(267, 11, 130, 31);
		pnBtn.add(btnUpdate);

		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(ev);
		btnExit.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_undo_black_18dp.png"));
		btnExit.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExit.setBackground(Color.ORANGE);
		btnExit.setBounds(524, 11, 130, 31);
		pnBtn.add(btnExit);

		JLabel lblChiTit = new JLabel("Chi Ti\u1EBFt");
		lblChiTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTit.setForeground(new Color(128, 237, 153));
		lblChiTit.setFont(new Font("Arial", Font.PLAIN, 16));
		lblChiTit.setBounds(10, 11, 664, 32);
		contentPane.add(lblChiTit);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBounds(161, 44, 341, 2);
		contentPane.add(separator);
	}

	public void OpenViewInfo(String Madt) {
		try {
			TopicDAO topicDAO = new TopicDAO();
			Topic topic = topicDAO.Search(Madt);
			if (topic != null) {
				txtMDT.setText(topic.getMa_DT());
				txtTDT.setText(topic.getTen_DT());
				txtTG.setText(topic.getTen_TG());
				txtLV.setText(topic.getLinhVuc());
				txtLH.setText(topic.getLienhe());
				txtNCB.setText(String.valueOf(topic.getNamCB()));
				
				if (topic.getCap_QL().equals("Nhà Nước")) {
					cbbQL.setSelectedIndex(1);
				}
				if (topic.getCap_QL().equals("Tỉnh")) {
					cbbQL.setSelectedIndex(2);
				}
				if (topic.getCap_QL().equals("Huyện")) {
					cbbQL.setSelectedIndex(3);
				}
//				TopPicView.refresh();
				setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Sai Thông Tin Hoặc Đối Tượng Không Tồn Tại Trong Danh Sách");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void checkData() {
		error = new StringBuilder();
		String regMDT = "^[21]{2}[IT]{2}[0-9]{3}$";
		String regNCB = "^[0-9]{4}$";
		String regLHbyemail = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
		String regLHbyphone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

		if (txtMDT.getText().equals("") || txtTDT.getText().equals("") || txtTG.equals("")
				|| txtNCB.getText().equals("") || txtLV.getText().equals("") || txtLH.getText().equals("")) {
			error.append("Hãy Nhập Đầy Đủ Thông Tin\n");
		} else if (cbbQL.getSelectedIndex() == 0) {
			error.append("Chọn Cấp Quản Lý Cho Đối Tượng");
		} else {
//			if (!txtMDT.getText().matches(regMDT)) {
//				error.append("Hãy Nhập Mã Đề Tài Đúng Định Dạng 21ITxxx (x là các số từ 0 đến 9)\n");
//			}
//			else if (!txtLH.getText().matches(regLHbyemail) && !txtLH.getText().matches(regLHbyphone)) {
//				error.append(
//						"Hãy Nhập Mail Hoặc Số Điện Thoại Đúng Định Dạng\n(Ví Dụ : admin.21it@vku.udn.vn/0xxxxxxxxx )\n");
//			} 
//			else 
			if (!txtNCB.getText().matches(regNCB)) {
				error.append("Hãy Nhập Đúng Định Dạng yyyy (y là các số từ 0 đến 9)\n");
			}
		}
	}

	public void upDateInfo() {
		try {
			String madt = txtMDT.getText();
			checkData();
			if (!error.isEmpty()) {
				JOptionPane.showMessageDialog(this, error.toString());
				return;
			} else {
				Topic topic = new Topic();
				topic.setMa_DT(txtMDT.getText().trim());
				topic.setTen_DT(txtTDT.getText());
				topic.setTen_TG(txtTG.getText());
				topic.setLinhVuc(txtLV.getText());
				topic.setLienhe(txtLH.getText());
				topic.setCap_QL((String) cbbQL.getSelectedItem());
				topic.setNamCB(Integer.parseInt(txtNCB.getText()));

				TopicDAO dao = new TopicDAO();
				dao.Update(topic);
				dispose();
//				ViewManager.refresh();
				JOptionPane.showMessageDialog(this, "Hoàn Tất !");
			}
		} catch (Exception e) {

		}
	}

	public void deleteTopic() {
		try {
			String madt = txtMDT.getText();
			String regMDT = "^[21]{2}[IT]{2}[0-9]{3}$";
			StringBuilder error2 = new StringBuilder();
			if (madt.length() > 0) {
				if (!madt.trim().matches(regMDT)) {
					error2.append("Nhập Đúng Định Dạng 21ITxxx (x là các số từ 0 đến 9)\n");
				}
			}
			if (txtMDT.getText().equals("")) {
				error2.append("'Mã Đề Tài' Không Được Để Trống");
			}
			if (!error2.isEmpty()) {
				JOptionPane.showMessageDialog(this, error2.toString());
				return;
			} else {
				int output = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Muốn Xoá Đối Tượng Này Không?",
						"Thông Báo", JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					TopicDAO dao = new TopicDAO();
					dao.Delete(txtMDT.getText());
					dispose();
//					ViewManager.refresh();
					JOptionPane.showMessageDialog(this, "Đã Xoá !");
				}
			}
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "");
		}
	}

	public void closeViewinfo() {
		dispose();
	}
}
