package designmode._10observer;

import java.util.ArrayList;

/**
 * ���۲���ʵ����
 */
public class HanFeiZi implements Observable, IHanFeiZi{
	//����һ���䳤���飬������й۲���
	private ArrayList<Observer> observerList = new	ArrayList<Observer>();
	
	//���ӹ۲���
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
	
	//������Ҫ�Է���
	@Override
	public void haveBreakfast() {
		System.out.println("������:��ʼ�Է���...");
		//֪ͨ���й۲���
		this.notifyObserver("�������ڳԷ�");
	}
	
	//�����ӿ�ʼ������
	@Override
	public void haveFun() {
		System.out.println("������:��ʼ������...");
		this.notifyObserver("������������");
	}
	

}
