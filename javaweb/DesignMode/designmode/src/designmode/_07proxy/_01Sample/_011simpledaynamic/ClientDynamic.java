package designmode._07proxy._01Sample._011simpledaynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * 被代理对象(RealSubject)可在运行时动态改变
 * 需控制的接口(Subject接口)可在运行时改变
 * 控制的方式(DynamicSubject)也可动态改变
 */
public class ClientDynamic {
	public static void main(String[] args) {
		//在这里指定被代理类
		RealSubject rs = new RealSubject();
		Class cls = rs.getClass();
		
		//初始化代理类
		InvocationHandler ds = new DynamicSubject(rs);
		
		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), ds);
		
		subject.request();
	}

}
