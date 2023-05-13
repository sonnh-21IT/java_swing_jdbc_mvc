package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.*;

import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class ViewHome extends JPanel {
	private TableRowSorter<TableModel> rowsorter = null;

	/**
	 * Create the panel.
	 */
	public ViewHome() {
		setBorder(new LineBorder(new Color(67, 97, 238)));
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 103, 0));
		panel_3.setBounds(10, 11, 713, 150);
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_ballot_white_24dp.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(0, 0, 100, 150);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_1_2 = new JLabel(new TopicDAO().CountDT() + "");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(100, 0, 100, 75);
		panel_3.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("\u0110\u1EC1 T\u00E0i");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(100, 75, 100, 75);
		panel_3.add(lblNewLabel_1_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(181, 23, 158));
		panel_3_1.setBounds(10, 178, 713, 150);
		add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_recent_actors_white_24dp.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(513, 0, 100, 150);
		panel_3_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1_2_1 = new JLabel(new TopicDAO().CountTG() + "");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(613, 0, 100, 75);
		panel_3_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("T\u00E1c Gi\u1EA3");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(613, 75, 100, 75);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		List<Statistical> list = new TopicDAO().StatisticalDAO();
		DefaultTableModel model = new DefaultTableModel();
		int count=1;
		String[] header = { "SỐ THỨ TỰ","NĂM CÔNG BỐ", "SỐ ĐỀ TÀI", "CẤP QUẢN LÝ" };
		model.setColumnIdentifiers(header);
		for (Statistical item : list) {
			model.addRow(new Object[] {count++, item.getNamCB(), item.getSoDT(), item.getCapQL() });
		}

	}
}
