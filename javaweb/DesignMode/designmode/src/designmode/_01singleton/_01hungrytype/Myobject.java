package designmode._01singleton._01hungrytype;

/**
 * ��������/����ʽ:
 * ʹ����ʱ�ѽ����󴴽���ϣ������÷���ǰ��ʵ���ѱ�����
 */
public class Myobject {
	private static Myobject myobject = new Myobject();
	
	private Myobject() {
	}
	
	//�˰汾ȱ���ǲ���������ʵ�����������У���getInstenceδͬ�������ܳ��ַ��̰߳�ȫ����
	public static Myobject getInstence() {
		return myobject;
	}
}
