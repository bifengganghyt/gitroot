package gz.itcast.service;

import gz.itcast.dao.UserDao;
import gz.itcast.entity.User;

public class UserService {
	UserDao dao = new UserDao();
	/**
	 * ��¼����
	 * @param user
	 * @return
	 */
	public User login(User user){
		return dao.queryUser(user);
	}
	/**
	 * ע�᷽��
	 * @param user
	 */
	public void register(User user){
		dao.addUser(user);
	}
}
