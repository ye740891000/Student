package Servlet;


             import java.io.IOException;
             import javax.servlet.ServletException;
             import javax.servlet.http.HttpServlet;
             import javax.servlet.http.HttpServletRequest;
             import javax.servlet.http.HttpServletResponse;
             import Bean.JavaBean;
             import Dao.SqlBean;

public class SearchById extends HttpServlet {


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

        //获取用户ID
        String sid = request.getParameter("id");
        int      id  =Integer.parseInt(sid);
        //调用id查询方法
        String sql ="select * from student where id=?";
        SqlBean  sBean = new SqlBean();
        JavaBean jBean = sBean.getSearchById(sql, id);

        request.setAttribute("id",jBean.getId());
        request.setAttribute("name",jBean.getName());
        request.setAttribute("password",jBean.getPassword());
        request.setAttribute("sex",jBean.getSex());
        request.setAttribute("age",jBean.getAge());

        //转发
        request.getRequestDispatcher("Update.jsp").forward(request, response);
    }
}
