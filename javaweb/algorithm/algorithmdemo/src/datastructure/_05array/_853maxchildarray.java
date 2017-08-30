package datastructure._05array;

public class _853maxchildarray {
	/**
	 * 思想:找出所有子数组，求和，取最大值
	 * 时间复杂度O(n^3)
	 * 许多子数组都重复计算了
	 * @param arr
	 * @return
	 */
	public static int maxSubArray(int arr[]) {
		int n = arr.length;
		int thisSum = 0;
		int maxSum = 0;
		//循环次数
		for(int i=0;i<n;i++) {
			//第i趟
			for(int j=i;j<n;j++) {
				thisSum = 0;
				for(int k=i;k<=j;k++) {
					thisSum += arr[k];
				}
				
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * 方法2:重复利用已经计算的子数组和
	 * 例如:Sum[i,j]=Sum[i,j-1]+arr[j],可省去计算Sum[i,j-1]的时间
	 * 时间复杂度O(n^2)
	 * @param arr
	 * @return
	 */
	public static int maxSubArray2(int arr[]) {
		int size = arr.length;
		int maxSum = Integer.MIN_VALUE;
		//循环次数
		for(int i=0;i<size;i++) {
			int thisSum = 0;
			//第i趟
			for(int j=i;j<size;j++) {
				thisSum += arr[j];//Sum[i,j]=Sum[i,j-1]+arr[j]
				
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,-2,4,8,-4,7,-1,-5};
		int maxSubArray = maxSubArray2(arr);
		System.out.println(maxSubArray);
	}
}
