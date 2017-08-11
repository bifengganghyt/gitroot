package designmode._09strategy;
/**
 * ��װ��(����):��װ�������ԣ���������ʹ��
 * ͨ�����캯���Ѳ��Դ��ݽ�����Ȼ����operate()����ִ����ز��Է���
 */
public class Context {
	private IStrategy strategy;
	
	//���캯��:��Ҫʹ���ĸ����
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	//ʹ�ü�ı�ˣ����ҳ�����
	public void operate() {
		this.strategy.operate();
	}

}
