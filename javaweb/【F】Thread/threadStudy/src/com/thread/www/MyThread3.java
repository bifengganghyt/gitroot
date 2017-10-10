package com.thread.www;

public class MyThread3 extends Thread{
	private int count = 5;
	public MyThread3(String name) {
		super();
		this.setName(name);//设置线程名称
	}
	@Override
	public void run() {
		super.run();
		while(count > 0) {
			count--;
			System.out.println("由" + this.currentThread().getName() + "计算，count=" + count );
		}
	}
	
	

}
