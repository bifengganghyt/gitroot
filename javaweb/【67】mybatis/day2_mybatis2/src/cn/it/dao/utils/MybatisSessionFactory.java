package cn.it.dao.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private static final String CONFIG_FILE_LOCATION = "mybatis-config.xml";
	
	private MybatisSessionFactory(){
	}
	
	static {
		buildSessionFactory();
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static void buildSessionFactory() {
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader(CONFIG_FILE_LOCATION);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static SqlSession getSession() throws Exception {
		SqlSession sqlSession = (SqlSession)threadLocal.get();
		
		if(sqlSession == null) {
			if(sqlSessionFactory == null) {
				buildSessionFactory();
			}
			
			sqlSession = (sqlSessionFactory != null) ? sqlSessionFactory.openSession() : null;
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	
	public static void closeSession() {
		SqlSession sqlSession = (SqlSession)threadLocal.get();
		threadLocal.set(null);
		
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
}
