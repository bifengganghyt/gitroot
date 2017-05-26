package gz.itcast.e_i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间国际化
 * @heyutong
 * 2017年5月26日
 */
public class Demo2 {
	public static void main(String[] args) {
		/**
		 * 参数一：日期格式.  short  medium long  full
		 * 参数二：时间格式 .  short  medium long  full
		 * 参数三：国家的locale
		 */
		//2017年5月26日 星期五 下午03时19分19秒 CST
		DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		
		//2017年5月26日 下午03时19分39秒
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
		
		//2017-5-26 15:20:02
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
		
		//17-5-26 下午3:23
		//DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.CHINA);
		
		String curDate = dateTimeInstance.format(new Date());
		System.out.println(curDate);
		
	}

}
