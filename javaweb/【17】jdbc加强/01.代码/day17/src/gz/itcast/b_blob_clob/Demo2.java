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
 * ʹ��jdbc����blob�ֶ�
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		//write();
		
		/**
		 * ��ȡ
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
			
				//��ȡblob�ֶ�
				Blob blob = rs.getBlob("attachments");
				//ͨ��blob�ֶλ�ȡ�����ֽ���
				InputStream in = blob.getBinaryStream();
				
				//�������ֽ���д���ļ���
				FileOutputStream out = new FileOutputStream("e:/abc.mp3");
				byte[] buf = new byte[1024];
				int len = 0;
				//�߶���д
				while( (len=in.read(buf))!=-1  ){
					out.write(buf, 0, len);
				}  
				//�ر���
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
		 * д��
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "update news set attachments=? where id=?";
			//Ԥ����
			stmt = conn.prepareStatement(sql);
			//������ֵ
			/**
			 * ��ȡ�����ֽ��ļ�
			 * ע�⣺
			 * 	1�����͵��������ݳ������ֶεĳ������ƣ����׳� Data too long...�쳣����ʱ��Ҫ�޸��ֶε�����
			 *  2�����͵��������ݳ�����1MB��mysql������Ĭ�ϵĽ������ݰ��Ĵ�С�������Ե�mysql��װĿ¼�µ�my.ini�ļ����һ������max_allowed_packet=50M���ɣ�
			 */
			InputStream in = new FileInputStream("e:/02.mp3");
			/**
			 * ����blob�ֶ�
			 */
			stmt.setBlob(1, in);
			stmt.setInt(2, 1);
			//ִ��
			stmt.executeUpdate();
			System.out.println("��ӳɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
}
