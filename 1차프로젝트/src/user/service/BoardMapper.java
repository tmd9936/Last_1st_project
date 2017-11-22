package user.service;

import java.util.*;

import human.vo.Board;
import human.vo.Reply;

public interface BoardMapper {

	// 등록
	public int insertboard(Board b);

	// 읽기
	public Board readboard(int gamenum);

	// 증가
	public int addhits(int gamenum);

	// 삭제
	public int deleteboard(int gamenum);

	// 전체목록
	public List<Board> getBoardList();

	// 검색
	public List<Board> searchboard(Map<String, Object> map);

	// 댓글등록
	public int insertreply(Reply r);

	// 가져오기
	public List<Reply> getReplyList(int gamenum);

}
