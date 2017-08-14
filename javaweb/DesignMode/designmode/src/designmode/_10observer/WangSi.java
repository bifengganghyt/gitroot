package designmode._10observer;
/**
 * 杜撰的观察者:王斯
 */
public class WangSi implements Observer{
	//王斯:看到韩非子有活动
	@Override
	public void update(String context) {
		System.out.println("王斯：观察到韩非子活动自己也开始活动了...");
		this.cry(context);
		System.out.println("王斯，哭死了...\n");
	}
	
	private void cry(String context) {
		System.out.println("王斯:因为" + context + ", -- 所以我悲伤呀!");
		
	}
}
