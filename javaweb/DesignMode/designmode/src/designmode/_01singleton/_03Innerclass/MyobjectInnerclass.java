package designmode._01singleton._03Innerclass;
/**
 * 饿汉模式:
 * 内部类方式
 */
public class MyobjectInnerclass {
	private static class MyobjectHandler{
		private static MyobjectInnerclass myobject = new MyobjectInnerclass();
		
	}
	
	private MyobjectInnerclass() {
	}
	
	public static MyobjectInnerclass getInstence() {
		return MyobjectHandler.myobject;
	}
}
