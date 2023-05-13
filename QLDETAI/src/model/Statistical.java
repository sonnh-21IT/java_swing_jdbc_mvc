package model;

public class Statistical {
	private int namCB, soDT;
	private String capQL;

	public Statistical() {

	}

	public Statistical(int namCB, int soDT, String capQL) {
		this.namCB = namCB;
		this.soDT = soDT;
		this.capQL = capQL;
	}

	public int getNamCB() {
		return namCB;
	}

	public void setNamCB(int namCB) {
		this.namCB = namCB;
	}

	public int getSoDT() {
		return soDT;
	}

	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}

	public String getCapQL() {
		return capQL;
	}

	public void setCapQL(String capQL) {
		this.capQL = capQL;
	}
}
