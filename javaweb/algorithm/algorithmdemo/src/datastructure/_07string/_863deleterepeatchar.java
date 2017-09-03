package datastructure._07string;
/**
 *8.6.3 ɾ���ַ������ظ��ַ�
 */
public class _863deleterepeatchar {
	//����1:������ :O(n^2)
	public static String removeDuplicate(String str) {
		char[] charArray = str.toCharArray();
		int len = charArray.length;
		
		//���ַ�������˫��ѭ���������緢�����ظ��ַ����ͽ����ַ���Ϊ'\0'
		for(int i=0;i<len;i++) {
			if(charArray[i] == '\0') {//�������
				continue;
			} else {
				for(int j=i+1;j<len;j++) {
					if(charArray[j]== '\0') {//�������
						continue;
					} else {
						if(charArray[i]==charArray[j]) {
							charArray[j]='\0';
						}
					}
				}
			}
		}
		
		//���ַ�����������'\0'ȥ��
		int l=0;
		for(int i=0;i<len;i++) {
			if(charArray[i]!='\0') {
				charArray[l] = charArray[i];
				l++;
			}
		}
		
		return new String(charArray, 0, l);
	}
	
	//����2:����
	//�ַ�����ת
	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		return sb.toString();
	}
	
	public static String removeDuplicateByRegix(String str) {
		str = reverse(str);//1.���ַ�����ת
		str = str.replaceAll("(?s)(.)(?=.*\\1)", "");//2.������ʽ�滻
		str = reverse(str);//3.���ַ����ٽ��з�ת
		return str;
	}
	
	public static void main(String[] args) {
		String str = "abcaabcd";
		//str = removeDuplicate(str);
		str = removeDuplicateByRegix(str);
		System.out.println(str);//abcd
	}
}
