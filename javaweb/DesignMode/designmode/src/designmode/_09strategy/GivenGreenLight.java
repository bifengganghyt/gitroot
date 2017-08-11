package designmode._09strategy;

public class GivenGreenLight implements IStrategy{

	@Override
	public void operate() {
		System.out.println("求吴国老太开绿灯，放行！");
	}
}
