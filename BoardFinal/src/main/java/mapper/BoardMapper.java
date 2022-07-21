package mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
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
	
}










