package gz.itast.c_prepared;

import gz.itast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用PreparedStatement执行CRUD操作
 * 执行预编译的sql语句
 * @author S43W
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//insert();
		
		//update();
				
		delete();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//1)获取连接
			connection = JdbcUtil.getConnection();
			//2)准备sql
			// ？号是参数的占位符.一个问号代表一个参数.
			String sql = "select * from student where id=?";
			//3)创建PreparedStatement，预编译sql语句
			//预编译sql语句（sql语法和权限的检查）
			preparedStatement = connection.prepareStatement(sql);
			//4)给参数赋值
			/**
			 * 参数一：参数的位置。从1开始
			 * 参数二：参数值
			 * 注意：如果没有参数，则不需要赋值。
			 */
			preparedStatement.setInt(1, 4);
			resultSet = preparedStatement.executeQuery();
			
			//遍历结果集
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				System.out.println(id+"\t"+name+"\t"+age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			JdbcUtil.close(resultSet, preparedStatement, connection);
		}
	}
	
	private static void insert() {
		//插入
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		//1)获取连接
		connection = JdbcUtil.getConnection();
		//2)准备sql
		// ？号是参数的占位符.一个问号代表一个参数.
		String sql = "insert into student(id,name,age) values(?,?,?)";
		//3)创建PreparedStatement，预编译sql语句
		
		preparedStatement = connection.prepareStatement(sql);
		
		//4)给参数赋值
		/**
		 * 参数一：参数的位置。从1开始
		 * 参数二：参数值
		 */
		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "李四");
		preparedStatement.setInt(3, 40);
		//4)发送参数到数据库，执行sql
		int count = preparedStatement.executeUpdate();
		System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关注资源
			JdbcUtil.close(preparedStatement, connection);
		}
	}
	
	private static void update() {
		/**
		 * 修改
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//1)获取连接
			conn = JdbcUtil.getConnection();
			//2)准备sql
			String sql = "update student set name=?,age=? where id=?"; // ？号是参数的占位符.一个问号代表一个参数.
			//3)创建PreparedStatement，预编译sql语句
			stmt = conn.prepareStatement(sql); //预编译sql语句（sql语法和权限的检查）
			//4)给参数赋值
			/**
			 * 参数一：参数的位置。从1开始
			 * 参数二：参数值
			 * 注意：参数的位置一定要对应字段的位置
			 */
			stmt.setString(1, "王五");
			stmt.setInt(2, 50);
			stmt.setInt(3, 5);
			//4)发送参数到数据库，执行sql
			int count = stmt.executeUpdate();
			System.out.println("影响了"+count+"行");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关注资源
			JdbcUtil.close(stmt, conn);
		}
	}
	
	private static void delete() {
		//删除
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		//1)获取连接
		connection = JdbcUtil.getConnection();
		//2)准备sql
		// ？号是参数的占位符.一个问号代表一个参数.
		String sql = "delete from student where id=?";
		//3)创建PreparedStatement，预编译sql语句
		preparedStatement = connection.prepareStatement(sql);//预编译sql语句（sql语法和权限的检查）
		//4)给参数赋值	
		/**
		 * 参数一：参数的位置。从1开始
		 * 参数二：参数值
		 * 注意：参数的位置一定要对应字段的位置
		 */
		preparedStatement.setInt(1, 5);
		//4)发送参数到数据库，执行sql
		int count = preparedStatement.executeUpdate();
		System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(preparedStatement, connection);
		}
	}
	
}
