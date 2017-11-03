package Dao;
import Bean.JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



 //操作数据库的方法
public class SqlBean {
    Connection con;
    PreparedStatement pre;
    ResultSet rs;
    public SqlBean()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


     //插入方法

     public int getInsert(String sql, JavaBean jBean)
         {
             int count =0;
             try {
                 pre = con.prepareStatement(sql);
                 pre.setString(1,jBean.getName());
                 pre.setString(2,jBean.getPassword());
                 pre.setString(3,jBean.getSex());
                 pre.setInt(4,jBean.getAge());
                 count=pre.executeUpdate();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             finally
             {
                 try {
                     pre.close();
                     con.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
             return count;
         }


     //删除方法

     public int getDelete(String sql,int id)
         {
             int count =0;
             try {
                 pre = con.prepareStatement(sql);
                 pre.setInt(1, id);
                 count=pre.executeUpdate();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             finally
             {
                 try {
                     pre.close();
                     con.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
             return count;
         }







     //id查询方法

     public JavaBean getSearchById(String sql,int id)
         {
             JavaBean jBean = new JavaBean();

             try {
                 pre = con.prepareStatement(sql);
                 pre.setInt(1, id);
                 rs=pre.executeQuery();

                 while(rs.next())
                 {
                     jBean.setId(rs.getInt("id"));
                     jBean.setName(rs.getString("name"));
                     jBean.setPassword(rs.getString("password"));
                     jBean.setSex(rs.getString("sex"));
                     jBean.setAge(rs.getInt("age"));
                 }
             } catch (SQLException e)
             {
                 e.printStackTrace();
             }
             return jBean;
         }

     //更新方法

    public int getUpdate(String sql,JavaBean jBean)
    {
        int count =0;
        try {
            pre = con.prepareStatement(sql);
            pre.setInt(5,jBean.getId());
            pre.setString(1,jBean.getName());
            pre.setString(2,jBean.getPassword());
            pre.setString(3,jBean.getSex());
            pre.setInt(4,jBean.getAge());
            count = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }




     //显示所有记录

    public List getSearch(String sql)
    {
        List list = new ArrayList();

        //获取prepareStatement对象
        try {
            pre = con.prepareStatement(sql);
            rs   =pre.executeQuery();

            while(rs.next())
            {
                JavaBean jBean =new JavaBean();
                jBean.setId(rs.getInt("id"));
                jBean.setName(rs.getString("name"));
                jBean.setPassword(rs.getString("password"));
                jBean.setSex(rs.getString("sex"));
                jBean.setAge(rs.getInt("age"));
                list.add(jBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally
        {
            try {
                pre.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
