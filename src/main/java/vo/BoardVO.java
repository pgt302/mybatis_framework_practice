package vo;

public class BoardVO {
	private int boardNum;
	private String memberId;
	private String title;
	private String content;
	private String boardDate;
	
	//기본생성자
	public BoardVO () {}
	//외래키인 memberId,타이틀,본문 담는 생성자
	public BoardVO (String memberid, String title, String content) {
		this.memberId =memberid;
		this.title = title;
		this.content = content;
	}
	//AllCostructor
	public BoardVO(int boardNum, String memberId, String title, String content, String boardDate) {
		this.boardNum = boardNum;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.boardDate = boardDate;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return boardNum + " | " + title + " | " + boardDate;
	}
}
