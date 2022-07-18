package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MovieDTO;
import service.MovieService;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String openDate = request.getParameter("open_date");
		int audienceCount = Integer.parseInt(request.getParameter("audience_count"));
		String director = request.getParameter("director");
		
		int result = MovieService.getInstance().insertMovie(
				new MovieDTO(0, title, openDate, audienceCount, director));
		//System.out.println(result);
		//데이터 등록이 성공하면 전체 영화데이터를 json으로 전송
		List<MovieDTO> list = MovieService.getInstance().selectAllMovie();
		//데이터 등록이 실패하면 데이터 등록에 실패 하였습니다. 에러 메세지 처리
	}

}




