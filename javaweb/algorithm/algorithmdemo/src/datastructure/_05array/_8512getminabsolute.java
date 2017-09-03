package datastructure._05array;


/**
 *升序数组，可能有正数、负数、0，求绝对值最小的数 
 *
 */
public class _8512getminabsolute {
	
	public static int getminAbsoluteValue(int arr[]) {
		if(arr==null) {
			return Integer.MIN_VALUE;
		}
		
		int n = arr.length;
		//情况1:arr[0]>=0(全部正数，升序排列),则为arr[0]
		if(arr[0] >= 0) {
			return arr[0];
		}
		
		//情况2:arr[n-1]<0,(全部负数，升序排列),则为arr[n-1]
		if(arr[n-1] < 0) {
			return arr[n-1];
		}
		
		/**
		 *情况3:有正有负，找正负数分界点
		 *方法1:顺序遍历数组,找到第一个非负数   O(n)
		 *方法2:二分法
		 *(1)a[mid]=0, 为a[mid]
		 *(2)a[mid]>0 1)a[mid-1]<0,比较a[mid]与a[mid-1]绝对值
		 *            2)a[mid-1]=0,为a[mid-1]
		 *            3)a[mid-1]>0,在数组左半部分继续查找 end=mid-1
		 *(3)a[mid]<0 1)a[mid+1]<0,在数组右半部分继续查找 begin=mid+1
		 *            2)a[mid+1]=0,为a[mid+1]
		 *            3)a[mid+1]>0,比较a[mid]与a[mid+1]绝对值
		 */
		int mid = 0;
		int begin = 0;
		int end = n-1;
		
		while(true) {
			mid = (begin + end)/2;
			if(arr[mid]==0) {
				return arr[mid];
			} else if (arr[mid]>0) {
				if(arr[mid-1]<0) {//比较a[mid]与a[mid-1]绝对值
					if(Math.abs(arr[mid]) <= Math.abs(arr[mid-1]) ) {
						return arr[mid];
					} else {
						return arr[mid-1];
					}
				} else if(arr[mid-1]==0) {
					return arr[mid-1];
				} else {
					end = mid -1;//(2)3)
				}
			} else {//arr[mid]<0
				if(arr[mid+1] < 0) {
					begin = mid +1;
				} else if(arr[mid+1] == 0) {
					return arr[mid+1];
				} else {//比较a[mid]与a[mid+1]绝对值
					if(Math.abs(arr[mid]) <= Math.abs(arr[mid+1])) {
						return arr[mid];
					} else {
						return arr[mid+1];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr1[] = {-10,-5,-2,7,15,50};
		int arr2[] = {2,4,6,8,27};
		int arr3[] = {-13,-9,-7,-3};
		System.out.println(getminAbsoluteValue(arr1));
		System.out.println(getminAbsoluteValue(arr2));
		System.out.println(getminAbsoluteValue(arr3));
	}

}
