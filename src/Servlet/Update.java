package Servlet;

               import Bean.JavaBean;
               import Dao.SqlBean;
               import java.io.IOException;
               import javax.servlet.ServletException;
               import javax.servlet.http.HttpServlet;
               import javax.servlet.http.HttpServletRequest;
               import javax.servlet.http.HttpServletResponse;
public class Update extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //防止乱码
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        //获取前台表单
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String sage = request.getParameter("age");
        int age = Integer.parseInt(sage);
        //封装到JavaBean对象中去
        JavaBean jBean = new JavaBean();
        jBean.setId(id);
        jBean.setName(name);
        jBean.setPassword(password);
        jBean.setSex(sex);
        jBean.setAge(age);
        //调用更新方法
        String sql = "update student set name=?,password=?,sex=?,age=? where id=?";
        SqlBean sBean = new SqlBean();
        sBean.getUpdate(sql, jBean);

        //转发
        request.getRequestDispatcher("SearchList.jsp").forward(request, response);
    }

}
