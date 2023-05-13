package model;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnDB {
	public static Connection openConnection() throws Exception {
		SQLServerDataSource db = new SQLServerDataSource();

		db.setUser("sa");
		db.setPassword("nhsnhs2003");
		db.setServerName("HONGSON\\SQLEXPRESS");
		db.setPortNumber(1433);
		db.setDatabaseName("MidTermDB");

		Connection conn = db.getConnection();
		if (conn != null) {
			System.out.println("Thành Công");
		}
		return conn;
	}
	public static void main(String[] args) throws Exception{
		ConnDB.openConnection();
	}
}
