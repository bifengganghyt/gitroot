package gz.itast.b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ʹ��Statemeent����ִ��DML��䣨insert/update/delete��
 * @heyutong
 * 2017��5��11��
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
		//1��ע����������
		Class.forName("com.mysql.jdbc.Driver");
		//2)��ȡ����
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)׼��sql
		String sql = "INSERT INTO student(id,NAME,age) VALUES(2,'����',30)";
		//4)����Statement����
		Statement statement = connection.createStatement();
		//5)ִ��sql
		int count = statement.executeUpdate(sql);
		System.out.println("Ӱ����"+count+"��");//Ӱ����1��
		//6)�ر���Դ
		statement.close();
		connection.close();
	}
	
	private static void testUpdate() throws Exception {
		//1��ע����������
		Class.forName("com.mysql.jdbc.Driver");
		//2)��ȡ����
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)׼��sql
		/*String sql = "update student set NAME='����',age=50 where id=2";*/
		String sql = "UPDATE student SET NAME='����',age=50 WHERE id=2";
		//4)����Statement����
		Statement statement = connection.createStatement();
		//5)ִ��sql
		int count = statement.executeUpdate(sql);
		System.out.println("Ӱ����"+count+"��");
		//6)�ر���Դ
		statement.close();
		connection.close();
	}
	
	private static void testDelete() throws Exception {
		//1��ע����������
				Class.forName("com.mysql.jdbc.Driver");
				//2)��ȡ����
				Connection conn = DriverManager.getConnection(url, user, password);
				//3)׼��sql
				String sql = "DELETE FROM student WHERE id=2";
				//4)����Statement����
				Statement stmt = conn.createStatement();
				//5)ִ��sql
				int count = stmt.executeUpdate(sql);
				System.out.println("Ӱ����"+count+"��");
				//6)�ر���Դ
				stmt.close();
				conn.close();
	}
	
	
}
