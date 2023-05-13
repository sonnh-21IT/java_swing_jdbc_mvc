package model;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TopicDAO {

	public boolean insert(Topic topic) throws Exception {
		String sql = "insert into DETAI(MA_DT,TEN_DT,TAC_GIA,LINH_VUC,CAP_QL,NAM_CB,LIEN_HE) values (?,?,?,?,?,?,?)";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, topic.getMa_DT());
			ps.setString(2, topic.getTen_DT());
			ps.setString(3, topic.getTen_TG());
			ps.setString(4, topic.getLinhVuc());
			ps.setString(5, topic.getCap_QL());
			ps.setInt(6, topic.getNamCB());
			ps.setString(7, topic.getLienhe());

			return ps.executeUpdate() > 0;
		}
	}

	public Topic Search(String search) throws Exception {
		String sql = "select * from DETAI where MA_DT=?";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, search);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Topic topic = new Topic();
				topic.setMa_DT(rs.getString("MA_DT"));
				topic.setTen_DT(rs.getString("TEN_DT"));
				topic.setTen_TG(rs.getString("TAC_GIA"));
				topic.setLinhVuc(rs.getString("LINH_VUC"));
				topic.setCap_QL(rs.getString("CAP_QL"));
				topic.setNamCB(rs.getInt("NAM_CB"));
				topic.setLienhe(rs.getString("LIEN_HE"));

				rs.close();
				return topic;
			} else {
				rs.close();
				return null;
			}
		}
	}

	public boolean Update(Topic topic) throws Exception {
		String sql = "update DETAI set TEN_DT=?,TAC_GIA=?,LINH_VUC=?,CAP_QL=?,NAM_CB=?,LIEN_HE=? where MA_DT=?";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(7, topic.getMa_DT());
			ps.setString(1, topic.getTen_DT());
			ps.setString(2, topic.getTen_TG());
			ps.setString(3, topic.getLinhVuc());
			ps.setString(4, topic.getCap_QL());
			ps.setInt(5, topic.getNamCB());
			ps.setString(6, topic.getLienhe());

			return ps.executeUpdate() > 0;

		}
	}

	public boolean Delete(String code) throws Exception {
		String sql = "delete from DETAI where MA_DT=?";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, code);

			return ps.executeUpdate() > 0;

		}
	}

	public int CountTG() {
		String sql = "SELECT TAC_GIA,COUNT(DISTINCT TAC_GIA) AS 'tacgia' FROM dbo.DETAI GROUP BY TAC_GIA";
		int count = 0;
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return count;
	}

	public int CountDT() {
		String sql = "SELECT TEN_DT,COUNT(DISTINCT TEN_DT) AS 'tacgia' FROM dbo.DETAI GROUP BY TEN_DT";
		int count = 0;
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return count;
	}

	public int CountCQLTinh() {
		String sql = "select * from DETAI where CAP_QL=N'Tỉnh'";
		int count = 0;
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return count;
	}

	public int CountCQLHuyen() {
		String sql = "select * from DETAI where CAP_QL=N'Huyện'";
		int count = 0;
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return count;
	}

	public int CountCQLNN() {
		String sql = "select * from DETAI where CAP_QL=N'Nhà Nước'";
		int count = 0;
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return count;
	}

	public List<Statistical> StatisticalDAO() {
		List<Statistical> list = new ArrayList<>();
		String sql = "select NAM_CB,COUNT(NAM_CB) 'SODT',CAP_QL FROM DETAI  GROUP BY CAP_QL,NAM_CB ORDER BY NAM_CB";
		try (Connection conn = ConnDB.openConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Statistical tk = new Statistical();
				tk.setNamCB(rs.getInt(1));
				tk.setSoDT(rs.getInt(2));
				tk.setCapQL(rs.getString(3));
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return null;
		}
	}

	public List<Topic> getData() {
		List<Topic> list = new ArrayList<>();
		try {
			Connection conn = ConnDB.openConnection();
			String sql = "select * from DETAI";
			PreparedStatement ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setMa_DT(rs.getString("MA_DT"));
				topic.setTen_DT(rs.getString("TEN_DT"));
				topic.setTen_TG(rs.getString("TAC_GIA"));
				topic.setLinhVuc(rs.getString("LINH_VUC"));
				topic.setCap_QL(rs.getString("CAP_QL"));
				topic.setNamCB(rs.getInt("NAM_CB"));
				topic.setLienhe(rs.getString("LIEN_HE"));

				list.add(topic);
			}
			ps.close();
			rs.close();
			conn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}