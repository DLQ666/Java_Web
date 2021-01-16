package com.dlq.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //判断上传的数据是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory  工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    //循环判断，每一个表单项，是普通类型，还是上传的文件
                    if (fileItem.isFormField()) {
                        //是true就是普通表单项
                        System.out.println("获取表单name属性值：" + fileItem.getFieldName());
                        //设置参数UTF-8解决乱码
                        System.out.println("获取表单value属性值：" + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("获取表单name属性值：" + fileItem.getFieldName());
                        System.out.println("获取上传文件的文件名：" + fileItem.getName());
                        File file = new File("D:\\IDEA_workspace\\Java_Web\\JSTL\\web\\" + fileItem.getName());
                        fileItem.write(file);
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
