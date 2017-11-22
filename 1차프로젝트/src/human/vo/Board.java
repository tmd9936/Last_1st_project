package human.vo;

public class Board {

	private int gamenum;
	private String title, content;
	private int hits;

	public Board() {
	}

	public Board(String title, String content) {

		this.title = title;
		this.content = content;
	}

	public int getGameNum() {
		return gamenum;
	}

	public void setGameNum(int gameNum) {
		this.gamenum = gameNum;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Board [gameNum=" + gamenum + ", title=" + title + ", content=" + content + ", hits=" + hits + "]";
	}

}
