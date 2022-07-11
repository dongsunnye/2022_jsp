package dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String bdate;
	private int bcount;
	private String content;
	private int like;
	private int hate;
	
	public BoardDTO() {	}

	public BoardDTO(int bno, String title, String writer, String bdate, int bcount, String content, int like,
			int hate) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.bdate = bdate;
		this.bcount = bcount;
		this.content = content;
		this.like = like;
		this.hate = hate;
	}

	public BoardDTO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
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
