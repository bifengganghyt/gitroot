package designmode._10observer;
/**
 * 场景类
 */
public class Client {
	public static void main(String[] args) {
		//三个观察者产生出来
		Observer lisi = new Lisi();
		Observer wangSi = new WangSi();
		Observer liusi = new Liusi();
		
		//定义出韩非子
		HanFeiZi hanFeiZi = new HanFeiZi();
		
		//后人根据历史，描述该场景，有三人在观察韩非子
		hanFeiZi.addObserver(lisi);
		hanFeiZi.addObserver(wangSi);
		hanFeiZi.addObserver(liusi);
		
		//韩非子动作：吃早餐
		hanFeiZi.haveBreakfast();
	}

}
