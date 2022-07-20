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
	
}










