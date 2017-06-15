package cn.itcast.f_aop_xml;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("保存...");
	}
}
