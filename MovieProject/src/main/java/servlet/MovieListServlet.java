package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import dto.MovieDTO;
import vo.PaggingVO;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/list.do")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1;
		//페이지 번호가 있을때만 읽어옴
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//페이지에 해당하는 글 목록을 조회
		ArrayList<MovieDTO> list = MovieDAO.getInstance().selectMovieList(pageNo);
		//전체 페이지 개수
		int count = MovieDAO.getInstance().selectCount();
		PaggingVO pagging = new PaggingVO(count, pageNo, 7, 4);
		request.setAttribute("list", list);
		request.setAttribute("pagging", pagging);
		
		request.getRequestDispatcher("movie_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
