package designmode._07proxy._03staticdaynamicproxy.staticproxy;

import designmode._07proxy._03staticdaynamicproxy._common.Intercept;
import designmode._07proxy._03staticdaynamicproxy._common.TargetImpl;

/**
 * 耦合类
 */
public class Invocation {
	public Object invokeDoSomething() {
		TargetImpl t = new TargetImpl();
		Intercept p = new Intercept();
		
		//调用真实的标的类方法前置入拦截器类的方法
		p.before();
		
		//调用真实的标的类方法
		t.doSomething();
		
		//调用真实的标的类方法后置入拦截器类的方法
		p.after();
		
		return null;
	}
}
