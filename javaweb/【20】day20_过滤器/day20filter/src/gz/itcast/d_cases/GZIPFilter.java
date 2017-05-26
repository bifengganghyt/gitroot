package gz.itcast.d_cases;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
/**
 * ���ж���ҳ���ݽ���gzipѹ��
 * @heyutong
 * 2017��5��23��
 */
public class GZIPFilter implements Filter {

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1)��������
		
		//����һ��response��װ���߶���
		MyHttpResponse myResponse = new MyHttpResponse((HttpServletResponse)response);
		
		//����
		chain.doFilter(request, myResponse);
		
		//3��������Ӧ
		//�ӻ�����������õ�ѹ��ǰ������
		//ע�⣺response������û�з�����ȡʵ�����ݣ���ô�죿
		char[] content = myResponse.getCharArray();
		
		//gzipѹ��
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(buf);
		gzip.write(new String(content).getBytes());
		gzip.finish();
		byte[] result = buf.toByteArray();
		
		//����������������ݵ�ѹ����ʽ
		myResponse.setHeader("content-encoding", "gzip");
		
		//���
		response.getOutputStream().write(result);
	}
}


class MyHttpResponse extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	
	//����һ��������������
	private CharArrayWriter charArray = new CharArrayWriter();
	
	/**
	 * �ṩһ����ȡcharArray���ݵķ���(������ҳ����)
	 * @heyutong
	 * 2017��5��24��
	 * @return
	 */
	public char[] getCharArray() {
		return charArray.toCharArray();
	}
	
	public MyHttpResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}
	
	/**
	 * ��дgetWriter()���������䷵��һ�������湦�ܵ�PrintWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		//�����Ѿ�������һ����CharArrayWriter����������PrintWriter�ˣ�
		//������ǵ��ô�����PrintWriter�����write()��������ô���ݻ�ֱ��д�뵽CharrArrayWriter���������С�
		return new PrintWriter(charArray);
	}
}
