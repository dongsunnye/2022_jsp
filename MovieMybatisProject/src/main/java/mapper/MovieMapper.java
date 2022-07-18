package mapper;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;

public class MovieMapper {
	private static MovieMapper instance = new MovieMapper();

	private SqlSession session;
	
	private MovieMapper() {
		session = DBManager.getInstance().getSession();
	}

	public static MovieMapper getInstance() {
		if(instance == null)
			instance = new MovieMapper();
		return instance;
	}

	
}
