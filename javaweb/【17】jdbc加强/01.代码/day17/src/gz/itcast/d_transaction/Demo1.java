package gz.itcast.d_transaction;

import gz.itcast.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用jdbc控制事务
 * @author APPle
 *
 */
public class Demo1 {

	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			
			//1)关闭自动提交功能，切换手动管理事务
			conn.setAutoCommit(false); // 向数据库发送set autocommit=0;
			/**
			 * 需求： eric转账2000元给jacky
			 */
			//从eric账户上扣除2000元
			String delSql = "update account set balance=balance-2000 where name='eric'";
			//向jacky账户打入2000元
			String addSql = "update account set balance=balance+2000 where name='jacky'";
			
			stmt = conn.prepareStatement(delSql);
			//执行
			stmt.executeUpdate();
			
			//出现异常
			int i = 100/0;
			
			stmt = conn.prepareStatement(addSql);
			stmt.executeUpdate();
			
			//3)当所有sql执行完成，没有问题了，则提交事务
			conn.commit();  // 向数据库发送  commit; 命令
			System.out.println("转账成功！");
			
		}catch(Exception e){
			e.printStackTrace();
			//2)当业务出现异常（任何一条sql执行过程中出现问题）,需要回滚
			try {
				conn.rollback();  // 向数据库 发送  rollback;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JdbcUtil.close(stmt, conn);
		}
	}

}
