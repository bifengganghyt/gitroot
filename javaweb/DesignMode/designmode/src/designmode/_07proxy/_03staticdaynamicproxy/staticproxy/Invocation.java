package designmode._07proxy._03staticdaynamicproxy.staticproxy;

import designmode._07proxy._03staticdaynamicproxy._common.Intercept;
import designmode._07proxy._03staticdaynamicproxy._common.TargetImpl;

/**
 * �����
 */
public class Invocation {
	public Object invokeDoSomething() {
		TargetImpl t = new TargetImpl();
		Intercept p = new Intercept();
		
		//������ʵ�ı���෽��ǰ������������ķ���
		p.before();
		
		//������ʵ�ı���෽��
		t.doSomething();
		
		//������ʵ�ı���෽����������������ķ���
		p.after();
		
		return null;
	}
}
