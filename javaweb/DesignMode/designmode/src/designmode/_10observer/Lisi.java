package designmode._10observer;

public class Lisi implements Observer{
	//������˹��һ���۲��ߣ�һ���������л������֪���������ϰ屨��
	@Override
	public void update(String context) {
		System.out.println("��˹���۲쵽�����ӻ����ʼ���ϰ�㱨��...");
		this.reportToQingshihuang(context);
		System.out.println("��˹:�㱨���...\n");
		
	}
	
	private void reportToQingshihuang(String reportContent) {
		System.out.println("��˹:���棬���ϰ�!�������л��-->" + reportContent);
		
	}
}
