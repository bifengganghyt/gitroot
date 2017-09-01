package cn.it.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.it.dao.utils.MybatisSessionFactory;
import cn.it.entity.Dept;

public class DeptDaoImpl {
	
	SqlSession sqlSession;
	
	/*
	 * 1.读取配置文件信息
	 * 2。构建session工厂
	 * 3。创建session
	 * 4.开启事务（可选）
	 * 5。处理数据
	 * 6。提交、回滚事务
	 * 7。关闭session 
	 */
	
	public int save(Dept dept) {
		int i = 0;
		try {
			sqlSession = MybatisSessionFactory.getSession();
			System.out.println("save:" + sqlSession);
			
			i = sqlSession.insert("cn.it.entity.DeptMapper.insertDept", dept);
			
			//提交事务
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			MybatisSessionFactory.closeSession();
		}
		return i;
	}
	
	public int update(Dept dept) {
		int i = 0;
		
		try {
			sqlSession = MybatisSessionFactory.getSession();
			System.out.println("update:" + sqlSession);
			i = sqlSession.update("cn.it.entity.DeptMapper.updateDept",dept);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			MybatisSessionFactory.closeSession();
		}
		return i;
	}
	
	public int delete(Integer id) {
		int i = 0;
		try {
			sqlSession = MybatisSessionFactory.getSession();
			System.out.println("delete:" + sqlSession);
			i = sqlSession.update("cn.it.entity.DeptMapper.deleteDept", id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			MybatisSessionFactory.closeSession();
		}
		
		return i;
	}
	
	//根据部门编号查询单个部门
	public Dept selectOne(Integer id){
		Dept dept =null;
		try {
			sqlSession=MybatisSessionFactory.getSession();
			dept = sqlSession.selectOne("cn.it.entity.DeptMapper.selectDept",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dept;
	}
	
	//根据部门地址查询多个部门
		public List<Dept> selectList(String deptAddress){
			List<Dept> depts =null;
			try {
				sqlSession=MybatisSessionFactory.getSession();
				depts = sqlSession.selectList("cn.it.entity.DeptMapper.selectList",deptAddress);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					MybatisSessionFactory.closeSession();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return depts;
		}
}
