package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;
import exception.MemberException;
import service.MemberService;
import view.ModelAndView;

public class UpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		ModelAndView view = null;
		try {
			MemberDTO dto = MemberService.getInstance().selectMemberDTO(id);
			request.setAttribute("dto", dto);
			view =new ModelAndView("member_update_view.jsp", false); 
		} catch (MemberException e) {
			try {
				response.getWriter().write("<script>alert('"+e.getMessage()+"');"
						+ "location.href='memberList.do?command=search';</script>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return view;
	}

}
