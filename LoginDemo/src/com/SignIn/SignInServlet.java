package com.SignIn;

import com.test.unittest.JavaBeanUtilTest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@WebServlet("/signInServlet")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        //String code= parameterMap.get("check_code")[0];
//        List<SignUser>  obj=new ArrayList<>();
        SignUser user=new SignUser();
        try {
            BeanUtils.populate(user,parameterMap);
            Object check_code = request.getSession().getAttribute("check_code");
            if(check_code!=null&&check_code.equals(user.code))
            {
                //select * from student where name=? and pwd=?
                //查询不为空跳转到首页 sendRedirect
                response.sendRedirect(request.getContextPath()+"/home.jsp");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    class SignUser{

        private String name ;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        private String pwd;
    }
}
