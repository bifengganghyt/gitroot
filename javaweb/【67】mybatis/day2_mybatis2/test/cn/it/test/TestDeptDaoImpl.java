package cn.it.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.it.dao.impl.DeptDaoImpl;
import cn.it.entity.Dept;

public class TestDeptDaoImpl {
	private static DeptDaoImpl deptDaoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		deptDaoImpl = new DeptDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deptDaoImpl = null;
	}

	@Test
	public void testSave() {
		Dept dept = new Dept();
		dept.setDeptName("财务部2");
		dept.setDeptAddress("广州天河");
		System.out.println("save受影响 的行数："+deptDaoImpl.save(dept));
	}
	
	@Test
	public void testUpdate() {
		Dept dept = new Dept();
		dept.setDeptId(6);
		dept.setDeptName("秘书部3");
		dept.setDeptAddress("深圳");
		System.out.println("update受影响 的行数："+deptDaoImpl.update(dept));
	}
	
	@Test
	public void testDelete() {
		/*Dept dept = new Dept();
		dept.setDeptId(6);
		dept.setDeptName("秘书部");
		dept.setDeptAddress("深圳");*/
		System.out.println("delete受影响 的行数："+deptDaoImpl.delete(8));
	}
	
	@Test
	public void testSelectOne() {

		System.out.println("id=6的部门信息："+deptDaoImpl.selectOne(6));
	}
	
	@Test
	public void testSelectList() {
		List<Dept> depts = deptDaoImpl.selectList("%广%");
		for (Dept dept : depts) {
			System.out.println("全部部门信息："+dept);
		}
	}


}
