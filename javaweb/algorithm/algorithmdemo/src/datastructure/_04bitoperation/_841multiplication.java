package datastructure._04bitoperation;
/**
 * 8.4.1�������λ����ʵ�ֳ˷�����
 * a<<n�൱��a*(2^n)
 * ��ĳ����������ص㣺2��4��8...,����λ�ƴ���˷�����
 */
public class _841multiplication {
	public static int powerN(int m, int n) {
		for(int i=0;i<n;i++) {//n�Σ�ÿ������һλ
			m = m<<1;
		}
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println("3����8=" + powerN(3, 3));
		System.out.println("3����16=" +powerN(3, 4));
	}
}
