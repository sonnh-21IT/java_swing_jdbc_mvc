package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewMain;

public class EventChagneView implements ActionListener {
	private ViewMain vm;

	public EventChagneView(ViewMain vm) {
		this.vm = vm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equalsIgnoreCase("Màn Hình Chính")) {
			vm.viewHome();
		} else if (src.equalsIgnoreCase("Quản Lý Đề Tài")) {
			vm.viewManeger();
		} else if (src.equalsIgnoreCase("Tổng Quát")) {
			vm.viewGenerality();
		} else {
			vm.viewLogin();
		}
	}
}
