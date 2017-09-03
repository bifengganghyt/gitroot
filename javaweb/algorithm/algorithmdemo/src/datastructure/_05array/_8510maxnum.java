package datastructure._05array;

public class _8510maxnum {
	//返回两数中较大值
	private static int max(int a,int b) {
		return (a>b)?a:b;
	}
	
	public static int maxnum(int a[], int begin) {
		int length = a.length - begin;
		if(length==1) {//当begin=n-1
			return a[begin];
		} else {
			return max(a[begin], maxnum(a, begin+1));
		}
	}
	
	public static void main(String[] args) {
		int[] num = {0,16,2,3,4,5,10,7,8,9};
		System.out.println(maxnum(num, 0));//16
	}
	

}
