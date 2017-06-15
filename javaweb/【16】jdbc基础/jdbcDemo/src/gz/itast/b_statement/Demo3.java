package gz.itast.b_statement;

import gz.itast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class Demo3 {
	private static void ddl() {
		Statement stmt = null;
		Connection conn = null;
		try {
			//1)获取连接
			conn = JdbcUtil.getConnection();
			//2)准备sql
			String sql = "CREATE TABLE employee( "+
							"id INT PRIMARY KEY AUTO_INCREMENT,"+
							"NAME VARCHAR(20),"+
							"gender VARCHAR(2),"+
							"age INT,"+
							"title VARCHAR(20),"+
							"email VARCHAR(50),"+
							"phone VARCHAR(11)"+
							")";
			//3)创建Statement对象
			stmt = conn.createStatement();
			//4)执行sql
			int count = stmt.executeUpdate(sql);
			System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)关闭资源
			JdbcUtil.close(stmt, conn);
		}
	}
	
	private static void insert() {
		Statement statement = null;
		Connection connection = null;
		
		//模拟用户输入的数据
		String name = "李四";
		String gender = "女";
		int age = 40;
		String title = "软件维护工程师";
		String email = "lisi@qq.com";
		String phone = "13522223333";
		
		connection = JdbcUtil.getConnection();
		//2)准备sql
		String sql = "INSERT INTO employee(NAME,gender,age,title,email,phone) VALUES('"+name+"','"+gender+"',"+age+",'"+title+"','"+email+"','"+phone+"')";
		System.out.println(sql);
		//3)创建Statement对象
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5)关闭资源
			JdbcUtil.close(statement, connection);
		}
	}
	
	private static void update() {
		Statement stmt = null;
		Connection conn = null;
		
		//模拟用户输入的数据
		String name = "李四";
		String gender = "女";
		int age = 40;
		String title = "软件维护工程师";
		String email = "lisi@qq.com";
		String phone = "13522223333";
		int id = 1;
		
		try {
			//1)获取连接
			conn = JdbcUtil.getConnection();
			//2)准备sql
			String sql = "UPDATE employee SET NAME='"+name+"',gender='"+gender+"',age="+age+",title='"+title+"',email='"+email+"',phone='"+phone+"' WHERE id="+id+"";
			
			System.out.println(sql);
			
			//3)创建Statement对象
			stmt =conn.createStatement();
			//4)执行sql
			int count = stmt.executeUpdate(sql);
			System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)关闭资源
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		//ddl();
		//insert();
		//update();
		delete();
		
	}
	
	private static void delete() {
		Statement stmt = null;
		Connection conn = null;
		//模拟用户输入的数据
		int id = 1;
		
		try {
			//1)获取连接
			conn = JdbcUtil.getConnection();
			//2)准备sql
			String sql = "delete from employee where id="+id+"";
			
			System.out.println(sql);
			
			//3)创建Statement对象
			stmt = conn.createStatement();
			//4)执行sql
			int count = stmt.executeUpdate(sql);
			System.out.println("影响了"+count+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)关闭资源
			JdbcUtil.close(stmt, conn);
		}
	}
}
