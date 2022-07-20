package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		//읽어온 내용을 movie 테이블에 추가
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
	}

}



