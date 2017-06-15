package gz.itcast.a_batch;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 * ͬʱ����2000������
 * @author APPle
 * ���ۣ�
 * 1) mysql���ݿⲻ֧��PreparedStatement�Ż������Ҳ�֧���������Ż�
 * 2) oracle���ݿ⼴֧��PreparedStatement�Ż���Ҳ֧���������Ż�   
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
	 * ����ִ���ٶ�
	 */
	public static void testTime(){
		long start = System.currentTimeMillis();
		//testByStaement();
		//testByStaementBatch();
		//testByPreparedStaement();
		testByPreparedStaementBatch();
		long end = System.currentTimeMillis();
		System.out.println("��ʱΪ��"+(end-start));
	}

	/**
	 * û���������Statement�����
	 * mysql: ��ʱΪ��7838   oracle:��ʱΪ��6580
	 */
	public static void testByStaement(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			for(int i=1;i<=2000;i++){
				stmt.executeUpdate("INSERT INTO student VALUES("+i+",'����',20,'��')");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	
	/**
	 * ʹ���������Statement�����
	 * mysql: ��ʱΪ��9097  oracle:��ʱΪ��5477
	 */
	public static void testByStaementBatch(){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			for(int i=1;i<=2000;i++){
				//��sql��ӵ�������
				stmt.addBatch("INSERT INTO student VALUES("+i+",'����',20,'��')");
				//ÿ20������sql
				if(i%20==0){
					//ִ������������
					stmt.executeBatch();
					//��ջ�����
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
	 * û���������PrepaedStatement�����
	 * mysql: ��ʱΪ��9051 oracle:��ʱΪ��4161
	 */
	public static void testByPreparedStaement(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			for(int i=1;i<=2000;i++){
				//������ֵ
				stmt.setInt(1, i);
				stmt.setString(2, "����");
				stmt.setInt(3, 20);
				stmt.setString(4, "��");
				//ִ��
				stmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}
	
	
	/**
	 * ʹ���������PrepaedStatement�����
	 * mysql:��ʱΪ��9379 oracle: ��ʱΪ��1391
	 */
	public static void testByPreparedStaementBatch(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			for(int i=1;i<=2000;i++){
				//������ֵ
				stmt.setInt(1, i);
				stmt.setString(2, "����");
				stmt.setInt(3, 20);
				stmt.setString(4, "��");
				//�Ѳ�����ӵ�������
				stmt.addBatch();
				//ÿ20�η���һ�β���
				if(i%20==0){
					//ִ������������
					stmt.executeBatch();
					//��ջ������Ĳ���
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
