package controller;

import java.io.IOException;

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
		
	}

}
