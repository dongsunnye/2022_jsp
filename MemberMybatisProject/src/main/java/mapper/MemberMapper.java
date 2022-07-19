package mapper;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private SqlSession session;
	private MemberMapper() {
		session = DBManager.getInstance().getSession();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}

	
	
}
