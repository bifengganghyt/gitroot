package designmode._10observer;
/**
 * ��׫�Ĺ۲���:��˹
 */
public class WangSi implements Observer{
	//��˹:�����������л
	@Override
	public void update(String context) {
		System.out.println("��˹���۲쵽�����ӻ�Լ�Ҳ��ʼ���...");
		this.cry(context);
		System.out.println("��˹��������...\n");
	}
	
	private void cry(String context) {
		System.out.println("��˹:��Ϊ" + context + ", -- �����ұ���ѽ!");
		
	}
}
