package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MovieDTO;

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

	public ArrayList<MovieDTO> selectMovieList(int pageNo) {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String sql = "select * from (select ceil(rownum / 7) as page_no, "
				+ "m.* from (select * from movie order by bno desc) m) "
				+ "where page_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MovieDTO(rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		
		return list;
	}

	public ArrayList<MovieDTO> selectMovie(String kind, String search) {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String sql = "select * from movie ";
		if(kind.equals("year"))
			sql += "where to_char(open_date,'RRRR') = ?";
		else
			sql += "where "+kind+" like '%' || ? || '%'";
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MovieDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		
		return list;
	}

	
}














