package datastructure._05array;
/**
 * 1.变量maxNumber存储数组最大数,初始值为data[0]
 * 变量secNumber存储数组第二大数,初始值为Integer.MIN_VALUE=-2^31
 * 2.遍历数组
 * 如data[i]>maxNumber，则secNumber=maxNumber，maxNumber=data[i];
 * 否则,判断data[i]与secNumber大小，如data[i]>secNumber，则更新secNumber=data[i]
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
