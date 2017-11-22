package main.ui;

import java.util.*;
import java.util.Scanner;

import human.vo.Admin;
import human.vo.Board;
import human.vo.User;
import user.service.*;

public class AdminUI {
	Admin admin;
	Board b;
	AdminDAO adao = new AdminDAO();
	Scanner scan = new Scanner(System.in);
	BoardUI2 bui= new BoardUI2();
	public AdminUI(Admin a) {
		admin = a;
	}

	public void start() {
		while (true) {
			startUI();
			String menu = scan.nextLine();

			switch (menu) {
			case "1":
				allUser();
				break;
			case "2":
				deleteUser();
				break;
			case "3":
				searchUser();
				break;
			case "4":
				insertMoney();
				break;
			case "5":
				bui.startUI();
				break;
			case "6":
				System.out.println("로그인 창");
				return;
			default:
				break;
			}
		}
	}

	private void startUI() {
		System.out.println("1. 전체 유저 출력");
		System.out.println("2. 유저 삭제");
		System.out.println("3. 유저 검색");
		System.out.println("4. 유저 돈 넣어주기");
		System.out.println("5. 리플달기");
		System.out.println("6. 종료");
		System.out.print("::: ");
	}

	private List<User> allUser() {
		List<User> ulist = adao.getUserList();
		int i = 0;
		for (User user : ulist) {
			System.out.println("["+i+"] "+user);
			i++;
		}
		return ulist;
	}

	private void deleteUser() {
		List<User> ulist = allUser();
		System.out.println("지울 번호 입력");
		int num = 0;
		try {
			num = scan.nextInt();
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("숫자만 입력");
			return;
		}
		if (num >= 0 && num < ulist.size()) {
			adao.deleteUser(ulist.get(num).getHno());
		} else {
			System.out.println("잘못된 번호");
		}
	}
	
	private void searchUser() {
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		List<User> ulist = adao.searchUser(id);
		
		if(ulist == null)
		{
			System.out.println("검색 결과 없음");
		}
		else
		{
			for (User user : ulist) {
				System.out.println(user);
			}
		}
	}
	
	private void insertMoney() {
		List<User> ulist = allUser();
		System.out.println("넣을 사람의 번호 입력");
		int num = 0;
		int money = 0;
		try {
			num = scan.nextInt();
			scan.nextLine();
			System.out.println("넣을 돈 입력");
			money = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			System.out.println("숫자만 입력");
			return;
		}
		if (num >= 0 && num < ulist.size()) {
			User user = ulist.get(num);
			user.setMoney(money + user.getMoney());
			adao.insertMoney(user);
		} else {
			System.out.println("잘못된 번호");
		}
		System.out.println();
	}
}
