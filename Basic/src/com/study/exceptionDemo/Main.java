package com.study.exceptionDemo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        //Exception 使用方式
        //ExceptionMethod("123");
       // TryCatch();
        try {
            ShowMyCustomException();
        }catch (Exception e)
        {
            System.out.println(getStackTrace(e));
        }

    }

    //MyCustomException
        public static void ShowMyCustomException (){
            throw  new MyRuntimeException();
        }

    //Try Catch
    public  static  void  TryCatch()
    {
        try {
            ExceptionMethod("123");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //throw RuntimeException
    public static void  ExceptionMethod(String s)
    {
        if(s.length()>1)
        {
            throw  new ArrayIndexOutOfBoundsException();
        }

    }
    //throw IOException
    public static void read(String path) throws FileNotFoundException {
        if (!path.equals("a.txt")) {//如果不是 a.txt这个文件
// 我假设 如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常 throw
            throw new FileNotFoundException("文件不存在");
        }
    }

    //打印异常堆栈文本信息方式 第二针方式 声明一个buffer 然后再toString
    public static String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try
        {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally
        {
            pw.close();
        }
    }

}
