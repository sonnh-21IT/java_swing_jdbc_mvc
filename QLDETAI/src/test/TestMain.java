package test;

import model.ConnDB;
import view.ViewAccess;
import view.ViewMain;

public class TestMain {
	public static void main(String[] args)throws Exception {
//		new ViewMain().setVisible(true);
		new ViewAccess().setVisible(true);
//		ConnDB.openConnection();
	}
}
