<%@ page import="com.wjh.entity.Questions" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: WangJh
  Date: 22.9.26
  Time: 下午 5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Questions> list = (List<Questions>) session.getAttribute("rand");

%>
<html>
<head>
    <title>试卷</title>
</head>
<body>
  <center>
      <form action="/question/range" method="get">
          <%for (int i = 0;i<4;i++
          ) {
              Questions q = list.get(i);
          %>
      <table>
          <tr>
              <td>
                  <%=i+1%>.
              </td>
              <td>
                  <%=q.getTitle()%>
              </td>
          </tr>
          <tr>
              <td>
                  A.
              </td>
              <td>
                  <%=q.getQuestionA()%>
              </td>
          </tr>
          <tr>
              <td>
                  B.
              </td>
              <td>
                  <%=q.getQuestionB()%>
              </td>
          </tr>
          <tr>
              <td>
                  C.
              </td>
              <td>
                  <%=q.getQuestionC()%>
              </td>
          </tr>
          <tr>
              <td>
                  D.
              </td>
              <td>
                  <%=q.getQuestionD()%>
              </td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="radio" name="answer_<%=q.getQuestionId()%>" value="A">A
                  <input type="radio" name="answer_<%=q.getQuestionId()%>" value="B">B
                  <input type="radio" name="answer_<%=q.getQuestionId()%>" value="C">C
                  <input type="radio" name="answer_<%=q.getQuestionId()%>" value="D">D
              </td>
          </tr>
          <br><br>
      </table>
          <%
          }
          %>
          <br>
            <input type="submit" value="提交试卷">
      </form>
  </center>
</body>
</html>
