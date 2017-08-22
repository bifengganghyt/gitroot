package designmode._01singleton._04serialize;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Myobject implements Serializable{

	private static final long serialVersionUID = 1L;
	private static class MyobjectHandler {
		private static final Myobject myobject= new Myobject();
	}
	
	private Myobject() {
	}
	
	public static Myobject getInstence() {
		return MyobjectHandler.myobject;
	}
	
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("调用了readResolve方法!");
		return MyobjectHandler.myobject;
	}
}
