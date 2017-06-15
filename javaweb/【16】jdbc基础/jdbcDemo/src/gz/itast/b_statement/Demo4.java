package gz.itast.b_statement;

import gz.itast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ʹ��Statementִ��DQL��䣨select��
 * @heyutong
 * 2017��5��11��
 */
public class Demo4 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rsResultSet = null;
		try {
			//1)��ȡ����
			connection = JdbcUtil.getConnection();
			//2)׼��sql
			String sql = "select * from student";
			//3)����Statement����
			statement= connection.createStatement();
			//4)ִ��sql
			rsResultSet= statement.executeQuery(sql);
			
			//next()����
			//����ֵ�����true�����е�ǰ�������ݣ���ô�Ϳ���ʹ��getXX()������ȡ�е�ֵ��
			//�����false����û�����ݣ���ʱȥ����getXX()�ͻᱨ��
			while (rsResultSet.next()) {
				//1)��������������ȡ
				// Before start of result set(���ָ���һ��֮ǰ)
				/*int id = rsResultSet.getInt(1);
				String name = rsResultSet.getString(2);
				int age = rsResultSet.getInt(3);
				System.out.println(id+"\t"+name+"\t"+age);*/
				
				//1)��������������ȡ
				/*int id2 = rsResultSet.getInt("id");
				String name2 = rsResultSet.getString("name");
				int age2 = rsResultSet.getInt("age");
				System.out.println(id+"\t"+name+"\t"+age);*/
				
				int id = (Integer)rsResultSet.getObject("id");
				String name = (String)rsResultSet.getObject("name");
				int age = (Integer)rsResultSet.getObject("age");
				System.out.println(id+"\t"+name+"\t"+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5���ر���Դ
			JdbcUtil.close(rsResultSet, statement, connection);
		}
	}
}
