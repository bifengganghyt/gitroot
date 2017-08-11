package designmode._07proxy._03staticdaynamicproxy.daynamicproxy;

import java.lang.reflect.Proxy;

import designmode._07proxy._03staticdaynamicproxy._common.Target1;
import designmode._07proxy._03staticdaynamicproxy._common.Target2;

/**
 * 动态代理测试类
 */
public class TestDaynamicProxy {
	
	/**
	 * logic1与logic2的共同逻辑
	 * @param proxy 代理
	 */
	public static void publicLogic(Object proxy) {
		//对目标接口Target1代理的调用
		System.out.println("对目标接口Target1代理的调用");
		Target1 t1 = (Target1)proxy;
		t1.doSomething();
		
		//对目标接口Target2代理的调用
		System.out.println("对目标接口Target2代理的调用");
		Target2 t2 = (Target2) proxy;
		System.out.println("Target Method do1 return:" + t2.dol("hello!"));
		System.out.println("Target Method do2 return:" + t2.do2());
	}
	
	public static void logic1() {
		InvocationDaynamic iv = new InvocationDaynamic();
		
		/**
		 *  Proxy.newProxyInstance参数说明:
		 *  参数1：类加载器
		 *  参数2：代理的标的接口—要代理的类可能实现多个接口,可选择性的代理这些接口
		 *  参数3：InvocationHandler(作用是解开标的类与拦截器间的耦合，使之可互不关心)的实现类
		 */
		Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] {Target2.class, Target1.class}, iv);
		
		publicLogic(proxy);
	}
	
	/**
	 * new Class[]{Target1.class}
	 * 将会出异常,因为他没有在参数中声明自己要调用Target2的接口，二后面却又去调用
	 */
	public static void logic2() {
		InvocationDaynamic iv = new InvocationDaynamic();
		
		Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[]{Target1.class}, iv);
		publicLogic(proxy);
		
	}
	
	public static void main(String[] args) {
		/**
		 *  打印：
		 *  对目标接口Target1代理的调用
		 *	before...
		 *	doSomething!
		 *	after...
		 *
		 *	对目标接口Target2代理的调用
		 *	before...
		 *	dol:param value has changed!
		 *	after...
		 *	Target Method do1 return:this is String Method!
		 *
		 *	before...
		 *	do2!
		 *	after...
		 *	Target Method do2 return:1000
		 */
		logic1();
		
		/**
		 *  打印：
		 *  对目标接口Target1代理的调用
		 *	before...
		 *	doSomething!
		 *	after...
		 *	对目标接口Target2代理的调用
		 *	Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to
		 */
		//logic2();
	}
	

}
