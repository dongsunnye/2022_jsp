package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

/**
 * Servlet implementation class TestSevlet
 */
@WebServlet("/test.do")
public class TestSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MeberDTO 하나 생성
		MemberDTO dto = new MemberDTO("A0001", "12345", "홍길동", 20, "남", 33000, "VVIP");
		
		//session 생성
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		session.setAttribute("msg", "session message");
		
		
		//ArrayList<MemberDTO> 생성해서 3건이상 리스트에 저장
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("A0001","1234","AAAA",20,"남",33333,"Gold"));
		list.add(new MemberDTO("A0002","1234","BBBB",20,"남",33333,"Bronze"));
		list.add(new MemberDTO("A0003","1234","CCCC",20,"남",33333,"Silver"));
		request.setAttribute("list", list);
		request.setAttribute("age", 20);
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
