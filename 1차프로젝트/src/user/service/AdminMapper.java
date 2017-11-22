package user.service;

import java.util.List;

import human.vo.Admin;
import human.vo.User;

public interface AdminMapper {
	
	//아이디 비번으로 admin 찾기 로그인 기능
	public Admin selectAdmin(Admin a);
	
	//전체 유저 출력
	public List<User> getUserList();
	
	//번호로 유저삭제
	public int deleteUser(int hno);
	
	//유저 검색
	public List<User> searchUser(String id);
	
	//돈 넣어주기
	public int insertMoney(User u);
	
}
