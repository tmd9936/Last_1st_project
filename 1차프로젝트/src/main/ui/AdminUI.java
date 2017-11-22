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
				System.out.println("�α��� â");
				return;
			default:
				break;
			}
		}
	}

	private void startUI() {
		System.out.println("1. ��ü ���� ���");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� �˻�");
		System.out.println("4. ���� �� �־��ֱ�");
		System.out.println("5. ���ôޱ�");
		System.out.println("6. ����");
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
		System.out.println("���� ��ȣ �Է�");
		int num = 0;
		try {
			num = scan.nextInt();
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("���ڸ� �Է�");
			return;
		}
		if (num >= 0 && num < ulist.size()) {
			adao.deleteUser(ulist.get(num).getHno());
		} else {
			System.out.println("�߸��� ��ȣ");
		}
	}
	
	private void searchUser() {
		System.out.print("���̵� : ");
		String id = scan.nextLine();
		
		List<User> ulist = adao.searchUser(id);
		
		if(ulist == null)
		{
			System.out.println("�˻� ��� ����");
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
		System.out.println("���� ����� ��ȣ �Է�");
		int num = 0;
		int money = 0;
		try {
			num = scan.nextInt();
			scan.nextLine();
			System.out.println("���� �� �Է�");
			money = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			System.out.println("���ڸ� �Է�");
			return;
		}
		if (num >= 0 && num < ulist.size()) {
			User user = ulist.get(num);
			user.setMoney(money + user.getMoney());
			adao.insertMoney(user);
		} else {
			System.out.println("�߸��� ��ȣ");
		}
		System.out.println();
	}
}
