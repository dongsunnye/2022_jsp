package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import config.DBManager;
import dto.MemberDTO;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/search.do")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBManager.getInstance().getConn();
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		String sql = "select * from member where ";
		sql += kind + " like '%' || ? || '%'"; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 		
			while (rs.next()) {
				list.add(new MemberDTO(rs.getString(1),rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			
			JSONArray array = new JSONArray(list);
			//System.out.println(response.getCharacterEncoding() );
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(array.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
