package datastructure._07string;

public class _864wordsofstring {
	public static int wordCount(String str) {
		int word = 0;//��⵽Ϊ�ո���Ϊ0;��ǰ��Ϊ�ո�ǰһ�ַ�Ϊ�ո���Ϊ1
		int count = 0;
		int length = str.length();
		for(int i=0;i<length;i++) {
			if(str.charAt(i)==' ') {
				word = 0;
			} else {//��ǰ�ǿո�
				if(word==0) {//���һλΪ�ո�
					word = 1;
					count++;//��������1
				}
			}
		
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "i am a student";
		System.out.println(s);
		System.out.println("���ʸ���Ϊ:" + wordCount(s));
	}

}
