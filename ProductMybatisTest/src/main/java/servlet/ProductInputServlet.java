package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.ProductDTO;
import mapper.ProductMapper;

/**
 * Servlet implementation class ProductInputServlet
 */
@WebServlet("/ProductInputServlet")
public class ProductInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		try {
			String productNo = request.getParameter("product_no");
			String productName = request.getParameter("product_name");
			String maker = request.getParameter("maker");
			int ea = Integer.parseInt(request.getParameter("ea"));
			int price = Integer.parseInt(request.getParameter("price"));
			
			ProductDTO dto = new ProductDTO(productNo, productName, price, ea, maker);
			
			ProductMapper.getInstance().insertProduct(dto);
			
			List<ProductDTO> list = ProductMapper.getInstance().selectAllProduct();
			JSONArray arr = new JSONArray(list);
			response.getWriter().write(arr.toString());
		}catch (NumberFormatException e) {
			response.setStatus(1001);
			response.getWriter().write("재고와 금액은 숫자로 입력하세요");
		}catch (SQLException e) {
			response.setStatus(1002);
			response.getWriter().write("잘못된 데이터를 입력하였습니다.");
		}catch (Exception e) {
			response.setStatus(1003);
			response.getWriter().write("재고와 금액은 양수로 입력하세요");
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
