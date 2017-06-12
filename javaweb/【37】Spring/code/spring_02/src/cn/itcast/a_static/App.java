package cn.itcast.a_static;

public class App {
	public static void main(String[] args) {
		// 代理对象
		UserDaoProxy userDaoProxy = new UserDaoProxy();//private IUserDao target = new UserDao();
		// 执行代理方法
		userDaoProxy.save();//1.代理操作： 开启事务...  2.模拟： 保存用户！  3.代理操作：提交事务...
	}
}
