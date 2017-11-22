package user.service;

import java.util.*;

import human.vo.Board;
import human.vo.Reply;

public interface BoardMapper {

	// ���
	public int insertboard(Board b);

	// �б�
	public Board readboard(int gamenum);

	// ����
	public int addhits(int gamenum);

	// ����
	public int deleteboard(int gamenum);

	// ��ü���
	public List<Board> getBoardList();

	// �˻�
	public List<Board> searchboard(Map<String, Object> map);

	// ��۵��
	public int insertreply(Reply r);

	// ��������
	public List<Reply> getReplyList(int gamenum);

}
