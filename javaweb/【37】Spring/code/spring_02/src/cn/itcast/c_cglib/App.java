package cn.itcast.c_cglib;

public class App {
	public static void main(String[] args) {
		// 创建目标对象
		UserDao target = new UserDao();
		System.out.println("目标对象：" + target.getClass());  //目标对象：class cn.itcast.c_cglib.UserDao
		
		// 代理对象
		UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
		System.out.println("代理对象： " + proxy.getClass());  //代理对象： class cn.itcast.c_cglib.UserDao$$EnhancerByCGLIB$$f0dc6d19
		
		// 执行代理对象的方法
		proxy.save();  //打印:模拟： 保存用户！
	}
}
