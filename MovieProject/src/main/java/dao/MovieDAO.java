package dao;

public class MovieDAO {
	private static MovieDAO instance = new MovieDAO();

	public MovieDAO() {	}

	public static MovieDAO getInstance() {
		if(instance == null)
			instance = new MovieDAO();
		return instance;
	}

	
}
