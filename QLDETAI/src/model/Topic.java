package model;

public class Topic {
	private String ma_DT, ten_DT, ten_TG, cap_QL, linhVuc, lienhe;
	private int namCB;

	public Topic() {

	}

	public Topic(String ma_DT, String ten_DT, String ten_TG, String cap_QL, String linhVuc, String lienhe, int namCB) {
		this.ma_DT = ma_DT;
		this.ten_DT = ten_DT;
		this.ten_TG = ten_TG;
		this.cap_QL = cap_QL;
		this.linhVuc = linhVuc;
		this.lienhe = lienhe;
		this.namCB = namCB;
	}

	public String getMa_DT() {
		return ma_DT;
	}

	public void setMa_DT(String ma_DT) {
		this.ma_DT = ma_DT;
	}

	public String getTen_DT() {
		return ten_DT;
	}

	public void setTen_DT(String ten_DT) {
		this.ten_DT = ten_DT;
	}

	public String getTen_TG() {
		return ten_TG;
	}

	public void setTen_TG(String ten_TG) {
		this.ten_TG = ten_TG;
	}

	public String getCap_QL() {
		return cap_QL;
	}

	public void setCap_QL(String cap_QL) {
		this.cap_QL = cap_QL;
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public String getLienhe() {
		return lienhe;
	}

	public void setLienhe(String lienhe) {
		this.lienhe = lienhe;
	}

	public int getNamCB() {
		return namCB;
	}

	public void setNamCB(int namCB) {
		this.namCB = namCB;
	}

}
