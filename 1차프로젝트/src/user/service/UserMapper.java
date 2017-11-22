package user.service;

import human.vo.User;

public interface UserMapper {

	//만들기
	public int MakeId(User u);
	//정보보기z
	public User MyInfo(int hno);
	//돈넣기
	public int InsertMoney(User u);
	//아이디 삭제
	public int DeleteID(String jumin);
	//로그인
	public User Login(User u);
	//배팅

}
