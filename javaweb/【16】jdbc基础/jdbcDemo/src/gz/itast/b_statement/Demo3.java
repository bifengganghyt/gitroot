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
			//1)��ȡ����
			conn = JdbcUtil.getConnection();
			//2)׼��sql
			String sql = "CREATE TABLE employee( "+
							"id INT PRIMARY KEY AUTO_INCREMENT,"+
							"NAME VARCHAR(20),"+
							"gender VARCHAR(2),"+
							"age INT,"+
							"title VARCHAR(20),"+
							"email VARCHAR(50),"+
							"phone VARCHAR(11)"+
							")";
			//3)����Statement����
			stmt = conn.createStatement();
			//4)ִ��sql
			int count = stmt.executeUpdate(sql);
			System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)�ر���Դ
			JdbcUtil.close(stmt, conn);
		}
	}
	
	private static void insert() {
		Statement statement = null;
		Connection connection = null;
		
		//ģ���û����������
		String name = "����";
		String gender = "Ů";
		int age = 40;
		String title = "���ά������ʦ";
		String email = "lisi@qq.com";
		String phone = "13522223333";
		
		connection = JdbcUtil.getConnection();
		//2)׼��sql
		String sql = "INSERT INTO employee(NAME,gender,age,title,email,phone) VALUES('"+name+"','"+gender+"',"+age+",'"+title+"','"+email+"','"+phone+"')";
		System.out.println(sql);
		//3)����Statement����
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5)�ر���Դ
			JdbcUtil.close(statement, connection);
		}
	}
	
	private static void update() {
		Statement stmt = null;
		Connection conn = null;
		
		//ģ���û����������
		String name = "����";
		String gender = "Ů";
		int age = 40;
		String title = "���ά������ʦ";
		String email = "lisi@qq.com";
		String phone = "13522223333";
		int id = 1;
		
		try {
			//1)��ȡ����
			conn = JdbcUtil.getConnection();
			//2)׼��sql
			String sql = "UPDATE employee SET NAME='"+name+"',gender='"+gender+"',age="+age+",title='"+title+"',email='"+email+"',phone='"+phone+"' WHERE id="+id+"";
			
			System.out.println(sql);
			
			//3)����Statement����
			stmt =conn.createStatement();
			//4)ִ��sql
			int count = stmt.executeUpdate(sql);
			System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)�ر���Դ
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
		//ģ���û����������
		int id = 1;
		
		try {
			//1)��ȡ����
			conn = JdbcUtil.getConnection();
			//2)׼��sql
			String sql = "delete from employee where id="+id+"";
			
			System.out.println(sql);
			
			//3)����Statement����
			stmt = conn.createStatement();
			//4)ִ��sql
			int count = stmt.executeUpdate(sql);
			System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5)�ر���Դ
			JdbcUtil.close(stmt, conn);
		}
	}
}
