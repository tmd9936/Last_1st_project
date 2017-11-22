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
			System.out.println("1. �α���");
			System.out.println("2. ���� ����");
			System.out.println("0. ������");
			System.out.print("::: ");

			String num = sc.nextLine();

			switch (num) {
			case "1":// �α���
				login.Login();
				break;
			case "2":// ����
				Create();
				break;
			case "777":// �����ڷα���
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
		System.out.println("=====���� ����=====");
		System.out.println("�̸�::: ");
		String name = sc.nextLine();
		System.out.println("�ֹε�Ϲ�ȣ::: ");
		String jumin = sc.nextLine();
		System.out.println("ID::: ");
		String id = sc.nextLine();
		System.out.println("PassWord::: ");
		String pass = sc.nextLine();

		try {
			User user = new User(name, jumin, id, pass);
			if (dao.MakeId(user) != 0) {
				System.out.println("������ �Ϸ� �Ǿ����ϴ�");
			} else {
				System.out.println("������ ���� �Ͽ����ϴ�");
			}

		} catch (Exception e) {
			System.out.println("���̵� �Ǵ� �ֹε�Ϲ�ȣ�� �����մϴ�");
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
			case "1":// ��üȸ������

				break;
			case "2":// ȸ������

				break;
			case "3":// ���ֱ�

				break;
			case "0":

				return;

			default:
				break;
			}

		}
	}
}
