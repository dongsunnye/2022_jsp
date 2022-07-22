package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dao.BoardDAO;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import mapper.BoardMapper;

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
	public List<BoardDTO> selectBoardList(int pageNo) {
		return BoardMapper.getInstance().selectBoardList(pageNo);
	}
	public int selectAllCount() {
		return BoardMapper.getInstance().selectBoardCount();
	}
	public void insertBoard(BoardDTO dto) {
		BoardMapper.getInstance().insertBoard(dto);
	}
	public BoardDTO selectBoard(int bno) {
		return BoardMapper.getInstance().selectBoard(bno);
	}
	public void deleteBoard(int bno) {
		BoardDAO.getInstance().deleteBoard(bno);
	}
	public void updateBoard(BoardDTO dto) {
		BoardMapper.getInstance().updateBoard(dto);
	}
	public void addBoardCount(int bno) {
		BoardMapper.getInstance().addCountBoard(bno);
	}
	public int insertBoardLike(int bno,String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		int result = BoardMapper.getInstance().insertBoardLike(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardLike(map);
		return result;
	}
	public int insertBoardHate(int bno, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		System.out.println(map);
		int result = BoardMapper.getInstance().insertBoardHate(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardHate(map);
		return result;
	}
	public void insertBoardComment(BoardCommentDTO boardCommentDTO) {
		BoardMapper.getInstance().insertBoardComment(boardCommentDTO);
	}
	public ArrayList<BoardCommentDTO> selectCommentList(int bno) {
		return BoardDAO.getInstance().selectBoardCommentList(bno);
	}
	public void deleteBoardComment(int cno) {
		BoardDAO.getInstance().deleteBoardComment(cno);		
	}
	public int insertBoardCommentLike(int cno, String id) {
		int result =BoardMapper.getInstance().insertBoardCommentLike(cno,id);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentLike(cno,id);
		return result;
	}
	public int insertBoardCommentHate(int cno, String id) {
		int result =BoardMapper.getInstance().insertBoardCommentHate(cno,id);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentHate(cno,id);
		return result;
	}
	
}













