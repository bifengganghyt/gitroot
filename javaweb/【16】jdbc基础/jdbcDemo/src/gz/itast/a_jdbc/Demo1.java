package gz.itast.a_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {
	//连接数据库的字符串
	// jdbc协议+数据库协议+主机地址+端口+连接的数据库
	private static String url = "jdbc:mysql://localhost:3306/day16";
	//用户名
	private static String user = "root";
	
	//密码
	private static String password = "123";
	
	public static void main(String[] args) throws Exception {
		t3();
	}
	
	/**
	 * 1)直接使用驱动程序连接
	 * @heyutong
	 * 2017年5月11日
	 * @throws SQLException
	 */
	private static void t1() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();//新版本
		//Driver driver2 = new org.gjt.mm.mysql.Driver();//旧版本
		
		Properties properties = new Properties();
		properties.setProperty("user", user);//用户名
		properties.setProperty("password", password);
		
		//2.连接数据库
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);//结果:com.mysql.jdbc.JDBC4Connection@4ab8b9     第二次:com.mysql.jdbc.JDBC4Connection@a7ff2e
		
	}
	
	/**
	 * 2)使用驱动管理类DriverManager，连接数据库
	 * @heyutong
	 * 2017年5月11日
	 * @throws SQLException
	 */
	private static void t2() throws SQLException {
		Driver driver =  new com.mysql.jdbc.Driver();//mysql
		//Driver driver2 = new com.oracle.jdbc.Driver(); //oracle
		
		//1.注册驱动程序
		DriverManager.registerDriver(driver);
		//DriverManager.registerDriver(driver2);
		
		//2.获取连接数据库
		//通过url识别需要连接数据库
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println(connection);//com.mysql.jdbc.JDBC4Connection@11f24bb   第二次:com.mysql.jdbc.JDBC4Connection@1a477b7
	}
	
	private static void t3() throws Exception {
		
		//反射：获取类的对象 执行Driver类中的静态代码块 DriverManager.registerDriver(new Driver()); 
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获取连接数据库
		//通过url识别需要连接数据库
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println(connection);//com.mysql.jdbc.JDBC4Connection@afccbe
	}
}
