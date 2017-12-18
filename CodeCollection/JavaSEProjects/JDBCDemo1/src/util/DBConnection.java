package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/sale?useUnicode=true&characterEncoding=utf-8";
	public static final String DBUSER = "root";
	public static final String DBPASS = "lxy";

	Connection conn = null;

	public DBConnection() {

		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
