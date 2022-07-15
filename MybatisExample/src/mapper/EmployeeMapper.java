package mapper;

public class EmployeeMapper {
	private static EmployeeMapper instance = new EmployeeMapper();

	private EmployeeMapper() {
		
	}

	public static EmployeeMapper getInstance() {
		if(instance == null)
			instance = new EmployeeMapper();
		return instance;
	}

}
