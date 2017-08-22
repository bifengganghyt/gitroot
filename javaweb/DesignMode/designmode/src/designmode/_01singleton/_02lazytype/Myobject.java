package designmode._01singleton._02lazytype;

public class Myobject {
	private volatile static Myobject myobject;
	
	private Myobject() {
	}
	
	public static Myobject getInstence() {
		if(myobject==null) {
			synchronized (Myobject.class) {
				if(myobject==null) {
					myobject = new Myobject();
				}
			}
		}
		return myobject;
	}
}
