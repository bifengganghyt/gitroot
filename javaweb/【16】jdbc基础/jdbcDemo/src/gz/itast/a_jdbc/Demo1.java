package gz.itast.a_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {
	//�������ݿ���ַ���
	// jdbcЭ��+���ݿ�Э��+������ַ+�˿�+���ӵ����ݿ�
	private static String url = "jdbc:mysql://localhost:3306/day16";
	//�û���
	private static String user = "root";
	
	//����
	private static String password = "123";
	
	public static void main(String[] args) throws Exception {
		t3();
	}
	
	/**
	 * 1)ֱ��ʹ��������������
	 * @heyutong
	 * 2017��5��11��
	 * @throws SQLException
	 */
	private static void t1() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();//�°汾
		//Driver driver2 = new org.gjt.mm.mysql.Driver();//�ɰ汾
		
		Properties properties = new Properties();
		properties.setProperty("user", user);//�û���
		properties.setProperty("password", password);
		
		//2.�������ݿ�
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);//���:com.mysql.jdbc.JDBC4Connection@4ab8b9     �ڶ���:com.mysql.jdbc.JDBC4Connection@a7ff2e
		
	}
	
	/**
	 * 2)ʹ������������DriverManager���������ݿ�
	 * @heyutong
	 * 2017��5��11��
	 * @throws SQLException
	 */
	private static void t2() throws SQLException {
		Driver driver =  new com.mysql.jdbc.Driver();//mysql
		//Driver driver2 = new com.oracle.jdbc.Driver(); //oracle
		
		//1.ע����������
		DriverManager.registerDriver(driver);
		//DriverManager.registerDriver(driver2);
		
		//2.��ȡ�������ݿ�
		//ͨ��urlʶ����Ҫ�������ݿ�
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println(connection);//com.mysql.jdbc.JDBC4Connection@11f24bb   �ڶ���:com.mysql.jdbc.JDBC4Connection@1a477b7
	}
	
	private static void t3() throws Exception {
		
		//���䣺��ȡ��Ķ��� ִ��Driver���еľ�̬����� DriverManager.registerDriver(new Driver()); 
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.��ȡ�������ݿ�
		//ͨ��urlʶ����Ҫ�������ݿ�
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println(connection);//com.mysql.jdbc.JDBC4Connection@afccbe
	}
}
