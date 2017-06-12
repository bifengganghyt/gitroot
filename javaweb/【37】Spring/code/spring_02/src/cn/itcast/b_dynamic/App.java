package cn.itcast.b_dynamic;

public class App {
	public static void main(String[] args) {
		// 创建目标对象
		UserDao target = new UserDao();
		System.out.println("目标对象：" + target.getClass());  //目标对象：class cn.itcast.b_dynamic.UserDao
		
		// 代理对象
		IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
		System.out.println("代理对象： " + proxy.getClass());  //代理对象： class com.sun.proxy.$Proxy0
		
		// 执行代理对象的方法
		//proxy.find();//执行public Object invoke方法  1.查询
		proxy.save();//执行public Object invoke方法 1.开启事务...  2.模拟： 保存用户！  3.提交事务...
	}
}
