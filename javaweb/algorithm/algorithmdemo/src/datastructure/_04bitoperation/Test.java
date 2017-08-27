package datastructure._04bitoperation;
/**
 * �ж�һ�����Ƿ���2��n�η�
 * 2��n�η��ɱ�ʾΪ:2^0,2^1,2^2,...2^n
 * ��1����λ�������ж���λ���ֵ��������Ƿ����
 */
public class Test {
	public static boolean isPower(int n) {
		if(n<1) {
			return false;
		}
		
		int i = 1;
		while (i<=n) {
			if(i==n) {
				return true;
			}
			
			i<<=1;
		}
		return false;
	}
	
	public static boolean isPower2(int n) {
		if(n<1) {
			return false;
		}
		
		int m = n&(n-1);
		return m==0;
	}
	
	
	public static void main(String[] args) {
		/*System.out.println(isPower2(4));//true
		System.out.println(isPower2(6));//false*/
		short a = 128;
		byte b = (byte)a;
		System.out.println(b);
		
	}
}
