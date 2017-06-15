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
 * ʹ��jdbc����text�ֶ�
 * @author APPle
 *
 */
public class Demo1 {

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
			//ִ�в�ѯ
			rs = stmt.executeQuery();
			
			//��ȡ�����
			while(rs.next()){
				
				//��ȡtext�ֶ�
				//1)���԰�text�ֶ����ݵ�ǰ�ַ�����ȡ
			/*	String content = rs.getString("content");
				System.out.println(content);
				*/
				
				//2)���԰�text�ֶε�����������ȡ
				Clob clob = rs.getClob("content");
				//ͨ��clob�ֶζ�ȡ������
				Reader reader = clob.getCharacterStream();
				
				//��������������ļ���
				FileWriter writer = new FileWriter("e:/abc.txt");
				char[] buf = new char[512];
				int len = 0;
				while(  (len=reader.read(buf))!=-1 ){
					//�߶���д��
					writer.write(buf, 0, len);
				}
				//�ر���
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
		 * д��
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "insert into news(title,content) values(?,?)";
			//Ԥ����
			stmt = conn.prepareStatement(sql);
			//������ֵ
			stmt.setString(1, "�����Ǹ��׽ڣ�ȫ�����ض��ڷ׷���ף������");
			/**
			 * ��ȡ���ص��ַ��ļ�
			 */
			Reader reader = new FileReader("e:/url.txt");
			//����text�ֶ�
			stmt.setClob(2, reader);
			
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
