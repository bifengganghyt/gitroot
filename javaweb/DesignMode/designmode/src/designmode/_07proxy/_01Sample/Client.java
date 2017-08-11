package designmode._07proxy._01Sample;

public class Client {
	public static void main(String[] args) {
		Subject sub = new ProxySubject();
		sub.request();
	}
}
