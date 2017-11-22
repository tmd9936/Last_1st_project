package user.service;

import java.util.List;

import human.vo.Admin;
import human.vo.User;

public interface AdminMapper {
	
	//���̵� ������� admin ã�� �α��� ���
	public Admin selectAdmin(Admin a);
	
	//��ü ���� ���
	public List<User> getUserList();
	
	//��ȣ�� ��������
	public int deleteUser(int hno);
	
	//���� �˻�
	public List<User> searchUser(String id);
	
	//�� �־��ֱ�
	public int insertMoney(User u);
	
}
