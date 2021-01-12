package com.dlq.java.text;

import com.dlq.java.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-12 15:37
 */
public class Dom4jText {

    @Test
    public void test() throws Exception {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    //读取books.xml文件生成Book类
    @Test
    public void test2() throws Exception {
        //1、读取books.xml文件，创建document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2、通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);//org.dom4j.tree.DefaultElement@1e6d1014 [Element: <books attributes: []/>]
        //3、通过根元素获取book标签对象
        //element() 和 elements()  都是通过标签名查找子元紊
        List<Element> books = rootElement.elements("book");
        //4、遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            Element name = book.element("name");
            //asXML()：把标签对象。转换为标签字符串
            //System.out.println(name.asXML());

            //getText()：可以获取标签中的文本内容
            String nameText = name.getText();
            //System.out.println(name.getText());

            //直接获取指定标签名的文本内容
            String price = book.elementText("price");
            String author = book.elementText("author");

            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn,nameText,Double.parseDouble(price),author));
        }
    }
}
