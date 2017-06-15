package gz.itast.b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ʹ��Statement�ӿ�ִ��DDL���(create/drop/alter)
 * @heyutong
 * 2017��5��11��
 */
public class Demo1 {
	//url
	private static String url = "jdbc:mysql://localhost:3306/day16";
	//user
	private static String user = "root";
	//password
	private static String password = "123";
	
	/**
	 * ʹ��Statement�ӿ�ִ��DDL���(create/drop/alter)
	 * @heyutong
	 * 2017��5��11��
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//1)ע����������
		Class.forName("com.mysql.jdbc.Driver");
		//2)��ȡ����
		Connection connection = DriverManager.getConnection(url, user, password);
		//3)׼��sql���
		String sql = "CREATE TABLE student(id INT, NAME VARCHAR(20), age INT)";
		//4)�����ӻ����ϣ�����Statement
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(sql);// ִ��DDL��DML��䣨����sql��䣩
		System.out.println("Ӱ����"+count+"�У�");//���:Ӱ����0�У�
		//6)�ر���Դ.��򿪵��ȹر�
		statement.close();
		connection.close();
	}
}
