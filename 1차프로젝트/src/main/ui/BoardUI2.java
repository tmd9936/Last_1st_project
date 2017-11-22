package main.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import human.vo.Board;
import human.vo.Reply;
import user.service.BoardDAO;

public class BoardUI2 {

	private Scanner input;
	private BoardDAO dao;

	public BoardUI2() {
		dao = new BoardDAO();
		input = new Scanner(System.in);
	}

	public void startUI() {
		while (true) {
			System.out.println("=====�Խ���=====");
			System.out.println("1. �Խñ� �о����");
			System.out.println("2. �Խñ� ����");
			System.out.println("3. ��ü �Խñ�");
			System.out.println("4. �Խñ� ã��");
			System.out.println("0. ������");
			System.out.print("::: ");
			String menuNum = input.nextLine();

			switch (menuNum) {
			case "1":
				readBoard();
				break;
			case "2":
				this.deleteBoard();
				break;
			case "3":
				this.getBoardList();
				break;
			case "4":
				this.searchBoard();
				break;
			case "0":
				
				return;

			default:
				break;
			}// ����ġ
		} // ����
	}// �޼ҵ�

	// �Խñ� �Է�
	public void insertBoard() {
		System.out.println("==1. �Խñ� ���==");
		System.out.print("���� : ");
		String title = input.nextLine();
		System.out.print("���� : ");
		String content = input.nextLine();

		Board b = new Board(title, content);

		if (dao.insertboard(b) != 0) {
			System.out.println("success");
		} else {
			System.out.println("fail..");
		}
		return;
	}

	// �Խñ� �б�
	public void readBoard() {
		while (true) {
			System.out.println("=====�Խñ� �о����=====");
			getBoardList();
			System.out.println("1. �о����");
			System.out.println("2. ������");
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
			case "2":

				return;

			default:
				break;
			}
		}
	}

	// �Խñ� ����
	public void deleteBoard() {
		while (true) {
			System.out.println("=====�Խñ� ����=====");
			System.out.println("1. ����");
			System.out.println("0. ������");
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

	// �Խñ���ó
	public void getBoardList() {
		List<Board> list = dao.getBoardList();
		if (list != null) {
			for (Board board : list) {
				System.out.println(board);
			}

		}
	}

	// �˻�
	public void searchBoard() {
		while (true) {
			System.out.println("=====�Խñ� ã��=====");
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

	// ���� �޴�
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
