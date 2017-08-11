package designmode._07proxy._02UserAuthority;

public class RealMyForum implements MyForum{

	@Override
	public void AddFile() {
		System.out.println("RealMyForum");
	}

}
