package service;

import java.util.ArrayList;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();

	private EmployeeService() {	}

	public static EmployeeService getInstance() {
		if(instance == null)
			instance = new EmployeeService();
		return instance;
	}

	public EmployeeDTO login(String eno, String name) {
		return EmployeeDAO.getInstance().login(eno,name);
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		return EmployeeDAO.getInstance().selectAllEmployee();
	}

	public ArrayList<String> selectAllPosition() {
		return EmployeeDAO.getInstance().selectAllPosition();
	}

	public void deleteEmployee(String eno) {
		EmployeeDAO.getInstance().deleteEmployee(eno);
	}

	
	
}







