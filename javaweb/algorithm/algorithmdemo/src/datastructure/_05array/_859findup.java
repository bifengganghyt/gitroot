package datastructure._05array;

public class _859findup {
	public static int findDup(int[] a) {
		int n = a.length;
		int tmp1 = 0;
		int tmp2 = 0;
		
		for(int i=0;i<n-1;i++) {
			tmp1 += (i+1);//1+2+...+(n-2=1)
			tmp2 += a[i];//a[0]+a[1]+...a[n-2]
		}
		
		tmp2 += a[n-1];
		
		return (tmp2-tmp1);
	}
	
	/**
	 * ���
	 * @param a
	 * @return
	 */
	public static int xor_findDup(int[] a) {
		int n=a.length;
		int result = 0;
		
		for(int i=0;i<n;i++) {
			result^=a[i];//a[0]^a[1]^...a[n-1]
		}
		
		for(int i=1;i<n;i++) {
			result ^=i; //1^2^...(n-1)����(a[0]^a[1]^...a[n-1])���
		}
		return result;
	}
	
	/**
	 * �ռ任ʱ�䷨
	 * @param a
	 * @return
	 */
	public static int findInteger(int[] a) {
		int n=a.length;
		int result = Integer.MAX_VALUE;
		
		boolean[] arrayflag = new boolean[n];
		int i=1;
		while(i<n) {//arrayflag�����ʼֵ����false
			arrayflag[i]=false;
			i++;
		}
		
		for(int j=0;j<n;j++) {
			//����ֵ���±궼��1~(n-1),��ֵ�浽��Ӧ�±괦
			if(arrayflag[a[j]]==false) {
				arrayflag[a[j]]=true;
			} else {//arrayflag[a[j]]λ�����Ѿ��и�ֵ��
				result = a[j];
			}
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		int a[] = {1,2,1,3,4};
		//int result = findDup(a);
		//int result = xor_findDup(a);
		int result =findInteger(a);
		System.out.println(result);
		
	}

}
