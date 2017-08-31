package datastructure._05array;

import java.util.Arrays;
/**|
 * ��������������ӵ���20���������
 */
public class _855findSum {
	//O(n^2)
	public static void findSum2(int[] arr, int sum) {
		int size = arr.length;
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if((arr[i] + arr[j])==sum) {
					System.out.println("��Ϊ" + sum + "������Ϊ:" + arr[i] + "��" + arr[j]);
				}
			}
		}
	}
	
	//��:O(n)
	public static void findSum(int[] arr, int sum) {
		//��������:�������򣬶�������:�鲢����O(nlogn)
		Arrays.sort(arr);
		
		//O(n)
		int size = arr.length;
		int begin = 0;
		int end = size-1;
		while (begin < end) {
			if(arr[begin] + arr[end] < sum) {//������һ����[begin+1,end]��
				begin++;
			} else if(arr[begin] + arr[end] > sum) {//������һ����[begin,end-1]��
				end--;
			} else {
				System.out.println("��Ϊ" + sum + "������Ϊ:" + arr[begin] + "��" + arr[end]);
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
