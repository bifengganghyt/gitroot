package gz.itcast.d_transaction;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ʹ��jdbc��������
 * @author APPle
 *
 */
public class Demo1 {

	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			
			//1)�ر��Զ��ύ���ܣ��л��ֶ���������
			conn.setAutoCommit(false); // �����ݿⷢ��set autocommit=0;
			/**
			 * ���� ericת��2000Ԫ��jacky
			 */
			//��eric�˻��Ͽ۳�2000Ԫ
			String delSql = "update account set balance=balance-2000 where name='eric'";
			//��jacky�˻�����2000Ԫ
			String addSql = "update account set balance=balance+2000 where name='jacky'";
			
			stmt = conn.prepareStatement(delSql);
			//ִ��
			stmt.executeUpdate();
			
			//�����쳣
			int i = 100/0;
			
			stmt = conn.prepareStatement(addSql);
			stmt.executeUpdate();
			
			//3)������sqlִ����ɣ�û�������ˣ����ύ����
			conn.commit();  // �����ݿⷢ��  commit; ����
			System.out.println("ת�˳ɹ���");
			
		}catch(Exception e){
			e.printStackTrace();
			//2)��ҵ������쳣���κ�һ��sqlִ�й����г������⣩,��Ҫ�ع�
			try {
				conn.rollback();  // �����ݿ� ����  rollback;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}

}
