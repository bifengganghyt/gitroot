package cn.itcast.d_my_aop2;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

	@Override
	public void save() {
		System.out.println("保存...");
	}
}
