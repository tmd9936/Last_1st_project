package user.service;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sqlSessionFactory 인스턴스를 하나 생성하고
//sqlSession을 반환해주는 유틸클래스
public class MyBatisconfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			String resource = "mybatis-config.xml";
			Reader reader; //파일 읽어오는 객체
			try {
				reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory =
						new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
}
