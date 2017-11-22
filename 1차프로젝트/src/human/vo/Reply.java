package human.vo;

public class Reply {

	private int gameNum;
	private int replyNum;
	private String content;
	
	public Reply() {}

	public Reply(int gameNum, String content) {
		this.gameNum = gameNum;
		this.content = content;
	}

	public int getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Reply [gameNum=" + gameNum + ", replyNum=" + replyNum + ", content=" + content + "]";
	}

	
}
