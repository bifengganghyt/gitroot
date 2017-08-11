package designmode._08builder;

/**
 * 房屋的真正构建者:生成器的接口定义
 */
public interface HouseBuilder {
	public void buildRoom(int roomNo);
	
	public void buildDoor(int room1, int room2);
	
	public House getHouse();
}
