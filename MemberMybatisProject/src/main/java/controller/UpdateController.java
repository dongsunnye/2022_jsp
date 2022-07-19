package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 수정된 정보들을 전부 가져옴
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		MemberDTO dto = new MemberDTO(id, passwd, name, age, gender, address);

		String type = request.getParameter("type");
		ModelAndView view = null;
		int result = MemberService.getInstance().updateMemberDTO(dto);
		System.out.println(result + "건 수정이 완료됨");
		if (type.equals("my")) {
			HttpSession session = request.getSession();
			dto.setPasswd(passwd);
			session.setAttribute("dto", dto);
			view = new ModelAndView("main.jsp", true);
		} else {
			view = new ModelAndView("memberList.do?command=search", true);
		}
		return view;
	}

}
