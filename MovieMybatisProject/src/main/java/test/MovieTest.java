package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dto.MovieDTO;

class MovieTest {

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
		for(int i=0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			MovieDTO dto = new MovieDTO(obj.getInt("bno"),
					obj.getString("title"), 
					obj.getString("open_date"), obj.getInt("audience_count"),
					obj.getString("director"));
			System.out.println(dto.toString());
			//읽어온 내용을 movie 테이블에 추가
			
		}
			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
	}

}



