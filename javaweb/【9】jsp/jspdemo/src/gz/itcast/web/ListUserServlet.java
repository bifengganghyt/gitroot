package gz.itcast.web;

import gz.itcast.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1����ѯ�û�����
		List<User> list = new ArrayList<User>();
		
		list.add(new User("1","eric","123456"));
		list.add(new User("2","rose","123456"));
		list.add(new User("3","jacky","123456"));
		list.add(new User("4","lucy","123456"));
		list.add(new User("5","lily","123456"));
		
		//2)��list���ݱ��浽�����
		/**
		 * context��
		 * request�򣺱���ʹ��ת��
		 * session��
		 */
		request.setAttribute("list", list);
		
		//ת��
		request.getRequestDispatcher("/06list.jsp").forward(request, response);
		
	}
	

}
