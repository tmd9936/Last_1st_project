package user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import human.vo.Admin;
import human.vo.User;

public class AdminDAO implements AdminMapper{
	
	public static void main(String[] args)
	{
		AdminDAO dao = new AdminDAO();
//		Admin a = new Admin("admin", "admin"); 
//		Admin a2 = dao.selectAdmin(a);
//		System.out.println(a2.getId()+ " "+ a2.getPass());
		
//		List<User> ulist = dao.getUserList();
//		
//		for (User user : ulist) {
//			System.out.println(user);
//		}
		
		//int result = dao.deleteUser(8);
		List<User> ulist2 = dao.searchUser("tmd2");
		
		
		User user = ulist2.get(0);
		user.setMoney(user.getMoney()+10000);
		
		dao.insertMoney(user);
		
		
		System.out.println("end");  
	}
	
	private SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();
	@Override
	public Admin selectAdmin(Admin a) {
		SqlSession session = factory.openSession();
		AdminMapper am = session.getMapper(AdminMapper.class);
		
		Admin admin = null;
		
		try {
			admin = am.selectAdmin(a);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return admin;
	}

	@Override
	public List<User> getUserList() {
		SqlSession session = factory.openSession();
		AdminMapper am = session.getMapper(AdminMapper.class);
		
		List<User> ulist = null;
		try {
			ulist = am.getUserList();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		return ulist;
	}

	@Override
	public int deleteUser(int hno) {
		SqlSession session = factory.openSession();
		AdminMapper am = session.getMapper(AdminMapper.class);
		
		int result = 0;
		
		try {
			result = am.deleteUser(hno);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}
	
	@Override
	public List<User> searchUser(String id)
	{
		SqlSession session = factory.openSession();
		AdminMapper am = session.getMapper(AdminMapper.class);
		
		List<User> ulist = null;
		try {
			ulist = am.searchUser(id);
		} catch (Exception e) {
			session.close();
			// TODO: handle exception
		}
		
		return ulist;
	}

	@Override
	public int insertMoney(User u) {
		SqlSession session = factory.openSession();
		AdminMapper am = session.getMapper(AdminMapper.class);
		
		int result = 0;
		try {
			result = am.insertMoney(u);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

}
