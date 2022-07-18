package service;

public class MovieService {
	private static MovieService instance = new MovieService();

	private MovieService() {
	}

	public static MovieService getInstance() {
		if(instance == null)
			instance = new MovieService();
		return instance;
	}
	
	
	
}
