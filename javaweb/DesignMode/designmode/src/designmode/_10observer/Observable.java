package designmode._10observer;
/**
 * ���۲��߽ӿ�
 */
public interface Observable {
	//����һ���۲���
	public void addObserver(Observer observer);
	
	//ɾ��һ���۲���
	public void deleteObserver(Observer observer);
	
	//֪ͨ�۲���
	public void notifyObserver(String context);
}
