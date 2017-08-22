package designmode._01singleton._01hungrytype;

public class Test {
	public static void main(String[] args) {
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();
		t1.start();
		t2.start();
		t3.start();
	}
}
