package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import view.ModelAndView;

public class DeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MemberService.getInstance().deleteMemberDTO(id);
		return new ModelAndView("memberList.do?command=search", true);
	}

}
