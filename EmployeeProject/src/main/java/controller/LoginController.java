package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import model.ModelAndView;
import service.EmployeeService;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		ModelAndView view = null;
		
		EmployeeDTO dto = EmployeeService.getInstance().login(eno,name);
		if(dto != null) {
			//직급과 부서 상관없이 세션 처리
			request.getSession().setAttribute("dto", dto);
			//인사팀이면서 직급이 과장이상인지 체크
			if(dto.getPosition() > 3 && dto.getDept().equals("인사")) {
				ArrayList<EmployeeDTO> list = EmployeeService.getInstance().selectAllEmployee();
				ArrayList<String> position = EmployeeService.getInstance().selectAllPosition();
				request.getSession().setAttribute("position", position);
				request.getSession().setAttribute("list", list);
			}
			view = new ModelAndView("employee_manager.jsp", true);
			
		}else {
			response.getWriter().write("<script>alert('사번 및 이름을 확인하세요');"
					+ "history.back();</script>");
		}
		return view;
	}

}


