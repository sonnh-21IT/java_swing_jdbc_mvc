package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewAdmin;

public class EventViewAdmin implements ActionListener {
	private ViewAdmin vam;

	public EventViewAdmin(ViewAdmin vam) {
		this.vam = vam;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equalsIgnoreCase("Lưu")) {
			vam.addData();
		} else if (src.equalsIgnoreCase("Mới")) {
			vam.newView();
		} else {
			vam.closeView();
		}
	}

}
