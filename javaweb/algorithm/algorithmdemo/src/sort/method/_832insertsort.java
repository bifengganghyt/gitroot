package sort.method;
//直接插入排序
public class _832insertsort {
	public static void insertSort(int[] a) {
		//从a[1]开始,n-1趟
		for(int i=1;i<a.length;i++) {
			//temp = a[i];j=i
			int temp = a[i];
			int j= i;
			//若temp>a[j-1],不需变化，进入下一趟
			if(temp<a[j-1]) {
				while (j>0 && temp < a[j-1]) {//否则,a[j-1]后移一位。temp继续与a[j-2]比..
					a[j] = a[j-1];
					j--;
				}
			}
			
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,19,40,4,7,1};
		insertSort(array);
		for(int i =0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

}
