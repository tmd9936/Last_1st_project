package user.service;

import human.vo.User;

public interface UserMapper {

	//�����
	public int MakeId(User u);
	//��������z
	public User MyInfo(int hno);
	//���ֱ�
	public int InsertMoney(User u);
	//���̵� ����
	public int DeleteID(String jumin);
	//�α���
	public User Login(User u);
	//����

}
