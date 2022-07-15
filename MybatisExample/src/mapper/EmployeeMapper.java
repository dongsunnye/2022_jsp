package mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.EmployeeDTO;

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
	
	public List<EmployeeDTO> selectAllEmployee(){
		return session.selectList("selectAllEmployee");
	}
	
	public List<EmployeeDTO> selectDeptEmployee(String dept){
		return session.selectList("selectDeptEmployee", dept);
	}

}











