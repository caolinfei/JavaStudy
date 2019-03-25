package com.study.xmldemo;

import cn.wanghaomiao.xpath.model.JXDocument;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class demo01 {

    /**
     * 加载进内存 解析当前xml
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

       /* String path = demo01.class.getClassLoader().getResource("student.xml").getPath();

        Document doc = Jsoup.parse(new File(path), "utf-8");

        Elements student = doc.getElementsByTag("student");
        for (Element element : student) {

            System.out.println(element.getElementsByTag("name"));
            System.out.println(element.getElementsByTag("age"));
            System.out.println(element.getElementsByTag("sex"));

            //text 获取当前标签的内容
            System.out.println( element.getElementsByTag("name").first().text());*/

        //getContentByUrlAndOther();

        testSelect();
    }


    //System.out.println(parse);


    public static void getContentByUrlAndOther() {
        try {
            //可以使用这个来做一个爬虫的程序
            Document doc = Jsoup.parse(new URL("http://www.baidu.com"), 10000);
            System.out.println(doc.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testSelect() throws IOException {
        String path = demo01.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.select("name");
        System.out.println(elements);
    }

    public static void xpathDemo() {

        //JXDocument document=new JXDocument();

    }
}
