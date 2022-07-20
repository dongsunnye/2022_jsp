package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.BoardCommentDTO;
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
	public void insertBoard(BoardDTO dto) {
		String sql = "insert into board(bno, title, writer, content, bcount) "
				+ "values(board_bno.nextval,?,?,?,0)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
	}
	public BoardDTO selectBoard(int bno) {
		String sql = "select * from board_view where bno = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		BoardDTO dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getString(9)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		return dto;
	}
	public void deleteBoard(int bno) {
		String sql = "delete from board where bno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
	}
	public void updateBoard(BoardDTO dto) {
		String sql = "update board set title=? ,content=? where bno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}		
	}
	public void addCountBoard(int bno) {
		String sql = "update board set bcount = bcount + 1 where bno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		
	}
	public int insertBoardLike(int bno, String id) {
		String sql = "insert into board_like values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int deleteBoardLike(int bno, String id) {
		String sql = "delete from board_like where bno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int insertBoardHate(int bno, String id) {
		String sql = "insert into board_hate values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int deleteBoardHate(int bno, String id) {
		String sql = "delete from board_hate where bno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public void insertBoardComment(BoardCommentDTO dto) {
		String sql = "insert into board_comment(cno,contetnt,bno,writer) "
				+ "values(board_comment_cno.nextval,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getComment());
			pstmt.setInt(2, dto.getBno());
			pstmt.setString(3, dto.getWriter());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
	}
	public ArrayList<BoardCommentDTO> selectBoardCommentList(int bno) {
		String sql = "select * from board_comment_view where bno = ?";
		ArrayList<BoardCommentDTO> list = new ArrayList<BoardCommentDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardCommentDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	public void deleteBoardComment(int cno) {
		String sql = "delete from board_comment where cno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		
	}
	public int insertBoardCommentLike(int cno, String id) {
		String sql = "insert into board_comment_like values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int deleteBoardCommentLike(int cno, String id) {
		String sql = "delete from board_comment_like where cno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int insertBoardCommentHate(int cno, String id) {
		String sql = "insert into board_comment_hate values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	public int deleteBoardCommentHate(int cno, String id) {
		String sql = "delete from board_comment_hate where cno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
		
	}
	
}











