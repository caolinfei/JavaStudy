package com.test.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Cookie[] cookies = request.getCookies();
        Cookie ck=new Cookie("cookie","123");



        ck.setPath("/");//指定在哪个虚拟目录下可以访问
        //<CookieProcessor className="org.apache.tomcat.util.http.LegacyCookieProcessor"/>
        //tomcat 8之后新的校验规范 所以要添加这个包
        ck.setDomain(".baidu.com");//指定访问域 一般都是一级目录
        response.addCookie(ck);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
