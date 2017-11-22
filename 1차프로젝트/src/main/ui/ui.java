package main.ui;

import java.util.*;

import user.service.UserDAO;
import human.vo.User;

public class ui {
	Scanner sc = new Scanner(System.in);
	LoginUi login = new LoginUi();
	UserDAO dao = new UserDAO();
	User myUser;
	

	public void print() {
		do {
			System.out.println("=====San Story=====");
			System.out.println("1. 로그인");
			System.out.println("2. 계정 생성");
			System.out.println("0. 나가기");
			System.out.print("::: ");

			String num = sc.nextLine();

			switch (num) {
			case "1":// 로그인
				login.Login();
				break;
			case "2":// 생성
				Create();
				break;
			case "777":// 관리자로그인
				new AdminLoginUI();
				break;
			case "0":
				System.out.println("Bye Bye Bye");
				return;

			default:
				break;
			}
		} while (true);
	}


	public void Create() {
		System.out.println("=====계정 생성=====");
		System.out.println("이름::: ");
		String name = sc.nextLine();
		System.out.println("주민등록번호::: ");
		String jumin = sc.nextLine();
		System.out.println("ID::: ");
		String id = sc.nextLine();
		System.out.println("PassWord::: ");
		String pass = sc.nextLine();

		try {
			User user = new User(name, jumin, id, pass);
			if (dao.MakeId(user) != 0) {
				System.out.println("생성이 완료 되었습니다");
			} else {
				System.out.println("생성에 실패 하였습니다");
			}

		} catch (Exception e) {
			System.out.println("아이디 또는 주민등록번호가 존재합니다");
		}
	}

	

	public void Admin() {
		while (true) {
			System.out.println("=====Admin Menu=====");
			System.out.println("1. Total Members");
			System.out.println("2.Delete User");
			System.out.println("3. Insert Money");
			System.out.println("0. Exit");
			System.out.print("::: ");
			String num = sc.nextLine();

			switch (num) {
			case "1":// 전체회원보기

				break;
			case "2":// 회원삭제

				break;
			case "3":// 돈넣기

				break;
			case "0":

				return;

			default:
				break;
			}

		}
	}
}
