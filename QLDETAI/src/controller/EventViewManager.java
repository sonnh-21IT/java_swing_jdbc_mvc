package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ViewManager;

public class EventViewManager implements ActionListener {
	private ViewManager vmn;

	public EventViewManager(ViewManager vmn) {
		this.vmn = vmn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equalsIgnoreCase("In Tệp")) {
			int output = JOptionPane.showConfirmDialog(vmn, "Bạn Có Muốn Xuất Danh Sách Này Không?", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			
			if (output == JOptionPane.YES_OPTION) {
				vmn.printDocument();
				JOptionPane.showMessageDialog(vmn,"Thành Công","Thông Báo",JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (src.equalsIgnoreCase("Thêm Mới")) {
			vmn.addData();
		} else {
			vmn.refresh();
		}
	}
}
