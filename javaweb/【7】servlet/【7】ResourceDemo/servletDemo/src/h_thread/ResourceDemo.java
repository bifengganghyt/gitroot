package h_thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017年4月25日
 */
public class ResourceDemo  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //复习： 读取Properties文件？
		/**
		 * 相对路径：当前路径相对于java命令运行的目录
		 * 结论：在web项目中，java命令运行的目录就是在tomcat的bin目录。在web项目，不能使用相对路径
		 */
		/**
		FileInputStream in = new FileInputStream("./src/news.properties");
		//1)使用Properteis对象
		Properties prop = new Properties();
		//2)使用load方法加载properties文件
		prop.load(in);
		//3)通过getProperty（）获取内容
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("password"));
		*/

		// 1)getRealPath()  获取资源文件的真实路径
		@SuppressWarnings("unused")
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/news.properties");
		//System.out.println(path);
		//FileInputStream in = new FileInputStream(new File(path));
		
		//2)getResource() 获取资源文件的URL
		URL url = this.getServletContext().getResource("/WEB-INF/classes/news.properties");
		
		//3)getResourceAsStream() 获取资源文件的输入流
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/news.properties");
		//1)使用Properteis对象
		Properties prop = new Properties();
		//2)使用load方法加载properties文件
		prop.load(in);
		//3)通过getProperty（）获取内容
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("password"));
	}
}
