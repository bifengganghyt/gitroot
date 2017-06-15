package gz.itast.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	//url
	private static String url = null;
	//user
	private static String user = null;
	//password
	private static String password = null;
	//����������
	private static String driverClass = null;
	//ֻע��һ�Σ���̬�����
	static {
		try {
		//ע����������
		/**
		 * ��ȡjdbc.properties�ļ�
		 */
		//1)����Properties����
		Properties properties = new Properties();
		//����������
		/**
		 * ���·����  .  ��������ǰĿ¼����ǰĿ¼��������java�������е�Ŀ¼
		 * java��Ŀ��  ��ecplise�У���ǰĿ¼ָ����Ŀ�ĸ�Ŀ¼��
		 * web��Ŀ�� ��ǰĿ¼ָ��%tomcat%/binĿ¼
		 *   1)���ۣ� ��web��Ŀ����ʹ�����·��
		 *   web��Ŀ�м��������ļ��� ServletContext.getRealPath()  /  getResourceAsStream() ���ַ�ʽ����jdbcUtil������߶��ԣ��ŵ�java��Ŀ���Ҳ���ServletContext���󣬲�ͨ�õģ�
		 *   2)����ʹ��ServletContext��ȡ�ļ�
		 *   3��ʹ����·����ʽ��ȡ�����ļ�
		 */
		//1)��ȡ��Ķ���
		Class clazz = JdbcUtil.class;
		//2) ʹ����·���Ķ�ȡ����ȥ��ȡ�ļ�
	    /**
	     * ���б�ܣ�������Ŀ����·���ĸ�Ŀ¼��  ��·���� ��ѯ���Ŀ¼/·��
	     *   java��Ŀ�£� ��·���ĸ�Ŀ¼��ָ����Ŀ��binĿ¼
	     *   web��Ŀ�£���·���ĸ�Ŀ¼��ָ����Ŀ��WEB-INF/classesĿ¼
	     *   ֻ�а������ļ�����srcĿ¼�ĸ�Ŀ¼�£���ô��Щ�ļ��ͻ��Զ���������Ŀ����·����Ŀ¼�¡�
	     */
		InputStream in = clazz.getResourceAsStream("/jdbc.properties");
		
		//����������
		//InputStream in = new FileInputStream("./src/jdbc.properties");
		//2)�����ļ�
		
			properties.load(in);
			//3)��ȡ�ļ�����
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
			
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
			System.out.println(driverClass);
			
			Class.forName(driverClass);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ӷ���
	 * @heyutong
	 * 2017��5��11��
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * �ͷ���Դ�ķ���
	 * @heyutong
	 * 2017��5��11��
	 * @param statement
	 * @param connection
	 */
	public static void close(Statement statement,Connection connection){
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		if(connection!= null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
	}
	
	/**
	 * �ͷ���Դ�ķ���
	 * @heyutong
	 * 2017��5��11��
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	

}
