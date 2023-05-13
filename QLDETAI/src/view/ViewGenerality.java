package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Statistical;
import model.TopicDAO;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ViewGenerality extends JPanel {
	private JTextField txtSearch;
	private JTable table;
	private TableRowSorter<TableModel> rowsorter = null;

	/**
	 * Create the panel.
	 */
	public ViewGenerality() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(new LineBorder(new Color(67, 97, 238)));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 196, 255));
		panel.setBounds(10, 11, 200, 150);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblicon1 = new JLabel("");
		lblicon1.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_ballot_white_24dp.png"));
		lblicon1.setBounds(0, 0, 100, 150);
		panel.add(lblicon1);
		
		JLabel lblq1 = new JLabel(new TopicDAO().CountCQLNN()+"");
		lblq1.setForeground(Color.WHITE);
		lblq1.setHorizontalAlignment(SwingConstants.CENTER);
		lblq1.setFont(new Font("Arial", Font.BOLD, 13));
		lblq1.setBounds(100, 0, 100, 75);
		panel.add(lblq1);
		
		JLabel lblNN = new JLabel("Nh\u00E0 N\u01B0\u1EDBc");
		lblNN.setForeground(Color.WHITE);
		lblNN.setHorizontalAlignment(SwingConstants.CENTER);
		lblNN.setFont(new Font("Arial", Font.BOLD, 13));
		lblNN.setBounds(100, 75, 100, 75);
		panel.add(lblNN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 198, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(523, 11, 200, 150);
		add(panel_2);
		
		JLabel lblicon3 = new JLabel("");
		lblicon3.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_ballot_white_24dp.png"));
		lblicon3.setBounds(0, 0, 100, 150);
		panel_2.add(lblicon3);
		
		JLabel lblq33 = new JLabel(new TopicDAO().CountCQLHuyen()+"");
		lblq33.setForeground(Color.WHITE);
		lblq33.setHorizontalAlignment(SwingConstants.CENTER);
		lblq33.setFont(new Font("Arial", Font.BOLD, 13));
		lblq33.setBounds(100, 0, 100, 75);
		panel_2.add(lblq33);
		
		JLabel lblH = new JLabel("Huy\u1EC7n");
		lblH.setForeground(Color.WHITE);
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setFont(new Font("Arial", Font.BOLD, 13));
		lblH.setBounds(100, 75, 100, 75);
		panel_2.add(lblH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(189, 178, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(271, 11, 200, 150);
		add(panel_1);
		
		JLabel lblicon2 = new JLabel("");
		lblicon2.setIcon(new ImageIcon("C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_ballot_white_24dp.png"));
		lblicon2.setBounds(0, 0, 100, 150);
		panel_1.add(lblicon2);
		
		JLabel lblq2 = new JLabel(new TopicDAO().CountCQLTinh()+"");
		lblq2.setForeground(Color.WHITE);
		lblq2.setHorizontalAlignment(SwingConstants.CENTER);
		lblq2.setFont(new Font("Arial", Font.BOLD, 13));
		lblq2.setBounds(100, 0, 100, 75);
		panel_1.add(lblq2);
		
		JLabel lblT = new JLabel("T\u1EC9nh");
		lblT.setForeground(Color.WHITE);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Arial", Font.BOLD, 13));
		lblT.setBounds(100, 75, 100, 75);
		panel_1.add(lblT);
		
		txtSearch = new JTextField();
		txtSearch.setBorder(new LineBorder(new Color(67, 97, 238)));
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSearch.setBounds(523, 172, 200, 25);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 713, 342);
		add(scrollPane);
		
		table = new JTable();
		List<Statistical> list = new ArrayList<>();
		list = new TopicDAO().StatisticalDAO();
		int stt=1;
		DefaultTableModel model = new DefaultTableModel();
		String[] header = { "SỐ THỨ TỰ","NĂM CÔNG BỐ", "SỐ ĐỀ TÀI", "CẤP QUẢN LÝ" };
		model.setColumnIdentifiers(header);
		for (Statistical item : list) {
			model.addRow(new Object[] { stt++,item.getNamCB(), item.getSoDT(), item.getCapQL() });
		}
		table.setModel(model);
		table.getTableHeader().setFont(new Font("Arrial", Font.PLAIN, 12));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(25);
		rowsorter = new TableRowSorter<>(table.getModel());
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = txtSearch.getText();
				if (text.trim().length() == 0) {
					rowsorter.setRowFilter(null);
				} else {
					rowsorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = txtSearch.getText();
				if (text.trim().length() == 0) {
					rowsorter.setRowFilter(null);
				} else {
					rowsorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		table.setRowSorter(rowsorter);
		scrollPane.setViewportView(table);

	}
}
