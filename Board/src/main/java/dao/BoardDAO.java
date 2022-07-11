package dao;

import java.sql.Connection;

import config.DBManager;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private Connection conn;
	private BoardDAO() {
		conn = DBManager.getInstance().getConn();
	}
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
}
