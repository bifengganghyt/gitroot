package gz.itcast.dao;

import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;
import gz.itcast.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DeptDao {	
	/**
	 * 根据条件查询部门
	 * @param args
	 */
	public List<Department> findByCondition(DeptQuery query){
		try {
			//根据查询条件拼凑一条sql语句
			StringBuffer sql = new StringBuffer("select * from department where 1=1 ");
			if(query!=null){
				//部门名称不为空，则往sql添加条件(trim():去掉两边空格)
				if(query.getDeptName()!=null && !query.getDeptName().trim().equals("")){
					sql.append(" and deptName like '%"+query.getDeptName()+"%'");
				}
				//负责人
				if(query.getPrincipal()!=null && !query.getPrincipal().trim().equals("")){
					sql.append(" and principal like '%"+query.getPrincipal()+"%'");
				}
				//职能
				if(query.getFunctional()!=null && !query.getFunctional().trim().equals("")){
					sql.append(" and functional like '%"+query.getFunctional()+"%'");
				}
			}
			System.out.println(sql.toString());
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Department>)qr.query(sql.toString(), new BeanListHandler(Department.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
