package designmode._07proxy._03staticdaynamicproxy.daynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import designmode._07proxy._03staticdaynamicproxy._common.Intercept;
import designmode._07proxy._03staticdaynamicproxy._common.TargetImpl;

/**
 * ��̬���������
 */
public class InvocationDaynamic implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		TargetImpl t = new TargetImpl();
		Intercept p = new Intercept();
		
		//���Ĳ���
		if(args !=null && args.length == 1) {
			args[0] = "param value has changed!";
		}
		
		//������ʵ�ı���෽��ǰ������������ķ���
		p.before();
		
		//������ʵ�ı���෽��
		Object o = method.invoke(t, args);
		
		//������ʵ�ı���෽����������������ķ���
		p.after();
		
		return o;
	}
	
	

}
