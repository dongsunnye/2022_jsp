package mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.ProductDTO;

public class ProductMapper {
	private static ProductMapper instance = new ProductMapper();

	private ProductMapper() {
	}

	public static ProductMapper getInstance() {
		if(instance == null)
			instance = new ProductMapper();
		return instance;
	}
	
	public List<ProductDTO> selectAllProduct() throws SQLException{
		List<ProductDTO> list = null;
		list = DBManager.getInstance().getSession().selectList("selectAllProduct");
		return list;
	}
	
	public int insertProduct(ProductDTO dto) throws SQLException{
		int result = 0;
		SqlSession session = DBManager.getInstance().getSession();
		result = session.insert("insertProduct", dto);
		session.commit();
		session.close();
		
		return result;
	}
}






