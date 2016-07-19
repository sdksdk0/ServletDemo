package cn.tf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 implements Servlet {

	public ServletDemo2(){
		System.out.println("调用了servletDemo2的构造方法");	
	}
	
	//初始化
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("调用了init方法");
	}

	//获取servlet配置的方法
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	//返回作者，版权等信息
	@Override
	public String getServletInfo() {
		return null;
	}
	//服务器方法
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("执行了service方法");
	}
	//销毁方法
	@Override
	public void destroy() {
		System.out.println("服务器被销毁");
	}

}
