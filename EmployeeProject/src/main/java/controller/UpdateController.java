package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import model.ModelAndView;
import service.EmployeeService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		int position = Integer.parseInt(request.getParameter("position"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		EmployeeDTO dto = new EmployeeDTO(eno, name, dept, position, salary);
		
		EmployeeService.getInstance().updateEmployee(dto);
		
		return new ModelAndView("main.do", true);
	}

}
