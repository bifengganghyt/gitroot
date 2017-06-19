package cn.itcast.b_tx_jdbc_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService implements IDeptService{
	@Resource
	private IDeptDao deptDao;
	
	@Resource
	private LogService logService;

	@Transactional(
			readOnly=false,// 读写的事务，当修改数据时候用；如果查询就设置为true
			isolation=Isolation.DEFAULT,// 事务隔离级别
			timeout=-1,// 事务执行的超时时间, -1 表示不超时
			//noRollbackFor=ArithmeticException.class,   // 遇到指定的异常不回滚
			propagation=Propagation.REQUIRED// 事务传播行为
	)
	public void save() {
		// 插入日志
		//Spring遇到嵌套事务时，当被嵌套的事务被定义为“PROPAGATION_REQUIRES_NEW”时，内层Service方法被调用时，
		//外层方法的事务被挂起，内层事务相对于外层事务是完全独立的，有独立的隔离性等
		//当一个Service类中的某方法调用另一个Service类(“PROPAGATION_REQUIRES_NEW”)中某方法时，内层事务提交也好，
		//回滚也好，都不受外层事务提交或回滚的影响。就是如果内层事务提交了，即使外层事务回滚了，内层事务提交了的数据也不会回归回来了
		logService.insertLog();
		
		int i = 1/0;
		
		// 插入部门
		deptDao.save();
	}

}
