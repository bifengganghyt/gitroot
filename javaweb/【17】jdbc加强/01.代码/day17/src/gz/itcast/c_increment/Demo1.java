package gz.itcast.c_increment;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ʹ��jdbc��ȡ��������ֵ
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			/**
			 * ͬʱ����һ�����ź͸ò������ڵ�Ա��������
			 */
			String deptSql = "insert into dept(name) values(?)";
			String empSql = "insert into employee(name,deptId) values(?,?)";
			
			/**
			 * �����ȡ�����������ɵ�ֵ???
			 * 1�������Ƿ���Է�����������ֵ
			 *    RETURN_GENERATED_KEYS: ���Է�������������ֵ
			 *    NO_GENERATED_KEYS:���ܷ�����������ֵ
			 */
			stmt = conn.prepareStatement(deptSql,Statement.RETURN_GENERATED_KEYS);
			//������ֵ
			stmt.setString(1, "���ά����");
			//ִ�в��벿�ŵ�sql
			stmt.executeUpdate();
			
			/**
			 * 2����ȡ��������ֵ
			 *    ע�⣺ ��ResultSetֻ���������������ֶ�
			 */
			rs = stmt.getGeneratedKeys();
			int deptId = 0;
			if(rs.next()){
				deptId = rs.getInt(1);
			}
			
			stmt = conn.prepareStatement(empSql);
			stmt.setString(1, "����");
			stmt.setInt(2, deptId);
			//ִ�в���Ա����sql
			stmt.executeUpdate();
			System.out.println("��ӳɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

}
