package datastructure._05array;

import java.util.concurrent.atomic.AtomicInteger;

public class _8511getmaxdiff {
	//����1:������
	public static int getMax(int arr[]) {
		if(arr==null) {
			return Integer.MIN_VALUE;
		}
		int n = arr.length;
		if(n<=1) {
			return Integer.MIN_VALUE;
		}
		
		int maxdiff = Integer.MIN_VALUE;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if((arr[i]-arr[j])>maxdiff) {
					maxdiff=arr[i]-arr[j];
				}
			}
		}
		
		return maxdiff;
	}
	
	//���ַ�
	public static int getMaxBybisection(int arr[]) {
		if(arr==null) {
			return Integer.MIN_VALUE;
		}
		
		int len = arr.length;
		if(len <=1) {
			return Integer.MIN_VALUE;
		}
		
		AtomicInteger max = new AtomicInteger(0);
		AtomicInteger min = new AtomicInteger(0);
		
		return getMaxDiff(arr, 0, len-1, max, min);
		
	}
	
	public static int getMaxDiff(int arr[],int begin,int end,AtomicInteger max, AtomicInteger min)  {
		if(begin == end) {
			max.set(arr[begin]);
			min.set(arr[begin]);
			return Integer.MIN_VALUE;
		}
		
		int middle=(begin+end)/2;
		
		//������벿�ֵ���Сֵ�����ֵ
		AtomicInteger lMax = new AtomicInteger(0);
		AtomicInteger lMin = new AtomicInteger(0);
		int leftMax=getMaxDiff(arr, begin, middle, lMax, lMin);
		
		//�����Ұ벿�ֵ���Сֵ�����ֵ
		AtomicInteger rMax = new AtomicInteger(0);
		AtomicInteger rMin = new AtomicInteger(0);
		int rightMax= getMaxDiff(arr, middle+1, end, rMax, rMin);
		
		//���������:
		int mixMax = lMax.get()-rMin.get();
		
		//������������Сֵ
		if(lMax.get()>rMax.get()) {
			max.set(lMax.get());
		} else {
			max.set(rMax.get());
		}
		
		if(lMin.get()<rMin.get()) {
			min.set(lMin.get());
		} else {
			min.set(rMin.get());
		}
		
		//�����ֵ
		int allMax = (leftMax>rightMax)?leftMax:rightMax;
		allMax= (allMax>mixMax)?allMax:mixMax;
		return allMax;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,4,17,3,2,9};
		System.out.println(getMaxBybisection(arr));//15
	}

}
