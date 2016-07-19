package cn.tf.servletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test1(request,response);
		test2(request,response);
		test3(request,response);
		test4(request,response);
		test5(request,response);
		test6(request,response);
		test7(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	//ResourceBundle只适合读取properties文件，只能读取类路径中的配置文件
	//WEB-INF/class或者jar中的文件
	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResourceBundle rb=ResourceBundle.getBundle("b");
		System.out.println(rb.getString("key"));
		
	}
	
	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResourceBundle rb=ResourceBundle.getBundle("cn.tf.servletContext.c");
		System.out.println(rb.getString("key"));
		
	}
	
	
	//ServletContext:String getRealPath(String path)
	//获取到文件的真实路径，只适合javaweb应用，能够读取其任何位置的任意文件。
	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc=getServletContext();
		String path=sc.getRealPath("/WEB-INF/a.properties");
		System.out.println(path);
		
		Properties prop=new Properties();
		prop.load(new FileInputStream(path));
		System.out.println(prop.getProperty("key"));
		
	}
	
	private void test4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc=getServletContext();
		String path=sc.getRealPath("/WEB-INF/classes/b.properties");
		System.out.println(path);
		
		Properties prop=new Properties();
		prop.load(new FileInputStream(path));
		System.out.println(prop.getProperty("key"));
		
	}
	
	
	//用类加载器,
	private void test5(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassLoader cl=Demo5.class.getClassLoader();
		InputStream is=cl.getResourceAsStream("b.properties");
		
		Properties prop=new Properties();
		prop.load(is);
		System.out.println(prop.getProperty("key"));
		
	}
	
	private void test6(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassLoader cl=Demo5.class.getClassLoader();
		InputStream is=cl.getResourceAsStream("cn/tf/servletContext/c.properties");
		
		Properties prop=new Properties();
		prop.load(is);
		System.out.println(prop.getProperty("key"));
		
	}
	
	
	private void test7(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassLoader cl=Demo5.class.getClassLoader();
		URL url=cl.getResource("cn/tf/servletContext/c.properties");
		String path=url.getPath();
		System.out.println(path);
		
		Properties prop=new Properties();
		prop.load(new FileInputStream(path));
		System.out.println(prop.getProperty("key"));
		
	}
	

}
