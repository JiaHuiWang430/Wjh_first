<%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.25
  Time: 下午 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String s = (String) request.getAttribute("update");
%>
<html>
<head>
    <title>更新结果</title>
</head>
<body>
  <h1 align="center" style="color: brown"><%=s%></h1>
</body>
</html>
