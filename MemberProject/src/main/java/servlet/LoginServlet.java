package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println("LoginServlet = " + id + " , " + passwd);
		MemberDTO dto = MemberDAO.getInstance().login(id, passwd);
		System.out.println(dto);
		if(dto == null) {
			//로그인이 안되었을때 - 자바스크립트로 경고창 출력 후 이전 페이지로 이동
			response.setContentType("text/html;charset=utf-8");//한글 설정
			PrintWriter out = response.getWriter();
			out.write("<script>alert('로그인실패 아이디와 비밀번호를 확인하세요');history.back();</script>");
		}else {
			//세션 생성
			HttpSession session = request.getSession();
			//세션에 dto를 저장
			session.setAttribute("dto", dto);
			//나이가 가장많은 인원 3명을 저장
			ArrayList<MemberDTO> list = MemberDAO.getInstance().selectTopAge3();
			session.setAttribute("list", list);
			
			//페이지 이동 main.jsp로 이동
			//request.getRequestDispatcher("main.jsp").forward(request, response);
			response.sendRedirect("main.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}







