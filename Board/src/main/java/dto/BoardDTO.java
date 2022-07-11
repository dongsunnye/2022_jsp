package dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String nick;
	private int bcount;
	private String bdate;
	private int like;
	private int hate;
	private String content;
	
	public BoardDTO() {	}

	public BoardDTO(int bno, String title, String writer, String nick, int bcount, String bdate, int like, int hate) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.nick = nick;
		this.bcount = bcount;
		this.bdate = bdate;
		this.like = like;
		this.hate = hate;
	}
	public BoardDTO(int bno, String title, String writer, String nick, int bcount, String bdate, int like, int hate,
			String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.nick = nick;
		this.bcount = bcount;
		this.bdate = bdate;
		this.like = like;
		this.hate = hate;
		this.content = content;
	}


	public BoardDTO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}
	
	
	
	
	
}
