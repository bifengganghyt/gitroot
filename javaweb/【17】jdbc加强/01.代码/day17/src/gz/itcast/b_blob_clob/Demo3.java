package gz.itcast.b_blob_clob;

import gz.itcast.util.JdbcUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Demo3 {
	public static void main(String[] args) {
		//write();
		
		
		/**
		 * 读取
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs  = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from attachments where id=?";
			//预编译
			stmt = conn.prepareStatement(sql);
			//参数赋值
			stmt.setInt(1, 2);
			//执行查询
			rs = stmt.executeQuery();
			//遍历结果
			if(rs.next()){
				
				String name = rs.getString("name");
				InputStream in = rs.getBinaryStream("file");
				
				//取出附件
				//写出到硬盘
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("e:/mm.gif"));
				byte[] buf = new byte[1024];
				int len = 0;
				//边读边写
				while(  (len=in.read(buf))!=-1  ){
					out.write(buf, 0, len);
				}
				//关闭流
				out.close();
				in.close();
				
				Date date = rs.getDate("addtime");
				String author = rs.getString("author");
				
				System.out.println(name+"\t"+date+"\t"+author);
				//rs.getBlob("file").getBinaryStream();
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
			String sql = "insert into attachments(name,file,addtime,author) values(?,?,?,?)";
			//预编译
			stmt = conn.prepareStatement(sql);
			//读取图片
			File file = new File("e:/美女图片.gif");
			
			FileInputStream in = new FileInputStream(file);
			String fileName = file.getName();
			//去掉后缀名
			fileName = fileName.substring(0, fileName.indexOf("."));
			//参数赋值
			stmt.setString(1, fileName );
			//设置文件
			stmt.setBlob(2, in);
			//日期处理
			//1)把datetime字段插入一个字符串内容
			//stmt.setString(3, "2015-06-22 11:47:20");
			//2)把datetime字段插入一个Date类型数据
			 /**
			  * 注意： setDate()方法中设置的是java.sql.Date类型,而不是java.util.Date类型
			  */
			stmt.setDate(3, new java.sql.Date(new Date().getTime()));
			stmt.setString(4, "eric");
			
			//执行
			stmt.executeUpdate();
		
			System.out.println("上传成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
}
