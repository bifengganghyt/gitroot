package datastructure._07string;
//�ݹ鷨
public class _857combinerecursive {
	public static void CmbineRecursiveImpl(char[]c, int begin,int len, StringBuffer sb) {
		if(len==0) {
			System.out.println(sb +" ");
			return;
		}
		
		if(begin == c.length) {
			return;
		}
		
		sb.append(c[begin]);
		CmbineRecursiveImpl(c, begin+1, len-1, sb);//(begin+1) ����������;(len-1)����=0ʱ����ӡ����
		
		sb.deleteCharAt(sb.length()-1);//ɾ�����1λ�����磬�������ʱ����֤�õ���a��ͷ���������
		CmbineRecursiveImpl(c, begin +1, len, sb);//len=�����i����֤���iλ��(begin +1)���ƽ���
	}
	
	public static void main(String[] args) {
		String s= "abc";
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer(" ");
		int len = c.length;
		for(int i=0;i<len;i++) {//i=1,���1λ��  :a,b,c
			CmbineRecursiveImpl(c, 0, i, sb);
		}
	}
}
