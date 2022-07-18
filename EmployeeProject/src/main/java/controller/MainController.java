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
		ArrayList<EmployeeDTO> list = null;
		String kind = request.getParameter("kind");
		String search = request.getParameter("search"); 
		if(kind == null)
			list = EmployeeService.getInstance().selectAllEmployee();
		else
			list = EmployeeService.getInstance().selectEmployee(kind,search);
		ArrayList<String> position = EmployeeService.getInstance().selectAllPosition();
		request.getSession().setAttribute("position", position);
		request.getSession().setAttribute("list", list);
		return new ModelAndView("employee_manager.jsp", true);
	}

}







