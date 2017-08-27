package datastructure._04bitoperation;
/**
 * 判断一个数是否是2的n次方
 * 2的n次方可表示为:2^0,2^1,2^2,...2^n
 * 用1做移位操作，判定移位后的值与给定数是否相等
 */
public class Test {
	public static boolean isPower(int n) {
		if(n<1) {
			return false;
		}
		
		int i = 1;
		while (i<=n) {
			if(i==n) {
				return true;
			}
			
			i<<=1;
		}
		return false;
	}
	
	public static boolean isPower2(int n) {
		if(n<1) {
			return false;
		}
		
		int m = n&(n-1);
		return m==0;
	}
	
	
	public static void main(String[] args) {
		/*System.out.println(isPower2(4));//true
		System.out.println(isPower2(6));//false*/
		short a = 128;
		byte b = (byte)a;
		System.out.println(b);
		
	}
}
