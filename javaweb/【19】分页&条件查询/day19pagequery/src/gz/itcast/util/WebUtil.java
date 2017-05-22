package gz.itcast.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static <T> T copyRequestToBean(HttpServletRequest request,Class<T> clazz){
		/**
		 * ��request�����еĲ����������װ��javabean��Contact��������
		 */
		//1)�õ�request�����в���
		/**
		 * <key,value>
		 * 		<�������ƣ�String[]> 
		 */
		try {
			Map map = request.getParameterMap();
			//�������
			T t = clazz.newInstance();
			//Լ��ǰ�᣺ �������ƺ�javabean���������Ʊ���һ�£�������
			BeanUtils.copyProperties(t, map);
			return t;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		
	}
}
