package designmode._07proxy._01Sample._011simpledaynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * ���������(RealSubject)��������ʱ��̬�ı�
 * ����ƵĽӿ�(Subject�ӿ�)��������ʱ�ı�
 * ���Ƶķ�ʽ(DynamicSubject)Ҳ�ɶ�̬�ı�
 */
public class ClientDynamic {
	public static void main(String[] args) {
		//������ָ����������
		RealSubject rs = new RealSubject();
		Class cls = rs.getClass();
		
		//��ʼ��������
		InvocationHandler ds = new DynamicSubject(rs);
		
		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), ds);
		
		subject.request();
	}

}
