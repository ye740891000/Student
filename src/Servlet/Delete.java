package Servlet;

import Dao.SqlBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class Delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            doPost(request,response);
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  防止乱码
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取用户ID
        String sid = request.getParameter("id");
        int  id  =Integer.parseInt(sid);
        //调用删除方法
        String sql = "delete from student where id=?";
        SqlBean  sBean = new SqlBean();
        sBean.getDelete(sql, id);

        //转发
        request.getRequestDispatcher("SearchList.jsp").forward(request, response);
    }
}
