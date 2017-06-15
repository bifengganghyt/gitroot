package gz.itcast.b_blob_clob;

import gz.itcast.util.JdbcUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 使用jdbc操作text字段
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		//write();
		
		/**
		 * 读取
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from news where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 1);
			//执行查询
			rs = stmt.executeQuery();
			
			//读取结果集
			while(rs.next()){
				
				//获取text字段
				//1)可以把text字段内容当前字符串读取
			/*	String content = rs.getString("content");
				System.out.println(content);
				*/
				
				//2)可以把text字段当做输入流读取
				Clob clob = rs.getClob("content");
				//通过clob字段读取输入流
				Reader reader = clob.getCharacterStream();
				
				//把输入流输出到文件中
				FileWriter writer = new FileWriter("e:/abc.txt");
				char[] buf = new char[512];
				int len = 0;
				while(  (len=reader.read(buf))!=-1 ){
					//边读边写出
					writer.write(buf, 0, len);
				}
				//关闭流
				writer.close();
				reader.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}

	private static void write() {
		/**
		 * 写入
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "insert into news(title,content) values(?,?)";
			//预编译
			stmt = conn.prepareStatement(sql);
			//参数赋值
			stmt.setString(1, "昨天是父亲节，全国各地都在纷纷庆祝！！！");
			/**
			 * 读取本地的字符文件
			 */
			Reader reader = new FileReader("e:/url.txt");
			//设置text字段
			stmt.setClob(2, reader);
			
			//执行
			stmt.executeUpdate();
			System.out.println("添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
}
