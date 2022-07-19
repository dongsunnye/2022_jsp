package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class SearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		System.out.println(kind);
		
		List<MemberDTO> list = MemberService.getInstance().selectMemberList(kind, search);
		
		request.setAttribute("list", list);
		
		return new ModelAndView("member_list.jsp", false);
	}

}




