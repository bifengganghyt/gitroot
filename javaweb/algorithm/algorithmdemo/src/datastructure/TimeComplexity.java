package datastructure;

public class TimeComplexity {
	
	/**
	 * f(n)=3
	 * 1.������
	 */
	public static void constantsOrder() {
		int sum = 0, n= 100;
		sum = (1 + n)*n/2;
		System.out.println("sum:" + sum);
	}
	
	/**
	 * f(n)=O(3)
	 * 2.���Խ�
	 */
	public static void lineOrder(int n) {
		for(int i=0;i<n;i++) {
			//ʱ�临�Ӷ�ΪO(1)��1����������
		}
	}
	
	/**
	 * 3.������
	 * f(n)=O(logn)
	 * 2^x>nʱ,���˳�ѭ��
	 */
	public static void logOrder(int n) {
		int count = 1;
		while (count < n) {
			count = count*2;
			//ʱ�临�Ӷ�ΪO(1)��1����������
		}
	}
	
	/**
	 * 4.ƽ����
	 * f(n)=O(n^2)
	 */
	public static void squareOrder(int n) {
		for(int i=0; i<n ;i++) {
			for(int j=0;j<n;j++) {
				//ʱ�临�Ӷ�ΪO(1)��1����������
			}
		}
	}
	
	/**
	 * f(n)=O(n^2)
	 */
	public static void squareOrder2(int n) {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				//ʱ�临�Ӷ�ΪO(1)��1����������
			}
		}
	}
	
	public static void example2(int n) {
		n++;					//ִ�д���1
		function(0, n);			//ִ�д���n
		for(int i=0; i<n;i++){	//ִ�д���n^2
			function(i, n);
		}
		
		for(int i =0; i<n;i++) {//ִ�д���n*(n+1)/2
			for(int j=i;j<n;j++) {
				//ʱ�临�Ӷ�ΪO(1)��1����������
			}
		}
	}
	
	public static void function(int i, int n) {
		for(int j=i; j<n; j++) {
			//ʱ�临�Ӷ�ΪO(1)��1����������
		}
	}
	
}
