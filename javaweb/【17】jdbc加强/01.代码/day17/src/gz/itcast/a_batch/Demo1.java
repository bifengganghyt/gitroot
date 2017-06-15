package gz.itcast.a_batch;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 * 同时插入2000条数据
 * @author APPle
 * 结论：
 * 1) mysql数据库不支持PreparedStatement优化，而且不支持批处理优化
 * 2) oracle数据库即支持PreparedStatement优化，也支持批处理优化   
 *
 */
public class Demo1 {
	
	public static void main(String[] args) {
		//testByStaement();
		//testByStaementBatch();
		//testByPreparedStaement();
		//testByPreparedStaementBatch();
		
		testTime();
	}
	
	/**
	 * 测试执行速度
	 */
	public static void testTime(){
		long start = System.currentTimeMillis();
		//testByStaement();
		//testByStaementBatch();
		//testByPreparedStaement();
		testByPreparedStaementBatch();
		long end = System.currentTimeMillis();
		System.out.println("耗时为："+(end-start));
	}

	/**
	 * 没有批处理的Statement的情况
	 * mysql: 耗时为：7838   oracle:耗时为：6580
	 */
	public static void testByStaement(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			for(int i=1;i<=2000;i++){
				stmt.executeUpdate("INSERT INTO student VALUES("+i+",'张三',20,'男')");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	
	/**
	 * 使用批处理的Statement的情况
	 * mysql: 耗时为：9097  oracle:耗时为：5477
	 */
	public static void testByStaementBatch(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			for(int i=1;i<=2000;i++){
				//把sql添加到缓存区
				stmt.addBatch("INSERT INTO student VALUES("+i+",'张三',20,'男')");
				//每20条发送sql
				if(i%20==0){
					//执行批处理命令
					stmt.executeBatch();
					//清空缓存区
					stmt.clearBatch();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	/**
	 * 没有批处理的PrepaedStatement的情况
	 * mysql: 耗时为：9051 oracle:耗时为：4161
	 */
	public static void testByPreparedStaement(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			for(int i=1;i<=2000;i++){
				//参数赋值
				stmt.setInt(1, i);
				stmt.setString(2, "张三");
				stmt.setInt(3, 20);
				stmt.setString(4, "男");
				//执行
				stmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	
	/**
	 * 使用批处理的PrepaedStatement的情况
	 * mysql:耗时为：9379 oracle: 耗时为：1391
	 */
	public static void testByPreparedStaementBatch(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			for(int i=1;i<=2000;i++){
				//参数赋值
				stmt.setInt(1, i);
				stmt.setString(2, "张三");
				stmt.setInt(3, 20);
				stmt.setString(4, "男");
				//把参数添加到缓存区
				stmt.addBatch();
				//每20次发送一次参数
				if(i%20==0){
					//执行批处理命令
					stmt.executeBatch();
					//清空缓存区的参数
					stmt.clearBatch();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
}
