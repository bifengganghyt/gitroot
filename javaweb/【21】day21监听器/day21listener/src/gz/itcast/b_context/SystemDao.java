package gz.itcast.b_context;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;

public class SystemDao {
	/**
	 * ��ʼ����������
	 * @heyutong
	 * 2017��5��25��
	 */
	public void initTable() {
		try {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
			queryRunner.update("create table student(id int primary key,name varchar(20),gender varchar(2))");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * �����
	 */
	public void clearTable(){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("drop table student");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
