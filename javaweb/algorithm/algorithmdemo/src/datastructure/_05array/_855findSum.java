package datastructure._05array;

import java.util.Arrays;
/**|
 * 求数组中两两相加等于20的组合种数
 */
public class _855findSum {
	//O(n^2)
	public static void findSum2(int[] arr, int sum) {
		int size = arr.length;
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if((arr[i] + arr[j])==sum) {
					System.out.println("和为" + sum + "的数对为:" + arr[i] + "与" + arr[j]);
				}
			}
		}
	}
	
	//总:O(n)
	public static void findSum(int[] arr, int sum) {
		//基本类型:快速排序，对象类型:归并排序。O(nlogn)
		Arrays.sort(arr);
		
		//O(n)
		int size = arr.length;
		int begin = 0;
		int end = size-1;
		while (begin < end) {
			if(arr[begin] + arr[end] < sum) {//两个数一定在[begin+1,end]间
				begin++;
			} else if(arr[begin] + arr[end] > sum) {//两个数一定在[begin,end-1]间
				end--;
			} else {
				System.out.println("和为" + sum + "的数对为:" + arr[begin] + "与" + arr[end]);
				begin++;
				end--;
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,7,17,2,6,3,14};
		int sum = 20;
		findSum2(arr, sum);
	}

}
