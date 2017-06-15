package gz.itcast.b_blob_clob;

import gz.itcast.util.JdbcUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 使用jdbc操作blob字段
 * @author APPle
 *
 */
public class Demo2 {

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
			rs = stmt.executeQuery();
			
			while(rs.next()){
			
				//读取blob字段
				Blob blob = rs.getBlob("attachments");
				//通过blob字段获取输入字节流
				InputStream in = blob.getBinaryStream();
				
				//把输入字节流写出文件中
				FileOutputStream out = new FileOutputStream("e:/abc.mp3");
				byte[] buf = new byte[1024];
				int len = 0;
				//边读边写
				while( (len=in.read(buf))!=-1  ){
					out.write(buf, 0, len);
				}  
				//关闭流
				out.close();
				in.close();
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
			String sql = "update news set attachments=? where id=?";
			//预编译
			stmt = conn.prepareStatement(sql);
			//参数赋值
			/**
			 * 读取本地字节文件
			 * 注意：
			 * 	1）发送的数据内容超过了字段的长度限制，则抛出 Data too long...异常，这时需要修改字段的类型
			 *  2）发送的数据内容超过了1MB（mysql服务器默认的接收数据包的大小），可以到mysql安装目录下的my.ini文件添加一个变量max_allowed_packet=50M即可！
			 */
			InputStream in = new FileInputStream("e:/02.mp3");
			/**
			 * 设置blob字段
			 */
			stmt.setBlob(1, in);
			stmt.setInt(2, 1);
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
