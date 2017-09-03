package datastructure._05array;

public class _857findOne {
	/**
	 * 数组中其它数都出现appearTimes次，只有某个数只出现一次
	 * @param a
	 * @param appearTimes
	 * @return
	 */
	public static int findOne(int a[], int appearTimes) {
		int n = a.length;
		//数组，bitCount[j]为，数组a中的数的二进制的j位的值的和
		int[] bitCount = new int[32];
		for(int i=0;i<n;i++) {//第几个数
			for(int j=0;j<bitCount.length;j++) {
				bitCount[j] += ((a[i]>>j)&1);
			}
		}
		
		int appearOnce=0;
		
		for(int j=0;j<32;j++) {
			if((bitCount[j]%appearTimes)!=0) {
				appearOnce += (1<<j);
			}
		}
		
		return appearOnce;
	}
	
	/**
	 * 在一个数组中，其它数都出现2次，只有一个数只出现一次
	 * @param a
	 * @return
	 */
	public static int findOneOtherTwo(int a[]) {
		int result = a[0];
		for(int i=1;i<a.length;i++) {
			//自己亦或自己为0
			//与0亦或，还是自己
			result^=a[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		//int array[] = {1,2,1,2,4,2,4,4,1,3};
		//int data = findOne(array, 3);
		
		int array[]={1,2,3,2,4,3,5,4,1};
		int data =findOneOtherTwo(array);
		System.out.println(data);
	}
}
