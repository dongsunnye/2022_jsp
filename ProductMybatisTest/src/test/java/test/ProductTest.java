package test;

import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.ProductDTO;

class ProductTest {
	static SqlSession session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FileReader fr = new FileReader("product.json");
		BufferedReader br = new BufferedReader(fr);
		session = DBManager.getInstance().getSession();
		String str = new String();
		
		while(true) {
			String s = br.readLine();
			if(s == null) break;
			str += s;
		}
		System.out.println(str);
		JSONArray arr = new JSONArray(str);
		for(int i=0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			ProductDTO dto = new ProductDTO();
			dto.setProductNo(obj.getString("product_no"));
			dto.setProductName(obj.getString("product_name"));
			dto.setMaker(obj.getString("maker"));
			dto.setEa(obj.getInt("ea"));
			dto.setPrice(obj.getInt("price"));
			session.insert("insertProduct",dto);
		}
		System.out.println("테스트용 데이터 추가 완료");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		session.close();
	}

	@Test
	void test() {
		ProductDTO dto = session.selectOne("selectProduct", "89451111152");
		assertNull(dto, "검색 테스트가 오류가 있습니다.");
	}

}






