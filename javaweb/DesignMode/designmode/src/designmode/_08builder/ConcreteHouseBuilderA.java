package designmode._08builder;

/**
 * 房屋的真正构建者:生成器的实现
 */
public class ConcreteHouseBuilderA implements HouseBuilder{
	private House house;
	
	public ConcreteHouseBuilderA() {
		house = new House();
	}

	@Override
	public void buildRoom(int roomNo) {
		house.roomNumber = house.roomNumber + roomNo;
	}

	@Override
	public void buildDoor(int room1, int room2) {
		house.doorNumber = house.doorNumber + room1 + room2;
	}

	@Override
	public House getHouse() {
		return house;
	}
}
