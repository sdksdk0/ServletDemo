package cn.tf.servletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//文件下载
public class Demo6 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到要下载的文件的真实路径
		ServletContext sc=getServletContext();
		
		String path=sc.getRealPath("/WEB-INF/1.jpg");
		
		InputStream in=new FileInputStream(path);
		
		//告知浏览器去下载
		response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
		response.setHeader("Content-Type", "application/octet-stream");
		
		
		OutputStream out=response.getOutputStream();
		int len =-1;
		byte b[] =new byte[1024];
		
		while((len=in.read(b))!=-1){
			out.write(b,0,len);
		}
		in.close();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
