package gz.itast.b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 使用Statement接口执行DDL语句(create/drop/alter)
 * @heyutong
 * 2017年5月11日
 */
public class Demo1 {
	//url
	private static String url = "jdbc:mysql://localhost:3306/day16";
	//user
	private static String user = "root";
	//password
	private static String password = "123";
	
	/**
	 * 使用Statement接口执行DDL语句(create/drop/alter)
	 * @heyutong
	 * 2017年5月11日
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//1)注册驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2)获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)准备sql语句
		String sql = "CREATE TABLE student(id INT, NAME VARCHAR(20), age INT)";
		//4)在连接基础上，创建Statement
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(sql);// 执行DDL和DML语句（更新sql语句）
		System.out.println("影响了"+count+"行！");//结果:影响了0行！
		//6)关闭资源.后打开的先关闭
		statement.close();
		connection.close();
	}
}
