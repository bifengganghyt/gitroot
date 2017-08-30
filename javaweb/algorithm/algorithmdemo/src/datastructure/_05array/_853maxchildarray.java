package datastructure._05array;

public class _853maxchildarray {
	/**
	 * ˼��:�ҳ����������飬��ͣ�ȡ���ֵ
	 * ʱ�临�Ӷ�O(n^3)
	 * ��������鶼�ظ�������
	 * @param arr
	 * @return
	 */
	public static int maxSubArray(int arr[]) {
		int n = arr.length;
		int thisSum = 0;
		int maxSum = 0;
		//ѭ������
		for(int i=0;i<n;i++) {
			//��i��
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
	 * ����2:�ظ������Ѿ�������������
	 * ����:Sum[i,j]=Sum[i,j-1]+arr[j],��ʡȥ����Sum[i,j-1]��ʱ��
	 * ʱ�临�Ӷ�O(n^2)
	 * @param arr
	 * @return
	 */
	public static int maxSubArray2(int arr[]) {
		int size = arr.length;
		int maxSum = Integer.MIN_VALUE;
		//ѭ������
		for(int i=0;i<size;i++) {
			int thisSum = 0;
			//��i��
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
