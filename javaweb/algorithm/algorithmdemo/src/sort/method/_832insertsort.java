package sort.method;
//ֱ�Ӳ�������
public class _832insertsort {
	public static void insertSort(int[] a) {
		//��a[1]��ʼ,n-1��
		for(int i=1;i<a.length;i++) {
			//temp = a[i];j=i
			int temp = a[i];
			int j= i;
			//��temp>a[j-1],����仯��������һ��
			if(temp<a[j-1]) {
				while (j>0 && temp < a[j-1]) {//����,a[j-1]����һλ��temp������a[j-2]��..
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
