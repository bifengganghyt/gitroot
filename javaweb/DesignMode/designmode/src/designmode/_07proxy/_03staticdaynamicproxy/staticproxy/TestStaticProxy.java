package designmode._07proxy._03staticdaynamicproxy.staticproxy;
/**
 * ��̬����
 */
public class TestStaticProxy {
	public static void main(String[] args) {
		new Invocation().invokeDoSomething();//��ӡ:"before..." "doSomething!" "after..."
	}
}
