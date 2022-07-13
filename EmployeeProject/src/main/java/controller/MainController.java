package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import model.ModelAndView;
import service.EmployeeService;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<EmployeeDTO> list = EmployeeService.getInstance().selectAllEmployee();
		ArrayList<String> position = EmployeeService.getInstance().selectAllPosition();
		request.getSession().setAttribute("position", position);
		request.getSession().setAttribute("list", list);
		return new ModelAndView("employee_manager.jsp", true);
	}

}







