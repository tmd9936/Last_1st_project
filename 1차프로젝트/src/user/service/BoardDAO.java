package user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import human.vo.Board;
import human.vo.Reply;

public class BoardDAO implements BoardMapper {

	public static void main(String[] args) {

		//등록 테스트
		/*Board b = new Board("ddd", "ddd");
		BoardDAO dao = new BoardDAO();

		dao.insertboard(b);*/
		
		//읽기
		//System.out.println(dao.readboard(1));
		
		//삭제
		//dao.deleteboard(1);
		
		//전체보기
		Board b = new Board();
		BoardDAO dao = new BoardDAO();
		
		dao.getBoardList();
		
		System.out.println("end");			

	}

	private SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();

	@Override
	public int insertboard(Board b) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = bm.insertboard(b);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Board readboard(int gamenum) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		Board result = null;
		try {
			result = bm.readboard(gamenum);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int addhits(int gamenum) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = bm.addhits(gamenum);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int deleteboard(int gamenum) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = bm.deleteboard(gamenum);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Board> getBoardList() {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		List<Board> b = null;
		try {
			b = bm.getBoardList();
			session.commit();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public List<Board> searchboard(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		List<Board> b = null;
		try {
			b = bm.searchboard(map);
			session.commit();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public int insertreply(Reply r) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = bm.insertreply(r);
			session.commit();
		} finally {
			session.close();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public List<Reply> getReplyList(int gamenum) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		List<Reply> r = null;
		try {
			r = bm.getReplyList(gamenum);
			session.commit();
		} finally {
			session.close();
		}
		return r;
	}

}
