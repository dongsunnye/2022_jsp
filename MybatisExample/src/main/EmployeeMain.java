package main;
import java.util.List;

import dto.EmployeeDTO;
import mapper.EmployeeMapper;

public class EmployeeMain {

	public static void main(String[] args) {
		/*
		 * List<EmployeeDTO> list = EmployeeMapper.getInstance().selectAllEmployee();
		 * 
		 * for(EmployeeDTO dto : list) System.out.println(dto);
		 */
		List<EmployeeDTO> list = EmployeeMapper.getInstance().selectDeptEmployee("회계");
		for (EmployeeDTO dto : list)
			System.out.println(dto);
	}

}
