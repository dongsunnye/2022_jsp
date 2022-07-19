package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;
import exception.MemberException;
import service.MemberService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		MemberDTO dto = new MemberDTO(id, passwd, name, age, gender, address);
		PrintWriter out = null;
		response.setContentType("text/html;charset=utf-8");
		
		try {
			out = response.getWriter();
			MemberService.getInstance().insertMemberDTO(dto);
			//회원정보 등록을 성공 했을때 경고창으로 회원정보 등록을 알려준 후에 main.jsp로 이동
			out.write("<script>alert('회원정보 추가 완료');location.href='memberList.do?command=search';</script>");
		} catch (MemberException e) {
			//회원정보 등록을 실패 했을때 경고창으로 회원정보 실패를을 알려준 후에 이전 페이지로 이동
			out.write("<script>alert('회원정보 추가 실패');history.back();</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
