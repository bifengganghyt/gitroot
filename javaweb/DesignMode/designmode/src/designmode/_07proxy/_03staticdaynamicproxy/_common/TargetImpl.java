package designmode._07proxy._03staticdaynamicproxy._common;


public class TargetImpl implements Target1,Target2{
	
	@Override
	public void doSomething() {
		System.out.println("doSomething!");
	}
	
	@Override
	public String dol(String msg) {
		System.out.println("dol:" + msg);
		return "this is String Method!";
	}

	@Override
	public int do2() {
		System.out.println("do2!");
		return 1000;
	}

	

}
