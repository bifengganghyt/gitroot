package datastructure._05array;

public class _857findOne {
	/**
	 * ������������������appearTimes�Σ�ֻ��ĳ����ֻ����һ��
	 * @param a
	 * @param appearTimes
	 * @return
	 */
	public static int findOne(int a[], int appearTimes) {
		int n = a.length;
		//���飬bitCount[j]Ϊ������a�е����Ķ����Ƶ�jλ��ֵ�ĺ�
		int[] bitCount = new int[32];
		for(int i=0;i<n;i++) {//�ڼ�����
			for(int j=0;j<bitCount.length;j++) {
				bitCount[j] += ((a[i]>>j)&1);
			}
		}
		
		int appearOnce=0;
		
		for(int j=0;j<32;j++) {
			if((bitCount[j]%appearTimes)!=0) {
				appearOnce += (1<<j);
			}
		}
		
		return appearOnce;
	}
	
	/**
	 * ��һ�������У�������������2�Σ�ֻ��һ����ֻ����һ��
	 * @param a
	 * @return
	 */
	public static int findOneOtherTwo(int a[]) {
		int result = a[0];
		for(int i=1;i<a.length;i++) {
			//�Լ�����Լ�Ϊ0
			//��0��򣬻����Լ�
			result^=a[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		//int array[] = {1,2,1,2,4,2,4,4,1,3};
		//int data = findOne(array, 3);
		
		int array[]={1,2,3,2,4,3,5,4,1};
		int data =findOneOtherTwo(array);
		System.out.println(data);
	}
}
