package com.study.date;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class DateMain {

    public static void main(String[] args) throws ParseException {

        System.out.println(new Date());

        //dateFormat
        /*
        *
        *
        * d               月中的某一天。一位数的日期没有前导零。
            dd             月中的某一天。一位数的日期有一个前导零。
  ddd           周中某天的缩写名称，在   AbbreviatedDayNames   中定义。
  dddd         周中某天的完整名称，在   DayNames   中定义。
  M               月份数字。一位数的月份没有前导零。
  MM             月份数字。一位数的月份有一个前导零。
  MMM           月份的缩写名称，在   AbbreviatedMonthNames   中定义。
  MMMM         月份的完整名称，在   MonthNames   中定义。
  y               不包含纪元的年份。不具有前导零。
  yy             不包含纪元的年份。具有前导零。
  yyyy         包括纪元的四位数的年份。
  gg             时期或纪元。
  h               12   小时制的小时。一位数的小时数没有前导零。
  hh             12   小时制的小时。一位数的小时数有前导零。
  H               24   小时制的小时。一位数的小时数没有前导零。
  HH             24
        * */

        //字符串被转换成时间的时候 格式化字符串要一直 可以比待转字符串少 不能多
      /*  DateFormat dt = new SimpleDateFormat();

        Date format = dt.parse("2019-10-23");

        System.out.println(format);*/

        //format.getYear()
        //1.1之后都使用日历类
        Calendar calendar=Calendar.getInstance();

        System.out.println(calendar.getFirstDayOfWeek()); ;
        calendar.add(Calendar.DAY_OF_WEEK,6);
        System.out.println(calendar.getTime());;

        //SimpleDateFormat
        //1非线程安全
        //2内部有一个calendar

        //解决办法 1每此使用的时候 都要去New SimpleDateFormat 2:使用 synchronized 这样会导致其他线程的blocked 阻塞 3使用ThreadLocal ThreadLocal 的延迟加载的方式 就是先声明 使用的时候去判断是否为null  为空就是new  这样只有在使用的时候才会真正的创建SimpleDateFormat

        //根本原因 是因为 SimpleDateFormat内部 有一个成员变量Calendar 对象 调用了 set()方法改变了自身的值 当多个线程同时访问的时候 就会出现错误 如挂死 日期不对 原因是多个线程共享同一个成员变量 如果改成方法内的私有变量 那么就不会有安全问题
        //参考http://www.cnblogs.com/peida/archive/2013/05/31/3070790.html
    }

    /**
     * 使用ThreadLocal定义一个全局的SimpleDateFormat
     */
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };
}
