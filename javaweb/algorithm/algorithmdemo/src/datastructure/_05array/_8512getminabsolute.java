package datastructure._05array;


/**
 *�������飬������������������0�������ֵ��С���� 
 *
 */
public class _8512getminabsolute {
	
	public static int getminAbsoluteValue(int arr[]) {
		if(arr==null) {
			return Integer.MIN_VALUE;
		}
		
		int n = arr.length;
		//���1:arr[0]>=0(ȫ����������������),��Ϊarr[0]
		if(arr[0] >= 0) {
			return arr[0];
		}
		
		//���2:arr[n-1]<0,(ȫ����������������),��Ϊarr[n-1]
		if(arr[n-1] < 0) {
			return arr[n-1];
		}
		
		/**
		 *���3:�����и������������ֽ��
		 *����1:˳���������,�ҵ���һ���Ǹ���   O(n)
		 *����2:���ַ�
		 *(1)a[mid]=0, Ϊa[mid]
		 *(2)a[mid]>0 1)a[mid-1]<0,�Ƚ�a[mid]��a[mid-1]����ֵ
		 *            2)a[mid-1]=0,Ϊa[mid-1]
		 *            3)a[mid-1]>0,��������벿�ּ������� end=mid-1
		 *(3)a[mid]<0 1)a[mid+1]<0,�������Ұ벿�ּ������� begin=mid+1
		 *            2)a[mid+1]=0,Ϊa[mid+1]
		 *            3)a[mid+1]>0,�Ƚ�a[mid]��a[mid+1]����ֵ
		 */
		int mid = 0;
		int begin = 0;
		int end = n-1;
		
		while(true) {
			mid = (begin + end)/2;
			if(arr[mid]==0) {
				return arr[mid];
			} else if (arr[mid]>0) {
				if(arr[mid-1]<0) {//�Ƚ�a[mid]��a[mid-1]����ֵ
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
				} else {//�Ƚ�a[mid]��a[mid+1]����ֵ
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
