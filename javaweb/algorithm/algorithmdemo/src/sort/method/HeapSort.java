package sort.method;

/**
 * ������
 *
 */
public class HeapSort {
	
	//������
    public static int[] heapSort(int[] array){
        array = buildMaxHeap(array); //��ʼ���ѣ�array[0]Ϊ��һ��ֵ����Ԫ��
        for(int i=array.length-1;i>=1;i--){  
            int temp = array[0];  //���Ѷ�Ԫ�غͶѵ�Ԫ�ؽ��������õ���ǰ���Ԫ����ȷ������λ��
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0,i);  //������ʣ���Ԫ������ɶ�
        }
        return array;
    }
    
  //��������ѣ���array������ȫ��������˳��洢�ṹ
    private static int[] buildMaxHeap(int[] array){
        //�����һ���ڵ�array.length-1�ĸ��ڵ㣨array.length-1-1��/2��ʼ��ֱ�����ڵ�0������������
        for(int i=(array.length-2)/2;i>=0;i--){ 
            adjustDownToUp(array, i,array.length);
        }
        return array;
    }
    
    //��Ԫ��array[k]���������𲽵������νṹ
    private static void adjustDownToUp(int[] array,int k,int length){
        int temp = array[k];   
        for(int i=2*k+1; i<=length-1; i=2*i+1){    //iΪ��ʼ��Ϊ�ڵ�k�����ӣ��ؽڵ�ϴ���ӽڵ����µ���
            if(i+1<length && array[i]<array[i+1]){  //ȡ�ڵ�ϴ���ӽڵ���±�
                i++;   //����ڵ���Һ���>���ӣ���ȡ�Һ��ӽڵ���±�
            }
            if(temp>=array[i]){  //���ڵ� >=������Ů�йؼ��ֽϴ��ߣ���������
                break;
            }else{   //���ڵ� <������Ů�йؼ��ֽϴ���
                array[k] = array[i];  //�������ӽ���нϴ�ֵarray[i]������˫�׽ڵ���
                k = i; //���ؼ����޸�kֵ���Ա�������µ���
            }
        }
        array[k] = temp;  //�������Ľ���ֵ��������λ��
    }
    
    //http://www.cnblogs.com/CherishFX/p/4643940.html#3661395
    public static void main(String[] args) {
    	int[] a = {14,12,15,13,11,16};
        printArray("����ǰ��",a);
        heapSort(a);
        printArray("�����",a);
		
	}
    
    private static void printArray(String pre,int[] a) {
        System.out.print(pre+"\n");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");    
        System.out.println();
    }
}
