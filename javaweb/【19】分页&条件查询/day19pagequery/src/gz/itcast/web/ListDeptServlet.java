package gz.itcast.web;

import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;
import gz.itcast.service.DeptService;
import gz.itcast.util.WebUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//���������������
			request.setCharacterEncoding("utf-8");
			//�����û���ѯ���ŵ�����������Ĳ�������javabean��
			DeptQuery query = WebUtil.copyRequestToBean(request, DeptQuery.class);
		
			//1)�õ���������
			DeptService deptService = new DeptService();
			List<Department> list = deptService.findByCondition(query);
			
			//2)�洢���������
			request.setAttribute("list", list);
			//3)ת��
			request.getRequestDispatcher("/listDept.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
