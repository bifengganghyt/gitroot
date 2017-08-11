package designmode._08builder;
/**
 * 建造者模式：
 * 1.创建生成器对象
 * 2.表示者使用该生成器对象构建最终产品
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可创建不同的表示
 */
public class TestBuilder {
	public static void main(String[] args) {
		ConcreteHouseBuilderA myHouseBuilder = new ConcreteHouseBuilderA();
		House myHouse = HouseDirector.createHouse(myHouseBuilder);
		System.out.println("My house has room:" + myHouse.getRoomNumber());//My house has room:3
		System.out.println("My house has door:" + myHouse.getDoorNumber());//My house has door:6
	}
}
