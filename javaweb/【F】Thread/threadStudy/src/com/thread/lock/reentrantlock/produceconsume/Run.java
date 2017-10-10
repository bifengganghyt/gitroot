package com.thread.lock.reentrantlock.produceconsume;

public class Run {
	public static void main(String[] args) {
		Myservice myservice = new Myservice();
		MyThreadA[] threadAs= new MyThreadA[10];
		MyThreadB[] threadBs= new MyThreadB[10];
		for(int i=0;i<10;i++) {
			threadAs[i] = new MyThreadA(myservice);
			threadBs[i] = new MyThreadB(myservice);
			threadAs[i].start();
			threadBs[i].start();
		}
	}
}
