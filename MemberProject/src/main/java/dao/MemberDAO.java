package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn;
	
	private MemberDAO() {
		conn = DBManager.getInstance().getConn();
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		MemberDTO dto = null;
		String sql = "select * from member where id like ? and passwd like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs,pstmt);
		}
		
		return dto;
	}

	public ArrayList<MemberDTO> selectTopAge3() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select m.* from (select * from member ORDER BY age desc) m where rownum <= 3";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs,pstmt);
		}
		
		return list;
	}
	
	
	
}









