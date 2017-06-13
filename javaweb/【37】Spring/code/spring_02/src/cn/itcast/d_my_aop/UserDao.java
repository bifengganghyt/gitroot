package cn.itcast.d_my_aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository  // 把对象加入ioc容器
public class UserDao {
	
	@Resource
	private TransactionAop aop;
	
	public void save() {
		aop.beginTransaction();   		//开启事务..
		System.out.println("保存...");	//保存...
		aop.commit();					//提交事务..
	}
}
