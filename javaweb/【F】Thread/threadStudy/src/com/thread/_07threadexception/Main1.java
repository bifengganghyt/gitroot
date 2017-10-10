package com.thread._07threadexception;

import java.lang.Thread.UncaughtExceptionHandler;

public class Main1 {
	public static void main(String[] args) {
		/*Mythread mythread1 = new Mythread();
		mythread1.setName("线程t1");
		mythread1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程:" + t.getName() + "出现了异常：");
				e.printStackTrace();
			}
		});
		mythread1.start();
		
		Mythread mythread2 = new Mythread();
		mythread2.setName("线程t2");
		mythread2.start();
	}*/
		Mythread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
			}
		});
		
	}
}
