package gz.itcast.a_url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestURLEncoder {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//URLEncoder�ࣺURL�ļ�����
		String str = "����";
				
		str = URLEncoder.encode(str, "utf-8");  
		System.out.println(str); //%E4%BD%95%E5%AE%87                    
				
		//URLDecoder�ࣺURL�Ľ���
		str = URLDecoder.decode(str, "gbk");//何宇	
		System.out.println(str);
		
		/*str = URLEncoder.encode(str, "gbk");  
		System.out.println(str); //%E4%BD%95%E5%AE%87  
			
		str = URLDecoder.decode(str, "utf-8");//����
		System.out.println(str);*/	
	}
}
