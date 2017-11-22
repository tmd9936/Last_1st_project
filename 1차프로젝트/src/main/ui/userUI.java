package main.ui;

import java.util.*;

import frameText.HorseFrame;
import frameText.OOEFrame;
import human.vo.User;
import user.service.UserDAO;

public class userUI {
	Scanner sc = new Scanner(System.in);
	BoardUI board = new BoardUI();
	UserDAO dao = new UserDAO();
	ui ui = new ui();
	// Manager ma = new Manager();

	User user;
	int betting;
	public userUI(User u) {
		user = u;
	}

	public void UserMenu() {

		while (true) {
			System.out.println("=====User List=====");
			System.out.println("1. Game Select");
			System.out.println("2. My Info");
			System.out.println("3. Insert Money");
			System.out.println("4. bulletin board");
			System.out.println("5. Delete ID");
			System.out.println("0. Upper Menu");
			String num = sc.nextLine();

			switch (num) {
			case "1":// 게임
				 Gameselete();
				break;
			case "2":// 회원정보
				System.out.println(user);
				break;
			case "3":// 돈넣기
				insertmoney();
				break;
			case "4"://게시판
				board.startUI(); 
				break;
			case "5":// 회원탈퇴
				System.out.println("Jumin::: ");
				String jumin = sc.next();
				sc.nextLine();
				if (user.getJumin().equals(jumin)) {
					dao.DeleteID(user.getJumin());
					System.out.println("success");
				} else {
					System.out.println("fail...");
					continue;
				}
				return;
			case "0":
				ui.print();
				return;

			default:
				break;
			}
		}
	}

	public void insertmoney() {
		System.out.println("Money::: ");
		int money = sc.nextInt();
		sc.nextLine();
		int m = user.getMoney() + money;
		user.setMoney(m);
		dao.InsertMoney(user);
	}

	public void Gameselete() {
		do {
			System.out.println("1. horse racing");
			System.out.println("2. Odd or Even");
			System.out.println("0. Upper Menu");
			String num = sc.nextLine();

			switch (num) {
			case "1":				
				HorseFrame frame = new HorseFrame(user);
				/*while(true)
				{
					System.out.println("시스템");
					String s = sc.nextLine();
					System.out.println(s);
				}*/
				break;
			case "2":
				
					System.out.println("걸어:::");
					betting = sc.nextInt();
					sc.nextLine();
					if (user.getMoney() - betting < 0) {
						System.out.println("Don't have money.");
						return ;
					} else {
						user.setMoney(user.getMoney() - betting);
						UserDAO dao = new UserDAO();
						dao.InsertMoney(user);
						new OOEFrame(user, betting);
					}
				break;
			case "0":

				return;

			default:
				break;
			}
		} while (true);
	}
}
