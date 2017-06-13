package cn.itcast.d_my_aop2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	
	/**
	 * 生成代理对象
	 * @heyutong
	 * 2017年6月13日
	 * @param target  目标对象
	 * @param aop     给目标对象动态注入的重复的代码(关注点代码)
	 * @return
	 */
	public Object getProxyInstance(final Object target,final TransactionAop aop){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					//userDao.save();触发
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						aop.beginTransaction();						// 执行重复代码  打印："开启事务.."
						Object result = method.invoke(target, args);// 执行目标对象方法：userDao.save();  打印:"保存..."
						aop.commit();								// 打印:"提交事务.."
						return result;
					}
				});
	}
}
