package datastructure._05array;

public class MaxMinOfArray {
	static int min;
	static int max;
	
	public static void GetMaxAndMin(int arr[]) {
		max = arr[0];
		min = arr[0];
		
		for(int i=1; i<arr.length-1; i++) {
			//forѭ�� i ��max min �Ƚϣ�����µ�max min 
			//����ȥ�ô���
			/*if(i+1>arr.length) {
				if(arr[i]>max) {
					max=arr[i];
				} 
				if(arr[i]<min) {
					min = arr[i];
				}
			}*/
			
			//i< i+1 i��min�� i+1��max��
			if(arr[i]>arr[i+1]) {
				if(arr[i]>max) {
					max= arr[i];
				}
				if(arr[i+1]<min) {
					min = arr[i+1];
				}
			}
			
			//i> i+1 i��max�� i+1��min��
			if(arr[i]<arr[i+1]) {
				if(arr[i+1]>max) {
					max= arr[i+1];
				}
				if(arr[i]<min) {
					min = arr[i];
				}
			}
		}
		
		System.out.println("min:" + min);
		System.out.println("max:" + max);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,4,6,8,800,200};
		MaxMinOfArray.GetMaxAndMin(arr);
	}
}
