package dao;

import java.sql.Connection;

import config.DBManager;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn;
	private MemberDAO() {
		conn = DBManager.getInstance().getConn();
	}
	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
}
