package designmode._01singleton._03Innerclass;
/**
 * ����ģʽ:
 * �ڲ��෽ʽ
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
