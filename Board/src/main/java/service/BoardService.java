package service;

import java.sql.Connection;
import java.util.ArrayList;

import config.DBManager;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardService {
	private static BoardService instance = new BoardService();
	private Connection conn;
	private BoardService() {
		conn = DBManager.getInstance().getConn();
	}
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	public ArrayList<BoardDTO> selectBoardList(int pageNo) {
		return BoardDAO.getInstance().selectBoardList(pageNo);
	}
	public int selectAllCount() {
		return BoardDAO.getInstance().selectAllCount();
	}
	public void insertBoard(BoardDTO dto) {
		BoardDAO.getInstance().insertBoard(dto);
	}
	public BoardDTO selectBoard(int bno) {
		return BoardDAO.getInstance().selectBoard(bno);
	}
	public void deleteBoard(int bno) {
		BoardDAO.getInstance().deleteBoard(bno);
	}
	
}





