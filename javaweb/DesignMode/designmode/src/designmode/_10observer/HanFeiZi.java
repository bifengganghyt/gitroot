package designmode._10observer;

import java.util.ArrayList;

/**
 * 被观察者实现类
 */
public class HanFeiZi implements Observable, IHanFeiZi{
	//定义一个变长数组，存放所有观察者
	private ArrayList<Observer> observerList = new	ArrayList<Observer>();
	
	//增加观察者
	@Override
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);		
	}

	@Override
	public void notifyObserver(String context) {
		for(Observer observer : observerList) {
			observer.update(context);
		}
	}
	
	//韩非子要吃饭了
	@Override
	public void haveBreakfast() {
		System.out.println("韩非子:开始吃饭了...");
		//通知所有观察者
		this.notifyObserver("韩非子在吃饭");
	}
	
	//韩非子开始娱乐了
	@Override
	public void haveFun() {
		System.out.println("韩非子:开始娱乐了...");
		this.notifyObserver("韩非子在娱乐");
	}
	

}
