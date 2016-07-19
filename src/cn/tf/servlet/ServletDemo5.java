package cn.tf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig  config) throws ServletException {
		this.config=config;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String encoding="GBK";
		System.out.println(encoding);*/
		
		
		//获取指定参数的值
		test1();
		test2();
	}

	
	
	private void test2() {
		Enumeration<String>  paramNames=config.getInitParameterNames();
		while(paramNames.hasMoreElements()){
			String paramName=paramNames.nextElement();
			System.out.println(paramName+"="+config.getInitParameter(paramName));
		}
		
	}


	private void test1(){
		String value=config.getInitParameter("encoding");
		System.out.println(value);
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	

}
