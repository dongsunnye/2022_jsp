package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardDTO dto = new BoardDTO(title, writer, content);
		int bno = BoardService.getInstance().selectBoardNo();
		dto.setBno(bno);
		// 1
		BoardService.getInstance().insertBoard(dto);
		// 2
		return new ModelAndView("main.do", true);
	}

}





