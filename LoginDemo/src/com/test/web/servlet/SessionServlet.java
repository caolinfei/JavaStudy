package com.test.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      /*  1. 获取HttpSession对象：
        HttpSession session = request.getSession();
        2. 使用HttpSession对象：
        Object getAttribute(String name)
        void setAttribute(String name, Object value)
        void removeAttribute(String name)*/
      //response.sendRedirect(request.getContextPath()+"/login");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
