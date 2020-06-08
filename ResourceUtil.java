package shuben;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceUtil {
	public static void close(ResultSet rs,Statement st,Connection con) {
		try {
			rs.close();
			st.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pst,Connection con) {
		try {
			pst.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}