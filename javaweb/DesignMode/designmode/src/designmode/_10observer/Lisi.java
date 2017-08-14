package designmode._10observer;

public class Lisi implements Observer{
	//首先李斯是一个观察者，一旦韩非子有活动，他就知道，就向老板报告
	@Override
	public void update(String context) {
		System.out.println("李斯：观察到韩非子活动，开始向老板汇报了...");
		this.reportToQingshihuang(context);
		System.out.println("李斯:汇报完毕...\n");
		
	}
	
	private void reportToQingshihuang(String reportContent) {
		System.out.println("李斯:报告，秦老板!韩非子有活动了-->" + reportContent);
		
	}
}
