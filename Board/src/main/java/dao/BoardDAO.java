package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private Connection conn;
	private BoardDAO() {
		conn = DBManager.getInstance().getConn();
	}
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		return instance;
	}
	public ArrayList<BoardDTO> selectBoardList(int pageNo) {
		String sql = "select * from "
				+ "(select ceil(rownum / 15) as pageNo, b.* from board_view b)"
				+ " where pageNo = ?";
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardDTO(rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getInt(8), rs.getInt(9)));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		return list;
	}
	public int selectAllCount() {
		int count = 0;
		String sql = "select count(*) from board_view";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
}











