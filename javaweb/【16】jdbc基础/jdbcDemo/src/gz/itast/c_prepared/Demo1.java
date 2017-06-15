package gz.itast.c_prepared;

import gz.itast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ʹ��PreparedStatementִ��CRUD����
 * ִ��Ԥ�����sql���
 * @author S43W
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//insert();
		
		//update();
				
		delete();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//1)��ȡ����
			connection = JdbcUtil.getConnection();
			//2)׼��sql
			// �����ǲ�����ռλ��.һ���ʺŴ���һ������.
			String sql = "select * from student where id=?";
			//3)����PreparedStatement��Ԥ����sql���
			//Ԥ����sql��䣨sql�﷨��Ȩ�޵ļ�飩
			preparedStatement = connection.prepareStatement(sql);
			//4)��������ֵ
			/**
			 * ����һ��������λ�á���1��ʼ
			 * ������������ֵ
			 * ע�⣺���û�в���������Ҫ��ֵ��
			 */
			preparedStatement.setInt(1, 4);
			resultSet = preparedStatement.executeQuery();
			
			//���������
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				System.out.println(id+"\t"+name+"\t"+age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ر���Դ
			JdbcUtil.close(resultSet, preparedStatement, connection);
		}
	}
	
	private static void insert() {
		//����
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		//1)��ȡ����
		connection = JdbcUtil.getConnection();
		//2)׼��sql
		// �����ǲ�����ռλ��.һ���ʺŴ���һ������.
		String sql = "insert into student(id,name,age) values(?,?,?)";
		//3)����PreparedStatement��Ԥ����sql���
		
		preparedStatement = connection.prepareStatement(sql);
		
		//4)��������ֵ
		/**
		 * ����һ��������λ�á���1��ʼ
		 * ������������ֵ
		 */
		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "����");
		preparedStatement.setInt(3, 40);
		//4)���Ͳ��������ݿ⣬ִ��sql
		int count = preparedStatement.executeUpdate();
		System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//��ע��Դ
			JdbcUtil.close(preparedStatement, connection);
		}
	}
	
	private static void update() {
		/**
		 * �޸�
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//1)��ȡ����
			conn = JdbcUtil.getConnection();
			//2)׼��sql
			String sql = "update student set name=?,age=? where id=?"; // �����ǲ�����ռλ��.һ���ʺŴ���һ������.
			//3)����PreparedStatement��Ԥ����sql���
			stmt = conn.prepareStatement(sql); //Ԥ����sql��䣨sql�﷨��Ȩ�޵ļ�飩
			//4)��������ֵ
			/**
			 * ����һ��������λ�á���1��ʼ
			 * ������������ֵ
			 * ע�⣺������λ��һ��Ҫ��Ӧ�ֶε�λ��
			 */
			stmt.setString(1, "����");
			stmt.setInt(2, 50);
			stmt.setInt(3, 5);
			//4)���Ͳ��������ݿ⣬ִ��sql
			int count = stmt.executeUpdate();
			System.out.println("Ӱ����"+count+"��");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//��ע��Դ
			JdbcUtil.close(stmt, conn);
		}
	}
	
	private static void delete() {
		//ɾ��
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		//1)��ȡ����
		connection = JdbcUtil.getConnection();
		//2)׼��sql
		// �����ǲ�����ռλ��.һ���ʺŴ���һ������.
		String sql = "delete from student where id=?";
		//3)����PreparedStatement��Ԥ����sql���
		preparedStatement = connection.prepareStatement(sql);//Ԥ����sql��䣨sql�﷨��Ȩ�޵ļ�飩
		//4)��������ֵ	
		/**
		 * ����һ��������λ�á���1��ʼ
		 * ������������ֵ
		 * ע�⣺������λ��һ��Ҫ��Ӧ�ֶε�λ��
		 */
		preparedStatement.setInt(1, 5);
		//4)���Ͳ��������ݿ⣬ִ��sql
		int count = preparedStatement.executeUpdate();
		System.out.println("Ӱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(preparedStatement, connection);
		}
	}
	
}
