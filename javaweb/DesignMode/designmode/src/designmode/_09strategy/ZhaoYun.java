package designmode._09strategy;
/**
 * 使用计谋
 */
public class ZhaoYun {
	//赵云出场了，根据诸葛亮的交代，一次拆开妙计
	public static void main(String[] args) {
		Context context;
		
		System.out.println("--刚到吴国时拆第一个--");
		context = new Context(new BackDoor());
		context.operate();
		System.out.println("\n");
		
		System.out.println("--刘备乐不思蜀了,拆第二个--");
		context = new Context(new GivenGreenLight());
		context.operate();//执行了第二个锦囊
		System.out.println("\n");
		
		System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
		
		context = new Context(new BlockEnemy());
		context.operate();
		System.out.println("\n");
	}
}
