package gz.itcast.e_i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ����ʱ����ʻ�
 * @heyutong
 * 2017��5��26��
 */
public class Demo2 {
	public static void main(String[] args) {
		/**
		 * ����һ�����ڸ�ʽ.  short  medium long  full
		 * ��������ʱ���ʽ .  short  medium long  full
		 * �����������ҵ�locale
		 */
		//2017��5��26�� ������ ����03ʱ19��19�� CST
		DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		
		//2017��5��26�� ����03ʱ19��39��
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
		
		//2017-5-26 15:20:02
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		
		//17-5-26 ����3:23
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.CHINA);
		
		String curDate = dateTimeInstance.format(new Date());
		System.out.println(curDate);
		
	}

}
