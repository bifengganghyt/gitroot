package designmode._07proxy._01Sample;
/**
 * �����ɫ
 */
public class ProxySubject extends Subject{
	
	//����ʵ��ɫ��Ϊ�����ɫ������@@
	private RealSubject realSubject;
	
	public ProxySubject() {
	}

	@Override
	public void request() {
		preRequest();
		
		if(realSubject == null) {
			realSubject = new RealSubject();
		}
		//�˴�ִ����ʵ�����request����
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
