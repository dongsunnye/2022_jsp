package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;

public interface Controller {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException;
}
