package cn.itcast.e_aop_anno;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

	@Override
	public void save() {
		System.out.println("保存...");
	}
}
