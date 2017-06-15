package gz.itast.b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 使用Statemeent对象执行DML语句（insert/update/delete）
 * @heyutong
 * 2017年5月11日
 */
public class Demo2 {
	//url
	private static String url = "jdbc:mysql://localhost:3306/day16?useUnicode=true&characterEncoding=UTF-8";
	//user
	private static String user = "root";
	//password
	private static String password = "123";
	
	public static void main(String[] args) throws Exception {
		testInsert();
		testUpdate();
		testDelete();
	}
	
	private static void testInsert() throws Exception {
		//1）注册驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2)获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)准备sql
		String sql = "INSERT INTO student(id,NAME,age) VALUES(2,'李四',30)";
		//4)创建Statement对象
		Statement statement = connection.createStatement();
		//5)执行sql
		int count = statement.executeUpdate(sql);
		System.out.println("影响了"+count+"行");//影响了1行
		//6)关闭资源
		statement.close();
		connection.close();
	}
	
	private static void testUpdate() throws Exception {
		//1）注册驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2)获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)准备sql
		/*String sql = "update student set NAME='陈六',age=50 where id=2";*/
		String sql = "UPDATE student SET NAME='陈六',age=50 WHERE id=2";
		//4)创建Statement对象
		Statement statement = connection.createStatement();
		//5)执行sql
		int count = statement.executeUpdate(sql);
		System.out.println("影响了"+count+"行");
		//6)关闭资源
		statement.close();
		connection.close();
	}
	
	private static void testDelete() throws Exception {
		//1）注册驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				//2)获取连接
				Connection conn = DriverManager.getConnection(url, user, password);
				//3)准备sql
				String sql = "DELETE FROM student WHERE id=2";
				//4)创建Statement对象
				Statement stmt = conn.createStatement();
				//5)执行sql
				int count = stmt.executeUpdate(sql);
				System.out.println("影响了"+count+"行");
				//6)关闭资源
				stmt.close();
				conn.close();
	}
	
	
}
