package main.ui;

import java.util.*;

import human.vo.Admin;
import user.service.*;

public class AdminLoginUI {
	Scanner scan = new Scanner(System.in);
	AdminDAO adao = new AdminDAO();

	public AdminLoginUI() {
		while (true) {
			System.out.println("1. 로그인");
			System.out.println("0. 종료");
			System.out.print("::: ");
			String key = scan.nextLine();
			switch (key) {
			case "1":
				login();
				break;
			case "0":
				return;
			default:
				System.out.println("없는 메뉴!");
				break;
			}
			
			
		}
	}
	private void login() {
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pass = scan.nextLine();

		Admin cAdmin = new Admin();

		cAdmin.setId(id);
		cAdmin.setPass(pass);

		Admin loginAdmin = adao.selectAdmin(cAdmin);

		if (loginAdmin != null)
			new AdminUI(loginAdmin).start();
		else
			System.out.println("실패");
	}
}
