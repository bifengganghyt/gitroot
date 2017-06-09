package cn.itcast.d_di2;

public class UserService implements IUserService{
	private UserDao userDao;
	
	// 接收IOC容器注入值
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		userDao.save();
	}
}
