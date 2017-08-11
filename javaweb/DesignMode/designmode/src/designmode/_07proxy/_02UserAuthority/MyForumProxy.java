package designmode._07proxy._02UserAuthority;

public class MyForumProxy implements MyForum{
	private RealMyForum forum;
	
	//Ȩ��ֵ
	private  int permission;
	
	public MyForumProxy(int permission) {
		this.permission = permission;
		forum = new RealMyForum();
	}

	@Override
	public void AddFile() {
		if(this.permission == 1 ) {
			forum.AddFile();
		} else {
			System.out.println("You are not a associator of MyForum");
		}
	}
}
