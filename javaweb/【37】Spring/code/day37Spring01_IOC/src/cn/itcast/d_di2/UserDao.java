package cn.itcast.d_di2;

public class UserDao implements IUserDao {
	@Override
	public void save() {
		System.out.println("UserDao.save()");
	}
}
