package search.method;


/**
 * ¶ş·Ö²éÕÒ
 * @author S43W
 *
 */
public class FunBinSearch {
	
	public static int funBinsearch(int[] array, int data) {
		
		int low = 0;
		int high = array.length -1 ;
		
		//while(array[low] < array[high]) {
		while(low <= high) {
			int mid = (low + high)/2;
			
			if(data == array[mid]) {
				return mid;
			} else if(data < array[mid]) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,4,5,7,9,11,13,16,19};
		int result = funBinsearch(array, 10);
		System.out.println("result:"+ result);
	}
}
