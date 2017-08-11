package designmode._08builder;
/**
 * 最终需生成的产品:房屋
 */
public class House {
	int roomNumber;
	int doorNumber;
	
	public House() {
		roomNumber = 0;
		doorNumber = 0;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getDoorNumber() {
		return doorNumber;
	}
}
