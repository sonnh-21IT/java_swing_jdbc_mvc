package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewInfo;

public class EventViewInfo implements ActionListener {
	private ViewInfo vif;

	public EventViewInfo(ViewInfo vif) {
		this.vif = vif;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equalsIgnoreCase("Sửa")) {
			vif.upDateInfo();
		}else if (src.equalsIgnoreCase("Xoá")) {
			vif.deleteTopic();
		}else {
			vif.closeViewinfo();
		}

	}
}
