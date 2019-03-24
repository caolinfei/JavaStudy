package com.study.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo01")
public class servletDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
       * * GET /day14/demo1?name=zhangsan HTTP/1.1
				* 方法：
					1. 获取请求方式 ：GET
						* String getMethod()
					2. (*)获取虚拟目录：/day14
						* String getContextPath()
					3. 获取Servlet路径: /demo1
						* String getServletPath()
					4. 获取get方式请求参数：name=zhangsan
						* String getQueryString()
					5. (*)获取请求URI：/day14/demo1
						* String getRequestURI():		/day14/demo1
						* StringBuffer getRequestURL()  :http://localhost/day14/demo1

						* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
						* URI：统一资源标识符 : /day14/demo1					共和国

					6. 获取协议及版本：HTTP/1.1
						* String getProtocol()

					7. 获取客户机的IP地址：
						* String getRemoteAddr()
       *
       * */

        Enumeration<String> headerNames = req.getHeaderNames();
        String method = req.getMethod();//获取请求方法
        String contextPath = req.getContextPath();//获取虚拟目录
        String servletPath = req.getServletPath();
        final String requestURI = req.getRequestURI();
        //req

        BufferedReader body = req.getReader();
        final String s = body.readLine();
        body.readLine();

        System.out.println("helloWord");
        System.out.println("helloWordssss");
    }
}
