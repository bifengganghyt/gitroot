package datastructure._04bitoperation;
/**
 * ���������1�ĸ���
 * 1.�ж�����������һλ�Ƿ�Ϊ1����Ϊ1����������1
 * 2.ͨ�����ƶ��������һλ
 * 3.ͨ��ѭ��ִ�иò���ֱ�������Ϊ0
 * ʱ�临�Ӷ�:O(n)
 */
public class _843numberof1 {
	public static int countOne(int n){
		int num = 0;//��������
		while (n>0) {
			if((n&1)==1) {//�ж����һλ�Ƿ�Ϊ1
				num++;
			}
			n>>=1;//��λ
		}
		return num;
	}
	
	/**
	 * ����2:ÿ����һ��n&(n-1)���㣬�����������һλ1���������1λ��
	 * ʱ�临�Ӷ�:o(m),mΪ��������1�ĸ���
	 */
	public static int countOne2(int n) {
		int num = 0;//����
		while(n>0) {
			if(n!=0) {//�ж����һλ�Ƿ�Ϊ1
				n=n&(n-1);
				num++;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(countOne2(7));
		System.out.println(countOne2(8));
	}
}
