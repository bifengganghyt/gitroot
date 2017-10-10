package com.thread.myrunable;

public class Run {
	public static void main(String[] args) {
		MyRunable myRunable = new MyRunable();
		Thread thread = new Thread(myRunable);//Thread(Runnable target)
		thread.start();
		System.out.println("main()ÔËĞĞ½áÊø£¡");
	}
}
