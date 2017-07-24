package sort.method;
//快速排序
//http://www.cnblogs.com/hexiaochun/archive/2012/09/03/2668324.html
//http://www.cnblogs.com/coderising/p/5708801.html
public class QuickSort {
		
	    //核心代码
		/**
		 * a[0]为基准点key(与第一个lo重合),lo-起始,hi-末尾
		 * 从后半部分开始，发现有元素比key(第一个lo)小,就交换hi与lo对应的值(大的换到右边)
		 * 接着从前半部分开始扫描(lo<key时,lo指针右移)，发现有元素大于key的值(始终是开始那个6)，就交换lo和hi的值
		 * 直到lo>=hi,就把基准点放在hi的位置，一次排序完成
		 * 以后采用递归分别对前半部分和后半部分排序
		 * @param arrays
		 * @param start
		 * @param end
		 */
	    public void _quick_sort(int[] arrays, int start, int end) {
	        if(start>=end){
	            return;
	        }
	        
	        int i = start;
	        int j = end;
	        int value = arrays[i];//基准点
	        boolean flag = true;
	        while (i != j) {//直到i=j，完成第一次排序
	            if (flag) {
	                if (value > arrays[j]) {//右边的hi值小于key时，交换lo和hi
	                    swap(arrays, i, j);
	                    flag=false;//交换值后，结束循环，转向左部分的判断
	                } else {
	                    j--;//右边的hi值大于key时，hi指针左移
	                }
	            }else{
	                if(value<arrays[i]){
	                    swap(arrays, i, j);
	                    flag=true;
	                }else{
	                    i++;
	                }
	            }
	        }
	        //此时,i=j,左右部分分别递归
	        _quick_sort(arrays, start, j-1);
	        _quick_sort(arrays, i+1, end);
	    }
	    
	    //交换
	    private void swap(int[] arrays, int i, int j) {
	        int temp = arrays[i];
	        arrays[i] = arrays[j];
	        arrays[j] = temp;
	    }

	    public static void main(String args[]) {
	       QuickSort q = new QuickSort();
	        int[] a = { 49, 38, 65,12,45,5};
	        q.quick_sort(a,6);
	        snp(a);
	    } 
	    
	  //判空
	    public void quick_sort(int[] arrays, int lenght) {
	        if (null == arrays || lenght < 1) {
	            return;
	        }
	        _quick_sort(arrays, 0, lenght - 1);
	    }
	    
	    //打印数组
	    public static void snp(int[] arrays) {
	        for (int i = 0; i < arrays.length; i++) {
	            System.out.print(arrays[i] + " ");
	        }
	    }
	}
