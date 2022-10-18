<%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.25
  Time: 上午 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String result = (String) request.getAttribute("info");
%>
<html>
<head>
    <title>试题添加结果</title>
</head>
<body>
    <center>
        <h1>
            <%=result%>
        </h1>
    </center>
</body>
</html>
