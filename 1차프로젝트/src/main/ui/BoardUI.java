package main.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import human.vo.Board;
import human.vo.Reply;
import user.service.BoardDAO;

public class BoardUI {

	private Scanner input;
	private BoardDAO dao;

	public BoardUI() {
		dao = new BoardDAO();
		input = new Scanner(System.in);
	}

	public void startUI() {
		while (true) {
			System.out.println("==board main menu==");
			System.out.println("1.insert board");
			System.out.println("2. read board");
			System.out.println("3.delete board");
			System.out.println("4.board list");
			System.out.println("5.search board");
			System.out.println("0.exit");
			System.out.print("::: ");
			String menuNum = input.nextLine();

			switch (menuNum) {
			case "1":
				this.insertBoard();
				break;
			case "2":
				readBoard();
				break;
			case "3":
				this.deleteBoard();
				break;
			case "4":
				this.getBoardList();
				break;
			case "5":
				this.searchBoard();
				break;
			case "0":
				
				return;

			default:
				break;
			}// 스위치
		} // 와일
	}// 메소드

	// 게시글 입력
	public void insertBoard() {
		System.out.println("==1. insert board menu==");
		System.out.print("title: ");
		String title = input.nextLine();
		System.out.print("content: ");
		String content = input.nextLine();

		Board b = new Board(title, content);

		if (dao.insertboard(b) != 0) {
			System.out.println("success");
		} else {
			System.out.println("fail..");
		}
		return;
	}

	// 게시글 읽기
	public void readBoard() {
		while (true) {
			System.out.println("==read board menu==");
			getBoardList();
			System.out.println("1.read board");
			System.out.println("0.upper menu");
			System.out.print("::: ");
			String mNum = input.nextLine();

			switch (mNum) {
			case "1":
				System.out.print("boardnum:: ");
				int boardnum = input.nextInt();
				input.nextLine();
				Board b = dao.readboard(boardnum);
				if (b != null) {
					dao.addhits(boardnum);
					System.out.println(b);
					replyMenu(b);
				} else {
					System.out.println("fail...");
				}

				break;
			case "0":

				return;

			default:
				break;
			}
		}
	}

	// 게시글 삭제
	public void deleteBoard() {
		while (true) {
			System.out.println("==3. delete board menu==");
			System.out.println("1.delete");
			System.out.println("0.upper menu");
			System.out.print("::: ");
			String mNum = input.nextLine();
			switch (mNum) {
			case "1":
				System.out.println("boardnum[del]");
				int boardNum = input.nextInt();
				input.nextLine();
				if (dao.deleteboard(boardNum) != 0) {
					System.out.println("delete success");
				} else {
					System.out.println("delete fail..");
				}
				break;
			case "0":

				return;

			default:
				break;
			}
		}
	}

	// 게시글젠처
	public void getBoardList() {
		List<Board> list = dao.getBoardList();
		if (list != null) {
			for (Board board : list) {
				System.out.println(board);
			}

		}
	}

	// 검색
	public void searchBoard() {
		while (true) {
			System.out.println("==5. search menu");
			System.out.println("1. insert type 1(1.title/2. content)");
			System.out.println("0.upper menu");
			System.out.print("::: ");
			String col = input.nextLine();

			switch (col) {
			case "1":
				System.out.println("search keyword");
				String word = input.nextLine();

				Map<String, Object> map = new HashMap<>();
				map.put("col", col);
				map.put("word", word);

				List<Board> list = dao.searchboard(map);
				if (list != null) {
					for (Board board : list) {
						System.out.println(board);

					}
				}
			case "0":
				
			return;
			default:
				break;
			}
		}
	}

	// 리플 메뉴
	public void replyMenu(Board b) {
		List<Reply> r = dao.getReplyList(b.getGameNum());
		if (r != null) {
			for (Reply reply : r) {
				System.out.println(reply);
			}
		}
		insertreply(b);
	}

	public void insertreply(Board b) {
		while (true) {
			System.out.println("1.insert");
			System.out.println("0.upper");
			System.out.print("::: ");
			String num = input.nextLine();
			switch (num) {
			case "1":
				System.out.println("content: ");
				String content = input.nextLine();
				Reply r = new Reply(b.getGameNum(), content);
				if (dao.insertreply(r) != 0) {
					System.out.println("insert reply");
				} else {
					System.out.println("fail");
				}
				break;
			case "0":
				return;
			default:
				break;
			}
		}
	}

}
