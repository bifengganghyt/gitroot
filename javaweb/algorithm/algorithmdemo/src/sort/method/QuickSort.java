package sort.method;
//��������
//http://www.cnblogs.com/hexiaochun/archive/2012/09/03/2668324.html
//http://www.cnblogs.com/coderising/p/5708801.html
public class QuickSort {
		
	    //���Ĵ���
		/**
		 * a[0]Ϊ��׼��key(���һ��lo�غ�),lo-��ʼ,hi-ĩβ
		 * �Ӻ�벿�ֿ�ʼ��������Ԫ�ر�key(��һ��lo)С,�ͽ���hi��lo��Ӧ��ֵ(��Ļ����ұ�)
		 * ���Ŵ�ǰ�벿�ֿ�ʼɨ��(lo<keyʱ,loָ������)��������Ԫ�ش���key��ֵ(ʼ���ǿ�ʼ�Ǹ�6)���ͽ���lo��hi��ֵ
		 * ֱ��lo>=hi,�Ͱѻ�׼�����hi��λ�ã�һ���������
		 * �Ժ���õݹ�ֱ��ǰ�벿�ֺͺ�벿������
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
	        int value = arrays[i];//��׼��
	        boolean flag = true;
	        while (i != j) {//ֱ��i=j����ɵ�һ������
	            if (flag) {
	                if (value > arrays[j]) {//�ұߵ�hiֵС��keyʱ������lo��hi
	                    swap(arrays, i, j);
	                    flag=false;//����ֵ�󣬽���ѭ����ת���󲿷ֵ��ж�
	                } else {
	                    j--;//�ұߵ�hiֵ����keyʱ��hiָ������
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
	        //��ʱ,i=j,���Ҳ��ֱַ�ݹ�
	        _quick_sort(arrays, start, j-1);
	        _quick_sort(arrays, i+1, end);
	    }
	    
	    //����
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
	    
	  //�п�
	    public void quick_sort(int[] arrays, int lenght) {
	        if (null == arrays || lenght < 1) {
	            return;
	        }
	        _quick_sort(arrays, 0, lenght - 1);
	    }
	    
	    //��ӡ����
	    public static void snp(int[] arrays) {
	        for (int i = 0; i < arrays.length; i++) {
	            System.out.print(arrays[i] + " ");
	        }
	    }
	}
