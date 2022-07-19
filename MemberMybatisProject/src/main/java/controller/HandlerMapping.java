package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance==null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "login":
			controller = new LoginController();
			break;
		case "logout":
			controller = new LogoutController();
			break;
		case "register":
			controller = new RegisterController();
			break;
		case "search":
			controller = new SearchController();
			break;
		case "delete":
			controller = new DeleteController();
			break;
		case "updateView":
			controller = new UpdateViewController();
			break;
		case "update":
			controller = new UpdateController();
			break;
		}
		
		return controller;
	}

	
	
	
	
}
