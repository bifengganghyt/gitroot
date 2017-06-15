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
		 * ��ȡ
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs  = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from attachments where id=?";
			//Ԥ����
			stmt = conn.prepareStatement(sql);
			//������ֵ
			stmt.setInt(1, 2);
			//ִ�в�ѯ
			rs = stmt.executeQuery();
			//�������
			if(rs.next()){
				
				String name = rs.getString("name");
				InputStream in = rs.getBinaryStream("file");
				
				//ȡ������
				//д����Ӳ��
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("e:/mm.gif"));
				byte[] buf = new byte[1024];
				int len = 0;
				//�߶���д
				while(  (len=in.read(buf))!=-1  ){
					out.write(buf, 0, len);
				}
				//�ر���
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
		 * д��
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "insert into attachments(name,file,addtime,author) values(?,?,?,?)";
			//Ԥ����
			stmt = conn.prepareStatement(sql);
			//��ȡͼƬ
			File file = new File("e:/��ŮͼƬ.gif");
			
			FileInputStream in = new FileInputStream(file);
			String fileName = file.getName();
			//ȥ����׺��
			fileName = fileName.substring(0, fileName.indexOf("."));
			//������ֵ
			stmt.setString(1, fileName );
			//�����ļ�
			stmt.setBlob(2, in);
			//���ڴ���
			//1)��datetime�ֶβ���һ���ַ�������
			//stmt.setString(3, "2015-06-22 11:47:20");
			//2)��datetime�ֶβ���һ��Date��������
			 /**
			  * ע�⣺ setDate()���������õ���java.sql.Date����,������java.util.Date����
			  */
			stmt.setDate(3, new java.sql.Date(new Date().getTime()));
			stmt.setString(4, "eric");
			
			//ִ��
			stmt.executeUpdate();
		
			System.out.println("�ϴ��ɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
}
