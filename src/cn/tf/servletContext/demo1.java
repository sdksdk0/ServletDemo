package cn.tf.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//获取servletContext的对象引用
public class demo1 extends HttpServlet {

	private ServletConfig config;
	@Override
	public void init(ServletConfig  config) throws ServletException {
		this.config=config;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc=config.getServletContext();
		sc.setAttribute("a", "demo1");
		
		
		
		//获取全局参数
		sc.getInitParameter("encoding");
		
		System.out.println("demo1:"+sc);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
