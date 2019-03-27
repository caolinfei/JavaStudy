package com.crud.web;

import com.crud.dao.QueryResult;
import com.crud.domian.PageBean;
import com.crud.domian.Person;
import com.crud.domian.PersonQuery;
import com.crud.service.PersonService;
import com.crud.service.PersonServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@WebServlet( "/indexServlet")
public class IndexServlet extends HttpServlet {
    
    private PersonService personService=new PersonServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*List<Person> list = personService.getList();
        request.setAttribute("person",list);*//**//*
        request.getRequestDispatcher("/list.jsp").forward(request,response);*/

        PersonQuery query=new PersonQuery();

        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(query, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        QueryResult<Person> personQueryResult = personService.queryResult(query);
        //PageBean<Person>personPageBean=new PageBean<>();
        request.setAttribute("person",personQueryResult.getList());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
