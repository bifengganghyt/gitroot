package designmode._08builder;
/**
 * Director:最终构建房屋的'表示者',对同一种构建采用不同的表示方式
 * 需给其提供'生成器'(HouseBuilder),然后由它来构建房屋
 */
public class HouseDirector {
	public static House createHouse(HouseBuilder concreteBuilder) {
		concreteBuilder.buildRoom(1);
		concreteBuilder.buildRoom(2);
		concreteBuilder.buildDoor(1, 2);
		concreteBuilder.buildDoor(2, 1);
		
		return concreteBuilder.getHouse();
	}
}
