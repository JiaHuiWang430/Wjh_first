<%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.25
  Time: 下午 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String result = (String) request.getAttribute("delete");
%>
<html>
<head>
    <title>删除试题</title>
</head>
<body>
    <h1 align="center" style="color: brown;background-color: khaki"><%=result%></h1>
</body>
</html>
