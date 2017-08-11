package designmode._09strategy;
/**
 * 封装类(锦囊):承装三个策略，方便赵云使用
 * 通过构造函数把策略传递进来，然后用operate()方法执行相关策略方法
 */
public class Context {
	private IStrategy strategy;
	
	//构造函数:你要使用哪个妙计
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	//使用计谋了，看我出招了
	public void operate() {
		this.strategy.operate();
	}

}
