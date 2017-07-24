package sort.method;

public class SortMethod {
	
	public static void main(String[] args) {
		int[] array = new int[]{9,7,8,3,49,0,5,7,2};
		//funBubbleSort(array);
		funSelectionSort(array);
		
		for(int i=0; i< array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 1. ð�ݷ�
	 * @param array
	 */
	public static void funBubbleSort(int[] array) {
		boolean flag = true;
		for(int i=0; i < array.length-1 && flag; i++) {
			flag = false;
			
			for(int j=0; j < array.length-1-i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}
		}
	}
	
	/**
	 * ��ѡ������
	 * ˼��:����n-1��;��i��,��n-i�������ҵ���С�ģ�����λ��(i-1)��
	 * @param array
	 */
	public static void funSelectionSort(int[] array) {
		
		for(int i=0; i < array.length - 1; i++) {
			int mink = i;
			for (int j= i+1; j<array.length; j++) {
				if(array[mink] > array[j]) {
					mink = j;//�ڵ�i��ѡ��ʱ��ʹminkָ����С������Ӧ���±�
				}
			}
			
			// ����Сֵ������ǰ��
			if(mink != i) {
				int temp = array[mink];
				array[mink] = array[i];
				array[i] = temp;
			}
			
		}

	}
	
}
