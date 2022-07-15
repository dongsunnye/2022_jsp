package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import view.ModelAndView;

public class CommentDeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		BoardService.getInstance().deleteBoardComment(cno);
		return new ModelAndView("boardView.do?bno=",true);
	}

}
