package com.test.web.servlet;

import com.test.dao.UserDao;
import com.test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        System.out.println("登录了");
        UserDao dao=new UserDao();
        User user = dao.getUser(request.getParameter("userName"), request.getParameter("pwd"));
        if(user==null)
        {
            request.setAttribute("errorMessage", "用户不存在");
            //服务器间内部跳转 相当于Server.Transfer 服务器内部跳转 浏览器地址栏不会变动
            request.getRequestDispatcher("/Error").forward(request, response);

        }
        else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/Success").forward(request, response);
        }

    }
}
