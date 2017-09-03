package datastructure._07string;
/**
 *8.6.3 删除字符串中重复字符
 */
public class _863deleterepeatchar {
	//方法1:蛮力法 :O(n^2)
	public static String removeDuplicate(String str) {
		char[] charArray = str.toCharArray();
		int len = charArray.length;
		
		//对字符数组用双重循环遍历，如发现有重复字符，就将该字符置为'\0'
		for(int i=0;i<len;i++) {
			if(charArray[i] == '\0') {//条件检查
				continue;
			} else {
				for(int j=i+1;j<len;j++) {
					if(charArray[j]== '\0') {//条件检查
						continue;
					} else {
						if(charArray[i]==charArray[j]) {
							charArray[j]='\0';
						}
					}
				}
			}
		}
		
		//将字符数组中所有'\0'去掉
		int l=0;
		for(int i=0;i<len;i++) {
			if(charArray[i]!='\0') {
				charArray[l] = charArray[i];
				l++;
			}
		}
		
		return new String(charArray, 0, l);
	}
	
	//方法2:正则法
	//字符串反转
	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		return sb.toString();
	}
	
	public static String removeDuplicateByRegix(String str) {
		str = reverse(str);//1.对字符串反转
		str = str.replaceAll("(?s)(.)(?=.*\\1)", "");//2.正则表达式替换
		str = reverse(str);//3.对字符串再进行反转
		return str;
	}
	
	public static void main(String[] args) {
		String str = "abcaabcd";
		//str = removeDuplicate(str);
		str = removeDuplicateByRegix(str);
		System.out.println(str);//abcd
	}
}
