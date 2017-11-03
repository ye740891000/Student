<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更新</title>
</head>
<body>
<table>
    <h1>更新</h1>
    <form action="Update" method="post">
        <table>
            <tr>
                <td>学生ID：</td>
                <td><input name="id" value="<%=request.getAttribute("id")  %>" readonly></td>
            </tr>

            <tr>
                <td>学生姓名：</td>
                <td><input name="name" value="<%=request.getAttribute("name")  %>" ></td>
            </tr>

            <tr>
                <td>学生密码：</td>
                <td><input type="password"  name="password" value="<%=request.getAttribute("password")  %>" ></td>
            </tr>

            <tr>
                <td>学生性别：</td>
                <td><input name ="sex" value="<%=request.getAttribute("sex")  %>"></td>
            </tr>

            <tr>
                <td>学生年龄：</td>
                <td><input  name="age" value="<%=request.getAttribute("age")  %>" ></td>
            </tr>

            <tr>
                <td >
                    <table>
                        <input type="submit" value="提交">
                        <input type="reset" value="重置">
                    </table>
                </td>
            </tr>

        </table>

    </form>
</table>
<a href="SearchList.jsp">返回</a>
</body>
</html>