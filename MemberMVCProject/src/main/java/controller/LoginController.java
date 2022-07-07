package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		ModelAndView view = null;
		MemberDTO dto = MemberService.getInstance().login(id, passwd);

		if(dto == null) {
			try {
				//로그인이 안되었을때 - 자바스크립트로 경고창 출력 후 이전 페이지로 이동
				response.setContentType("text/html;charset=utf-8");//한글 설정
				PrintWriter out = response.getWriter();
				out.write("<script>alert('로그인실패 아이디와 비밀번호를 확인하세요');history.back();</script>");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//세션 생성
			HttpSession session = request.getSession();
			//세션에 dto를 저장
			session.setAttribute("dto", dto);
			//나이가 가장많은 인원 3명을 저장
			ArrayList<MemberDTO> list = MemberService.getInstance().selectTopAge3();
			session.setAttribute("list", list);
			
			view = new ModelAndView("main.jsp", true); 
		}
		return view;
	}

}



