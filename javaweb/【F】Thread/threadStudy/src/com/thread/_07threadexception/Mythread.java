package com.thread._07threadexception;

public class Mythread extends Thread{

	@Override
	public void run() {
		String username = null;
		System.out.println(username.hashCode());
	}
}
