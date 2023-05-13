package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	public Account checkData(Account acc) throws Exception {
		String sql = "SELECT * FROM Account WHERE UserName=? AND  PassWord=?";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ptsm = conn.prepareStatement(sql);) {
			ptsm.setString(1, acc.getUser());
			ptsm.setString(2, acc.getPass());
			ResultSet rs = ptsm.executeQuery();
			if (rs.next()) {
				Account accreal = new Account();
				accreal.setUser(rs.getString("UserName"));
				accreal.setPass(rs.getString("PassWord"));
				accreal.setName(rs.getString("Name"));
				return accreal;
			}
			return null;
		}
	}

	public boolean addAccount(Account acc) throws Exception {
		String sql = "insert into Account(UserName,PassWord,Name) values (?,?,?)";
		try (Connection conn = ConnDB.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, acc.getUser());
			ps.setString(2,acc.getPass());
			ps.setString(3,acc.getName());
			return ps.executeUpdate()>0;
		}
	}
}
