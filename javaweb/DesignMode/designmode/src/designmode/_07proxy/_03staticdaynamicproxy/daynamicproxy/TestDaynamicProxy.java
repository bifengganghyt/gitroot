package designmode._07proxy._03staticdaynamicproxy.daynamicproxy;

import java.lang.reflect.Proxy;

import designmode._07proxy._03staticdaynamicproxy._common.Target1;
import designmode._07proxy._03staticdaynamicproxy._common.Target2;

/**
 * ��̬���������
 */
public class TestDaynamicProxy {
	
	/**
	 * logic1��logic2�Ĺ�ͬ�߼�
	 * @param proxy ����
	 */
	public static void publicLogic(Object proxy) {
		//��Ŀ��ӿ�Target1����ĵ���
		System.out.println("��Ŀ��ӿ�Target1����ĵ���");
		Target1 t1 = (Target1)proxy;
		t1.doSomething();
		
		//��Ŀ��ӿ�Target2����ĵ���
		System.out.println("��Ŀ��ӿ�Target2����ĵ���");
		Target2 t2 = (Target2) proxy;
		System.out.println("Target Method do1 return:" + t2.dol("hello!"));
		System.out.println("Target Method do2 return:" + t2.do2());
	}
	
	public static void logic1() {
		InvocationDaynamic iv = new InvocationDaynamic();
		
		/**
		 *  Proxy.newProxyInstance����˵��:
		 *  ����1���������
		 *  ����2������ı�Ľӿڡ�Ҫ����������ʵ�ֶ���ӿ�,��ѡ���ԵĴ�����Щ�ӿ�
		 *  ����3��InvocationHandler(�����ǽ⿪������������������ϣ�ʹ֮�ɻ�������)��ʵ����
		 */
		Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] {Target2.class, Target1.class}, iv);
		
		publicLogic(proxy);
	}
	
	/**
	 * new Class[]{Target1.class}
	 * ������쳣,��Ϊ��û���ڲ����������Լ�Ҫ����Target2�Ľӿڣ�������ȴ��ȥ����
	 */
	public static void logic2() {
		InvocationDaynamic iv = new InvocationDaynamic();
		
		Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[]{Target1.class}, iv);
		publicLogic(proxy);
		
	}
	
	public static void main(String[] args) {
		/**
		 *  ��ӡ��
		 *  ��Ŀ��ӿ�Target1����ĵ���
		 *	before...
		 *	doSomething!
		 *	after...
		 *
		 *	��Ŀ��ӿ�Target2����ĵ���
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
		 *  ��ӡ��
		 *  ��Ŀ��ӿ�Target1����ĵ���
		 *	before...
		 *	doSomething!
		 *	after...
		 *	��Ŀ��ӿ�Target2����ĵ���
		 *	Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to
		 */
		//logic2();
	}
	

}
