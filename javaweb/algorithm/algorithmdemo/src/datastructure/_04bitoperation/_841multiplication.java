package datastructure._04bitoperation;
/**
 * 8.4.1如何用移位操作实现乘法运算
 * a<<n相当于a*(2^n)
 * 当某数字满足该特点：2、4、8...,可用位移代替乘法操作
 */
public class _841multiplication {
	public static int powerN(int m, int n) {
		for(int i=0;i<n;i++) {//n次，每次左移一位
			m = m<<1;
		}
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println("3乘以8=" + powerN(3, 3));
		System.out.println("3乘以16=" +powerN(3, 4));
	}
}
