package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;

public class SelectAllMemberMain {

	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().getConn();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) 
						+ rs.getString(3) + rs.getInt(4) + rs.getString(5)
						+ rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
