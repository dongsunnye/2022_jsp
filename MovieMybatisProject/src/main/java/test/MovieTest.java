package test;

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
import dto.MovieDTO;

class MovieTest {
	static SqlSession session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//movie.json 파일 읽어옴
		FileReader fr = new FileReader("movie.json");
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		while(true) {
			String t = br.readLine();
			if(t ==null) break;
			str += t;
		}
		System.out.println(str);
		JSONArray arr = new JSONArray(str);
		session = DBManager.getInstance().getTestSession();
		int count = 0;
		for(int i=0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			MovieDTO dto = new MovieDTO(obj.getInt("bno"),
					obj.getString("title"), 
					obj.getString("open_date"), obj.getInt("audience_count"),
					obj.getString("director"));
			System.out.println(dto.toString());
			//읽어온 내용을 movie 테이블에 추가
			count += session.insert("insertTestMovie", dto);
		}
		System.out.println("테스트 데이터 " + count + "건 추가 하였습니다.");
			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		System.out.println("테스트 데이터 제거");
	}

	//데이터 추가 테스트 - insertMovie
	@Test
	void testInsertMovie() {
		MovieDTO dto = new MovieDTO(11, "테스트 제목", "23/09/11", 12415, "감독");
		int result = 0;
		try {
			result = session.insert("insertMovie", dto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(result, 1,"영화 정보 추가 기능 테스트 실패");
	}
	
	//데이터 검색 테이스 - selectMovieList
	@Test
	void testSelectMovieList() {
		
	}

}








