package designmode._07proxy._01Sample._011simpledaynamic;
/**
 * �����ɫ
 */
public class RealSubject implements Subject{

	@Override
	public void request() {
		System.out.println("From real subject");
	}
}
