package cn.itcast.a_tx_jdbc;

public class DeptService implements IDeptService {
	// 注入dao
	private IDeptDao deptDao;
	
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public void save() {
		deptDao.save();
		int i = 1/0;//此处出错，之前保存的数据也全部回滚;若此处加上try catch,则此处不会触发回滚
		deptDao.save();
	}
}
