<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>插入新值</title>
</head>
<body>
<table >
    <h1>页面</h1>
    <form action="Insert" method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td><input name ="name"></td>
            </tr>

            <tr>
                <td>密码：</td>
                <td><input type="password" name ="password"></td>
            </tr>

            <tr>
                <td>性别：</td>
                <td><input name ="sex">
                </td>
            </tr>

            <tr>
                <td>年龄：</td>
                <td><input name ="age"></td>
            </tr>

            <tr>
                <td>
                    <table>
                        <input type="submit" value="提交">
                        <input type="reset" value="重置">
                    </table>
                </td>
            </tr>

        </table>
    </form>

</table>
<a href="SearchList.jsp">查询</a>
</body>
</html>