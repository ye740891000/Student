<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示记录</title>
</head>
<body>
<table >
    <h1>查询：</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>密码</td>
            <td>性别</td>
            <td>年龄</td>
            <td><table>操作</table></td>
        </tr>

        <jsp:useBean id="sBean" class="Dao.SqlBean"/>
        <jsp:useBean id="jBean" class="Bean.JavaBean"/>
        <%
            String sql ="select * from student order by id";
            java.util.List list =sBean.getSearch(sql);

            for(java.util.Iterator it =list.iterator();it.hasNext();)
            {
                //获取一个JavaBean对象
                jBean =(Bean.JavaBean)it.next();
        %>
        <tr>
            <td><%=jBean.getId() %></td>
            <td><%=jBean.getName() %></td>
            <td><%=jBean.getPassword() %></td>
            <td><%=jBean.getSex() %></td>
            <td><%=jBean.getAge() %></td>

            <td>
                <a href="Delete?id=<%=jBean.getId()%>">删除</a>
                <a href="SearchById?id=<%=jBean.getId()%>">更新</a>
            </td>

        </tr>

        <% }%>

    </table>
</table>
<a href="Insert.jsp">返回</a>
</body>
</html>