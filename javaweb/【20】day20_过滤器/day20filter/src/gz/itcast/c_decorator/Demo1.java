package gz.itcast.c_decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * װ����ģʽ
 * @heyutong
 * 2017��5��23��
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new FileReader("e:/news.txt"));
		//��BufferedReader����װ��
		BufferedReader br = new MyBufferedReader(b);
		String str = null;
				
		while( (str = br.readLine())!=null){
			System.out.println(str);
		}
	}
}
	
	/**
	 * ���죺 ��ÿ������ǰ�����һ����š�
	 * ��������� ϣ��readLine�������ظ����ǵľ���һ������ŵ����ݡ���BufferedReader��readLine����������ǿ�����ǾͿ����õ�װ����ģʽ��
	 * 	  װ����ģʽ�Ŀ������裺
	 * 		  ��� װ����  �� ��װ����  .   BufferedReader���Ǳ�װ����
	 * 			1)��дһ��BufferedReaderװ�����࣬�̳б�װ�����ࡣ(������final��)
	 *          2����װ�����ж���һ����Ա���������ڽ��ձ�װ������Ķ���
	 *          3����װ������Ĺ��췽���д��뱻װ�����࣬ʹ�õڶ�������ı������ձ�ת��� ��װ�����ࡣ	
	 * 			4����װ����������д��װ�����෽�������䷽��������ǿ��
	 */
	
	/**
	 * 1)��дһ��BufferedReaderװ�����࣬�̳б�װ�����ࡣ(������final��) 
     * BufferedReader(�Ƿ�final��)
	 * @heyutong
	 * 2017��5��23��
	 */
	class MyBufferedReader extends BufferedReader {
		//2����װ�����ж���һ����Ա���������ڽ��ձ�װ������Ķ���
		private BufferedReader bufferedReader;
		
		/**
		 * 3����װ������Ĺ��췽���д��뱻װ�����࣬ʹ�õڶ�������ı������ձ�ת��� ��װ�����ࡣ
		 * @heyutong
		 * 2017��5��23��
		 * @param in
		 */
		public MyBufferedReader(Reader in) {
			super(in);
			this.bufferedReader = (BufferedReader)in;
		}
		
		int count = 1;
		
		/*
		 * 4����װ����������д��װ�����෽�������䷽��������ǿ��
		 */
		@Override
		public String readLine() throws IOException {
			//�õ�ԭ������ʵ������
			String content = bufferedReader.readLine();
			//��ǿ: �������
			if(content!=null) {
				content = count + ":" +content;
				count++;
			}
			return content;
		}
	}

