package test;

import com.thread.www.MyThread;

public class Run {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("���н���!");//��ӡ���:���н���!   MyThread
	}
}
