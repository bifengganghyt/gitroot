package datastructure._07string;

public class _864wordsofstring {
	public static int wordCount(String str) {
		int word = 0;//检测到为空格，置为0;当前不为空格，前一字符为空格，置为1
		int count = 0;
		int length = str.length();
		for(int i=0;i<length;i++) {
			if(str.charAt(i)==' ') {
				word = 0;
			} else {//当前非空格
				if(word==0) {//左边一位为空格
					word = 1;
					count++;//单词数加1
				}
			}
		
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "i am a student";
		System.out.println(s);
		System.out.println("单词个数为:" + wordCount(s));
	}

}
