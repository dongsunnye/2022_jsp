package mapper;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();

	private MemberMapper() {

	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}
	
}
