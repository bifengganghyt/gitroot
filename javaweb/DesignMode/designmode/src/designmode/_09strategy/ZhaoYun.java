package designmode._09strategy;
/**
 * ʹ�ü�ı
 */
public class ZhaoYun {
	//���Ƴ����ˣ�����������Ľ�����һ�β����
	public static void main(String[] args) {
		Context context;
		
		System.out.println("--�յ����ʱ���һ��--");
		context = new Context(new BackDoor());
		context.operate();
		System.out.println("\n");
		
		System.out.println("--�����ֲ�˼����,��ڶ���--");
		context = new Context(new GivenGreenLight());
		context.operate();//ִ���˵ڶ�������
		System.out.println("\n");
		
		System.out.println("---��Ȩ��С��׷���ˣ�զ�죿�������---");
		
		context = new Context(new BlockEnemy());
		context.operate();
		System.out.println("\n");
	}
}
