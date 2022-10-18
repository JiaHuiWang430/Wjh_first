<%@ page import="java.util.List" %>
<%@ page import="com.wjh.entity.Questions" %>
<%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.25
  Time: 下午 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Questions> list = (List<Questions>) request.getAttribute("questions");
%>
    <center>
        <table border="1" style="font-family: 幼圆;background-color: lavender">
            <tr>
                <th>编号</th>
                <th>题目</th>
                <th>选项A</th>
                <th>选项B</th>
                <th>选项C</th>
                <th>选项D</th>
                <th>正确答案</th>
                <th colspan="2">操作</th>
            </tr>
            <%
                for (Questions q:list
                ) {
            %>
            <tr>
                <td><%=q.getQuestionId()%></td>
                <td><%=q.getTitle()%></td>
                <td><%=q.getQuestionA()%></td>
                <td><%=q.getQuestionB()%></td>
                <td><%=q.getQuestionC()%></td>
                <td><%=q.getQuestionD()%></td>
                <td><%=q.getAnswer()%></td>
                <td>
                    <a href="/question/delete?questionId=<%=q.getQuestionId()%>">删除试题</a>
                    <a href="/question/findOne?questionId=<%=q.getQuestionId()%>">更新试题</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </center>