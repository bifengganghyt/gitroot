package designmode._08builder;
/**
 * ������ģʽ��
 * 1.��������������
 * 2.��ʾ��ʹ�ø����������󹹽����ղ�Ʒ
 * ��һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹ��ͬ���Ĺ������̿ɴ�����ͬ�ı�ʾ
 */
public class TestBuilder {
	public static void main(String[] args) {
		ConcreteHouseBuilderA myHouseBuilder = new ConcreteHouseBuilderA();
		House myHouse = HouseDirector.createHouse(myHouseBuilder);
		System.out.println("My house has room:" + myHouse.getRoomNumber());//My house has room:3
		System.out.println("My house has door:" + myHouse.getDoorNumber());//My house has door:6
	}
}
