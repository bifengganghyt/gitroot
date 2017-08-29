package datastructure._04bitoperation;
/**
 * 求二进制中1的个数
 * 1.判断这个数的最后一位是否为1，如为1，计数器加1
 * 2.通过右移丢弃掉最后一位
 * 3.通过循环执行该操作直到这个数为0
 * 时间复杂度:O(n)
 */
public class _843numberof1 {
	public static int countOne(int n){
		int num = 0;//用来计数
		while (n>0) {
			if((n&1)==1) {//判断最后一位是否为1
				num++;
			}
			n>>=1;//移位
		}
		return num;
	}
	
	/**
	 * 方法2:每进行一次n&(n-1)计算，结果都会少了一位1，且是最后1位。
	 * 时间复杂度:o(m),m为二进制中1的个数
	 */
	public static int countOne2(int n) {
		int num = 0;//计数
		while(n>0) {
			if(n!=0) {//判断最后一位是否为1
				n=n&(n-1);
				num++;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(countOne2(7));
		System.out.println(countOne2(8));
	}
}
