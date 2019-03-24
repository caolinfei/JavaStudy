package com.test.web.servlet;

import com.test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/Success")
public class Success extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //像屏幕输出文字
        response.setContentType("text/html;charset=utf-8");
        Object user = request.getAttribute("user");
        if(user instanceof User)
        {
            User user1= (User)user;
            response.getWriter().write("登录成功"+user1.getUserName()+"欢饮您登录");

        }
        else {
            request.getRequestDispatcher("/Error").forward(request, response);
        }

        //response.getWriter().write("登录成功");
    }
}
