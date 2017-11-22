package user.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import human.vo.User;

public class UserDAO implements UserMapper {

	/*public static void main(String[] args) {


			User u = new User("tt2","tt2","tt2","tt2");

			UserDAO dao = new UserDAO();

			//dao.MakeId(u);
			
			//dao.DeleteID("931002");
			
			//System.out.println(dao.MyInfo(2));
			int m = u.getMoney()+10000;
			u.setMoney(m);
			dao.InsertMoney(u);
			
			System.out.println("send");
		

	}*/

	private SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();

	@Override
	public int MakeId(User u) {
		SqlSession session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			result = um.MakeId(u);
			session.commit();
		} finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public User MyInfo(int hno) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		User result = null;
		try {
			result = um.MyInfo(hno);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		return result;
	}

	@Override
	public int InsertMoney(User u) {
		SqlSession session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			result = um.InsertMoney(u);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int DeleteID(String jumin) {
		SqlSession session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			result = um.DeleteID(jumin);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public User Login(User u) {
		SqlSession session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		User result = null;
		try {
			result = um.Login(u);
		} finally {
			session.close();
		}
		return result;
	}

}
