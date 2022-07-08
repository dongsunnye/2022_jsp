package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;

public class MovieDAO {
	private static MovieDAO instance = new MovieDAO();

	public MovieDAO() {	}

	public static MovieDAO getInstance() {
		if(instance == null)
			instance = new MovieDAO();
		return instance;
	}

	public int selectCount() {
		int count = 0;
		String sql = "select count(*) from movie";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		return count;
	}

	
}














