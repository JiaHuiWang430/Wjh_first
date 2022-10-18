<%@ page import="com.wjh.entity.Questions" %><%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.25
  Time: 下午 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Questions question = (Questions) request.getAttribute("question");
%>
<html>
<head>
    <title>更新试题信息</title>
</head>
<body>
<center>
    <form action="/question/update" method="get">
        <table border="1" align="center">
            <tr>
                <td width="100px">题号：</td>
                <td ><input type="text" name="questionId" value="<%=question.getQuestionId()%>" readonly></td>
            </tr>
            <tr>
                <td>题目：</td>
                <td ><input type="text" name="title" value="<%=question.getTitle()%>"></td>
            </tr>
            <tr>
                <td>选项A：</td>
                <td ><input type="text" name="questionA" value="<%=question.getQuestionA()%>"></td>
            </tr>
            <tr>
                <td>选项B：</td>
                <td ><input type="text" name="questionB" value="<%=question.getQuestionB()%>"></td>
            </tr>
            <tr>
                <td>选项C：</td>
                <td ><input type="text" name="questionC" value="<%=question.getQuestionC()%>"></td>
            </tr>
            <tr>
                <td>选项D：</td>
                <td ><input type="text" name="questionD" value="<%=question.getQuestionD()%>"></td>
            </tr>
            <tr>
                <td>正确答案：</td>
                <td >
                    <input type="radio" name="answer" value="A">A
                    <input type="radio" name="answer" value="B">B
                    <input type="radio" name="answer" value="C">C
                    <input type="radio" name="answer" value="D">D
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交更改"></td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
