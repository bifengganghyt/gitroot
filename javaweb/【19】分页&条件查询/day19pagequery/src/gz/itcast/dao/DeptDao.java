package gz.itcast.dao;

import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;
import gz.itcast.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DeptDao {	
	/**
	 * ����������ѯ����
	 * @param args
	 */
	public List<Department> findByCondition(DeptQuery query){
		try {
			//���ݲ�ѯ����ƴ��һ��sql���
			StringBuffer sql = new StringBuffer("select * from department where 1=1 ");
			if(query!=null){
				//�������Ʋ�Ϊ�գ�����sql�������(trim():ȥ�����߿ո�)
				if(query.getDeptName()!=null && !query.getDeptName().trim().equals("")){
					sql.append(" and deptName like '%"+query.getDeptName()+"%'");
				}
				//������
				if(query.getPrincipal()!=null && !query.getPrincipal().trim().equals("")){
					sql.append(" and principal like '%"+query.getPrincipal()+"%'");
				}
				//ְ��
				if(query.getFunctional()!=null && !query.getFunctional().trim().equals("")){
					sql.append(" and functional like '%"+query.getFunctional()+"%'");
				}
			}
			System.out.println(sql.toString());
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Department>)qr.query(sql.toString(), new BeanListHandler(Department.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
