package datastructure._07string;
//递归法
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
		CmbineRecursiveImpl(c, begin+1, len-1, sb);//(begin+1) 遍历数组了;(len-1)控制=0时，打印数据
		
		sb.deleteCharAt(sb.length()-1);//删除最后1位，比如，输出梁文时，保证得到以a开头的所有情况
		CmbineRecursiveImpl(c, begin +1, len, sb);//len=传入的i，保证输出i位，(begin +1)控制结束
	}
	
	public static void main(String[] args) {
		String s= "abc";
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer(" ");
		int len = c.length;
		for(int i=0;i<len;i++) {//i=1,输出1位的  :a,b,c
			CmbineRecursiveImpl(c, 0, i, sb);
		}
	}
}
