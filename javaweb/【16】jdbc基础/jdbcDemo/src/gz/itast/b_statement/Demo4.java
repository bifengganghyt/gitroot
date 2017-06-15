package gz.itast.b_statement;

import gz.itast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用Statement执行DQL语句（select）
 * @heyutong
 * 2017年5月11日
 */
public class Demo4 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rsResultSet = null;
		try {
			//1)获取连接
			connection = JdbcUtil.getConnection();
			//2)准备sql
			String sql = "select * from student";
			//3)创建Statement对象
			statement= connection.createStatement();
			//4)执行sql
			rsResultSet= statement.executeQuery(sql);
			
			//next()方法
			//返回值如果是true代表有当前行有数据，那么就可以使用getXX()方法获取列的值；
			//如果是false，则没有数据，这时去调用getXX()就会报错！
			while (rsResultSet.next()) {
				//1)根据列索引来获取
				// Before start of result set(光标指向第一行之前)
				/*int id = rsResultSet.getInt(1);
				String name = rsResultSet.getString(2);
				int age = rsResultSet.getInt(3);
				System.out.println(id+"\t"+name+"\t"+age);*/
				
				//1)根据列名称来获取
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
			//5）关闭资源
			JdbcUtil.close(rsResultSet, statement, connection);
		}
	}
}
