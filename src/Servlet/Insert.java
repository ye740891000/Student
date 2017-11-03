package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.JavaBean;
import Dao.SqlBean;

public class Insert extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request,response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //防止乱码
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取前台页面数据
        String name =request.getParameter("name");
        String password =request.getParameter("password");
        String sex =request.getParameter("sex");
        String sage = request.getParameter("age");
        int age  =Integer.parseInt(sage);
        //封装到JavaBean对象中去
        JavaBean jBean = new JavaBean();
        jBean.setName(name);
        jBean.setPassword(password);
        jBean.setSex(sex);
        jBean.setAge(age);
        //调用插入方法
        String sql = "insert into student(name,password,sex,age) values(?,?,?,?)";
        SqlBean  sBean = new SqlBean();
        sBean.getInsert(sql,jBean);
        //转发
        request.getRequestDispatcher("SearchList.jsp").forward(request, response);
    }
}
