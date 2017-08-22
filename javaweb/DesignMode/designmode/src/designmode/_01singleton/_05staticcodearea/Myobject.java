package designmode._01singleton._05staticcodearea;

public class Myobject {
	private static Myobject instence = null;
	
	private Myobject() {
	}
	
	static {
		instence = new Myobject();
	}
	
	public static Myobject getInstence() {
		return instence;
	}
}
