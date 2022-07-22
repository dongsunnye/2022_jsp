package mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();

	private BoardMapper() {

	}

	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}

	public List<BoardDTO> selectBoardList(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectBoardList", pageNo);
		session.close();
		return list;
	}

	public BoardDTO selectBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		BoardDTO dto = session.selectOne("selectBoard", bno);
		session.close();
		return dto;
	}
	
	public int selectBoardCount() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.selectOne("selectBoardCount");
		session.close();
		
		return result;
	}

	public int insertBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.insert("insertBoard", dto);
		session.commit();
		return result;
	}

	public int updateBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.update("updateBoard", dto);
		session.commit();
		return result;
	}

	public int insertBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardLike", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("deleteBoardLike", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insertBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardHate", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("deleteBoardHate", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int addCountBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.update("addCountBoard", bno);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}

	public int insertBoardComment(BoardCommentDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardComment", dto);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int insertBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.insert("insertBoardCommentLike", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentLike", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int insertBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.insert("insertBoardCommentHate", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentHate", map);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
	}

	public int deleteBoardComment(int cno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.delete("deleteBoardComment", cno);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;		
		
	}
	
}










