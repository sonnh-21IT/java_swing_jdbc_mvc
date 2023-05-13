package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewAccess;

public class EventAccess implements ActionListener {
	private ViewAccess vac;

	public EventAccess(ViewAccess vac) {
		this.vac = vac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src=e.getActionCommand();
		if(src.equalsIgnoreCase("Đăng Nhập")) {
			vac.checklogin();
		}else if(src.equalsIgnoreCase("Đăng Ký")){
			vac.signUp();
		}else {
			vac.exit();
		}
	}
}
