package datastructure._05array;
/**
 * 1.����maxNumber�洢���������,��ʼֵΪdata[0]
 * ����secNumber�洢����ڶ�����,��ʼֵΪInteger.MIN_VALUE=-2^31
 * 2.��������
 * ��data[i]>maxNumber����secNumber=maxNumber��maxNumber=data[i];
 * ����,�ж�data[i]��secNumber��С����data[i]>secNumber�������secNumber=data[i]
 */
public class _852secondofarray {
	public static int findSecMax(int data[]) {
		int count = data.length;
		int maxNumber = data[0];
		int secNumber = Integer.MIN_VALUE;
		
		for(int i=1;i<count;i++) {
			if(data[i]>maxNumber) {
				secNumber=maxNumber;
				maxNumber=data[i];
			} else {
				if(data[i]>secNumber) {
					secNumber=data[i];
				}
			}
		}
		
		return secNumber;
	}
	
	public static void main(String[] args) {
		int data[] = {10,10,20,3,5,78,9,60,59};
		int findSecMax = findSecMax(data);
		System.err.println(findSecMax);
	}
}
