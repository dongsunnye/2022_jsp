package service;

import java.sql.Connection;

import config.DBManager;

public class MemberService {
	private static MemberService instance = new MemberService();
	private Connection conn;
	private MemberService() {
		conn = DBManager.getInstance().getConn();
	}
	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}
	
}
