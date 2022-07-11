package service;

import java.sql.Connection;

import config.DBManager;

public class BoardService {
	private static BoardService instance = new BoardService();
	private Connection conn;
	private BoardService() {
		conn = DBManager.getInstance().getConn();
	}
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	
}
