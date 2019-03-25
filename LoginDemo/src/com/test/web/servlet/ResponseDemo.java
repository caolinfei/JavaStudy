package com.test.web.servlet;

import sun.util.resources.cldr.ga.CurrencyNames_ga;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo")
public class ResponseDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //字符流
        String characterEncoding = req.getCharacterEncoding();
        resp.getWriter().write("张三实打实");
    }
}
