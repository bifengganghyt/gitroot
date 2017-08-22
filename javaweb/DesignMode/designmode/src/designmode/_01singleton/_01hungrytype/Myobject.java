package designmode._01singleton._01hungrytype;

/**
 * 立即加载/饿汉式:
 * 使用类时已将对象创建完毕，即调用方法前，实例已被创建
 */
public class Myobject {
	private static Myobject myobject = new Myobject();
	
	private Myobject() {
	}
	
	//此版本缺点是不能有其它实例变量，若有，因getInstence未同步，可能出现非线程安全问题
	public static Myobject getInstence() {
		return myobject;
	}
}
