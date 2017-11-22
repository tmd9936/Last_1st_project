package main.ui;
import java.util.*;
import human.vo.User;
import user.service.UserDAO;

public class LoginUi {
	
	Scanner sc = new Scanner(System.in);
	UserDAO dao = new UserDAO();
	public void Login() {
		while (true) {
			User user = new User();
			System.out.println("ID::: ");
			String id = sc.nextLine();
			System.out.println("PASSWORD::: ");
			String pass = sc.nextLine();

			user.setId(id);
			user.setPass(pass);
			User u1 = null;
			u1 = dao.Login(user);
			if(u1 == null) {
				System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
				return;
			}
			//�� u1�� user�� ������� �մϴ�.
			userUI userui = new userUI(u1);
			userui.UserMenu();
		}
	}
}

