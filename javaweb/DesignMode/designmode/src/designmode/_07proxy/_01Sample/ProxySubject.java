package designmode._07proxy._01Sample;
/**
 * 代理角色
 */
public class ProxySubject extends Subject{
	
	//以真实角色作为代理角色的属性@@
	private RealSubject realSubject;
	
	public ProxySubject() {
	}

	@Override
	public void request() {
		preRequest();
		
		if(realSubject == null) {
			realSubject = new RealSubject();
		}
		//此处执行真实对象的request方法
		realSubject.request();
		
		postRequest();
	}
	
	private void preRequest() {
		//something you want to do before requesting
	}
	
	private void postRequest() {
		//something you want to do after requesting
	}
	
	
	
	
	
}
