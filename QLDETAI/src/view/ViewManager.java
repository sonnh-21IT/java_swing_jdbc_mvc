package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.EventViewManager;
import model.*;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewManager extends JPanel {
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;
	private String[] columnHeader = { "SỐ THỨ TỰ", "MÃ ĐỀ TÀI", "TÊN ĐỀ TÀI", "TÁC GIẢ", "LĨNH VỰC", "CẤP QUẢN LÝ",
			"NĂM CÔNG BỐ", "LIÊN HỆ"};
	private TableRowSorter<TableModel> rowsorter = null;
	private List<Topic> list;
//	private static JTextField txtSearch;
//	private static JTable table;
//	private static List<Topic> list;
//	private static DefaultTableModel model;
//	private static String[] columnHeader = { "MÃ ĐỀ TÀI", "TÊN ĐỀ TÀI", "TÁC GIẢ", "LĨNH VỰC", "CẤP QUẢN LÝ",
//			"NĂM CÔNG BỐ" };
//	private static TableRowSorter<TableModel> rowsorter = null;

	/**
	 * Create the panel.
	 */
	public ViewManager() {
		setBackground(Color.WHITE);
		EventViewManager ev = new EventViewManager(this);
		setLayout(null);
		setBorder(new LineBorder(new Color(67, 97, 238)));
		txtSearch = new JTextField();
		txtSearch.setText("search");
		txtSearch.setBorder(getBorder());
		txtSearch.setBounds(10, 11, 155, 20);
		add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnPrint = new JButton("In Tệp");
		btnPrint.addActionListener(ev);
		btnPrint.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_print_black_18dp.png"));
		btnPrint.setBackground(new Color(190, 227, 219));
		btnPrint.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPrint.setBounds(175, 4, 138, 35);
		add(btnPrint);

		JButton btnAdd = new JButton("Thêm Mới");
		btnAdd.addActionListener(ev);
		btnAdd.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_post_add_black_24dp.png"));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdd.setBackground(new Color(190, 227, 219));
		btnAdd.setBounds(385, 4, 138, 35);
		add(btnAdd);
		JTabbedPane pnData = new JTabbedPane(JTabbedPane.TOP);
		pnData.setBounds(10, 42, 713, 508);
		add(pnData);

		table = new JTable();
		initData();
		setRowsorter();
		initTable();
		table.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (table.getSelectedRowCount() == 1) {
						int row = table.getSelectedRow();
						String maDT = table.getValueAt(row, 1) + "";
						ViewInfo vif = new ViewInfo();
						vif.OpenViewInfo(maDT);

					} else if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(pnData, "Đối Tượng Không Tồn Tại Trong Danh Sách");
					} else if (table.getSelectedRowCount() != 1) {
						JOptionPane.showMessageDialog(pnData, "Hãy chọn 1 Và Chỉ 1 Đối Tượng");
					}
				} catch (Exception E) {
//					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 195, 0));
		pnData.addTab("Danh Sách Đề Tài", null, scrollPane, null);
		scrollPane.setViewportView(table);

		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(ev);
		btnRefresh.setIcon(new ImageIcon(
				"C:\\Users\\hongs\\Documents\\Code_Java\\QLDETAI\\icon_image\\outline_autorenew_black_18dp.png"));
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRefresh.setBackground(new Color(190, 227, 219));
		btnRefresh.setBounds(585, 4, 138, 35);
		add(btnRefresh);
	}

	public void initData() {
		list = new TopicDAO().getData();
	}

	public void initTable() {
		model = new DefaultTableModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(columnHeader);
		int stt = 1;
		for (Topic item : list) {
			model.addRow(new Object[] { stt++, item.getMa_DT(), item.getTen_DT(), item.getTen_TG(), item.getLinhVuc(),
					item.getCap_QL(), item.getNamCB(), item.getLienhe()});
		}
		model.fireTableDataChanged();
		table.setModel(model);
		setRowsorter();
	}

	public void printDocument() {
		try {
			XSSFWorkbook Workbook = new XSSFWorkbook();
			XSSFSheet sheet = Workbook.createSheet("Đề Tài");

			XSSFRow row = null;
			Cell cell = null;

			row = sheet.createRow(3);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Mã Đề Tài");

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Tên Đề Tài");

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Tác Giả");

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("Lĩnh Vực");

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("Cấp Quản Lý");

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Năm công bố");

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Liên Hệ");

			this.initData();
			List<Topic> listItem = list;

			if (listItem != null) {
				int s = listItem.size();
				for (int i = 0; i < s; i++) {
					Topic topic = listItem.get(i);

					row = sheet.createRow(4 + i);

					cell = row.createCell(0, CellType.NUMERIC);
					cell.setCellValue(i + 1);

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(topic.getMa_DT());

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(topic.getTen_DT());

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(topic.getTen_TG());

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(topic.getLinhVuc());

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(topic.getCap_QL());

					cell = row.createCell(6, CellType.NUMERIC);
					cell.setCellValue(topic.getNamCB());

					cell = row.createCell(7, CellType.NUMERIC);
					cell.setCellValue(topic.getLienhe());

				}
				JFileChooser jf = new JFileChooser();

				int chose = jf.showSaveDialog(this);
				if (chose == JFileChooser.APPROVE_OPTION) {
					File file = jf.getSelectedFile();
					FileOutputStream fileStream = new FileOutputStream(file + ".xlsx");
					Workbook.write(fileStream);
					fileStream.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
	}

	public void setRowsorter() {
		rowsorter = new TableRowSorter<>(table.getModel());
		
		table.setRowSorter(rowsorter);
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = txtSearch.getText();
				if (text.trim().length() == 0) {
					rowsorter.setRowFilter(null);
				} else {
					rowsorter.setRowFilter(RowFilter.regexFilter(text));
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

		table.getTableHeader().setFont(new Font("Arrial", Font.PLAIN, 12));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(25);
	}

	public void refresh() {
		initData();
		txtSearch.setText("search");
		setRowsorter();
		initTable();
	}

	public void addData() {
		new ViewAdmin().setVisible(true);
	}
}
