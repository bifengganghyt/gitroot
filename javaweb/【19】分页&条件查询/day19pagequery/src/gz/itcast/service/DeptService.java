package gz.itcast.service;

import gz.itcast.dao.DeptDao;
import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;

import java.util.List;
/**
 * ���ŵ�service��
 * @author APPle
 *
 */
public class DeptService {
	DeptDao deptDao = new DeptDao();
		
	public List<Department> findByCondition(DeptQuery query){
		return deptDao.findByCondition(query);
	}
}

