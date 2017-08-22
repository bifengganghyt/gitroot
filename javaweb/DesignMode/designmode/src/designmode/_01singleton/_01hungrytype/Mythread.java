package designmode._01singleton._01hungrytype;
import designmode._01singleton._05staticcodearea.Myobject;;
public class Mythread extends Thread{

	@Override
	public void run() {
		System.out.println(Myobject.getInstence().hashCode());
	}
}
