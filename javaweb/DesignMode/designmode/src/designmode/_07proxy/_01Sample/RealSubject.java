package designmode._07proxy._01Sample;

/*
 * ��ʵ��ɫ��ʵ����Subject��request()����
 */
public class RealSubject extends Subject{
	
	public RealSubject() {
	}

	@Override
	public void request() {
		System.out.println("From real subject");
	}

}
