package designmode._10observer;

public class Liusi implements Observer {
	
	//��˹:�۲쵽�����ӻ���Լ�Ҳ����һЩ��
	@Override
	public void update(String context) {
		System.out.println("��˹���۲쵽�����ӻ����ʼ������...");
		this.happy(context);
		System.out.println("��˹:������...\n");
	}
	
	//һ�����������б仯�����Ϳ���
	private void happy(String context) {
		System.out.println("��˹:��Ϊ" + context + ",--�����ҿ���ѽ!");
	}
}
