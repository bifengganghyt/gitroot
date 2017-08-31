package datastructure._05array;

/**
 *O(n)
 */
public class _856reversearray {
	//数组逆序方法
	public static void reverse(int arr[], int start, int end) {
		for( ; start<end;start++,end--) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
		}
	}
	
	public static void shift_k(int arr[],int k) {
		int n = arr.length;
		k=k%n;//为防止k比n大，右移k位跟右移k%n为的结果一样
		reverse(arr, n-k, n-1);
		reverse(arr, 0, n-k-1);
		reverse(arr, 0, n-1);
	}
	
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8};
		shift_k(array, 2);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
