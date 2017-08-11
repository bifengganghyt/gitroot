package designmode._07proxy._02UserAuthority;

public class ForumClient {
	public static void main(String[] args) {
		MyForum myForum = new MyForumProxy(1);
		myForum.AddFile();//¥Ú”°"RealMyForum"
	}
}
