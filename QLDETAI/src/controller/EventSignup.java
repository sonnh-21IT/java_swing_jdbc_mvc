package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewSignup;

public class EventSignup implements ActionListener {
	private ViewSignup vsu;

	public EventSignup(ViewSignup vsu) {
		this.vsu = vsu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src=e.getActionCommand();
		if(src.equalsIgnoreCase("Đăng Ký")) {
			vsu.signup();
		}else {
			vsu.login();
		}
	}
}
