package datastructure;

public class TimeComplexity {
	
	/**
	 * f(n)=3
	 * 1.常数阶
	 */
	public static void constantsOrder() {
		int sum = 0, n= 100;
		sum = (1 + n)*n/2;
		System.out.println("sum:" + sum);
	}
	
	/**
	 * f(n)=O(3)
	 * 2.线性阶
	 */
	public static void lineOrder(int n) {
		for(int i=0;i<n;i++) {
			//时间复杂度为O(1)的1程序步骤序列
		}
	}
	
	/**
	 * 3.对数阶
	 * f(n)=O(logn)
	 * 2^x>n时,会退出循环
	 */
	public static void logOrder(int n) {
		int count = 1;
		while (count < n) {
			count = count*2;
			//时间复杂度为O(1)的1程序步骤序列
		}
	}
	
	/**
	 * 4.平方阶
	 * f(n)=O(n^2)
	 */
	public static void squareOrder(int n) {
		for(int i=0; i<n ;i++) {
			for(int j=0;j<n;j++) {
				//时间复杂度为O(1)的1程序步骤序列
			}
		}
	}
	
	/**
	 * f(n)=O(n^2)
	 */
	public static void squareOrder2(int n) {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				//时间复杂度为O(1)的1程序步骤序列
			}
		}
	}
	
	public static void example2(int n) {
		n++;					//执行次数1
		function(0, n);			//执行次数n
		for(int i=0; i<n;i++){	//执行次数n^2
			function(i, n);
		}
		
		for(int i =0; i<n;i++) {//执行次数n*(n+1)/2
			for(int j=i;j<n;j++) {
				//时间复杂度为O(1)的1程序步骤序列
			}
		}
	}
	
	public static void function(int i, int n) {
		for(int j=i; j<n; j++) {
			//时间复杂度为O(1)的1程序步骤序列
		}
	}
	
}
