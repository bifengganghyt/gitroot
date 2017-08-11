package designmode._07proxy._01Sample._011simpledaynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * �����ɫ
 */
public class DynamicSubject implements InvocationHandler{
	private Object sub;
	
	//���뱻������Ķ���
	public DynamicSubject(Object sub) {
		this.sub = sub;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("before calling" + method);
		method.invoke(sub, args);
		System.out.println("after calling" + method);
		return null;
	}
}
