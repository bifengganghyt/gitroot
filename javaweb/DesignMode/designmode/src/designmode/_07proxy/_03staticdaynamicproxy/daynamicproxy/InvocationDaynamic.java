package designmode._07proxy._03staticdaynamicproxy.daynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import designmode._07proxy._03staticdaynamicproxy._common.Intercept;
import designmode._07proxy._03staticdaynamicproxy._common.TargetImpl;

/**
 * 动态代理耦合类
 */
public class InvocationDaynamic implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		TargetImpl t = new TargetImpl();
		Intercept p = new Intercept();
		
		//更改参数
		if(args !=null && args.length == 1) {
			args[0] = "param value has changed!";
		}
		
		//调用真实的标的类方法前置入拦截器类的方法
		p.before();
		
		//调用真实的标的类方法
		Object o = method.invoke(t, args);
		
		//调用真实的标的类方法后置入拦截器类的方法
		p.after();
		
		return o;
	}
	
	

}
