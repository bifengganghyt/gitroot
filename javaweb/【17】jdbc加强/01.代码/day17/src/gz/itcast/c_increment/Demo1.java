package gz.itcast.c_increment;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 使用jdbc获取自增长的值
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			/**
			 * 同时插入一个部门和该部门所在的员工的数据
			 */
			String deptSql = "insert into dept(name) values(?)";
			String empSql = "insert into employee(name,deptId) values(?,?)";
			
			/**
			 * 如果获取自增长的生成的值???
			 * 1）设置是否可以返回自增长的值
			 *    RETURN_GENERATED_KEYS: 可以返回自增长生成值
			 *    NO_GENERATED_KEYS:不能返回自增长的值
			 */
			stmt = conn.prepareStatement(deptSql,Statement.RETURN_GENERATED_KEYS);
			//参数赋值
			stmt.setString(1, "软件维护部");
			//执行插入部门的sql
			stmt.executeUpdate();
			
			/**
			 * 2）获取自增长的值
			 *    注意： 该ResultSet只包含了自增长的字段
			 */
			rs = stmt.getGeneratedKeys();
			int deptId = 0;
			if(rs.next()){
				deptId = rs.getInt(1);
			}
			
			stmt = conn.prepareStatement(empSql);
			stmt.setString(1, "李四");
			stmt.setInt(2, deptId);
			//执行插入员工的sql
			stmt.executeUpdate();
			System.out.println("添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

}
