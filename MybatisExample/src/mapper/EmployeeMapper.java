package mapper;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;

public class EmployeeMapper {
	private static EmployeeMapper instance = new EmployeeMapper();
	private SqlSession session;
	
	private EmployeeMapper() {
		session = DBManager.getInstance().getSession();
	}

	public static EmployeeMapper getInstance() {
		if(instance == null)
			instance = new EmployeeMapper();
		return instance;
	}

}
