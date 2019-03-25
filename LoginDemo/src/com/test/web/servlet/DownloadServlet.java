package com.test.web.servlet;

import com.test.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet( "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.获取请求参数，文件名称
     /*   String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        FileInputStream file=new FileInputStream(this.getServletContext().getRealPath("/img/"+filename));
        //2.1找到文件服务器路径

        //2.2用字节流关联


        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = this.getServletContext().getMimeType(filename);//根据文件名称获取文件的类型
        response.setHeader("content-type", mimeType);
        String agent = request.getHeader("user-agent");//获取文件的请求浏览器类型 来处理不同浏览器的兼容性问题

        filename = DownLoadUtils.getFileName(agent, filename);

        //3.2设置响应头打开方式:content-disposition

        response.setHeader("content-disposition","attachment;filename="+filename);
        //输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //讲输入流写入输出流
        byte[] buff=new byte[1024];//默认每次读取1M
        while (true)
        {
            int length = file.read(buff);
            if(length<=0)break;

            outputStream.write(buff,0,length);
        }

        //解决中文文件名问题
        //1.获取user-agent请求头、

        //2.使用工具类方法编码文件名即可

        //4.将输入流的数据写出到输出流中*/
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition

        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
            //在Chrome不生效
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
