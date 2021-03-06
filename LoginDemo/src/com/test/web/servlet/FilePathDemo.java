package com.test.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/FilePathDemo")
public class FilePathDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        String realPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");

        String path = FilePathDemo.class.getClassLoader().getResource("/a.txt").getPath();
        System.out.println(realPath);

        System.out.println(path);

    }
}
