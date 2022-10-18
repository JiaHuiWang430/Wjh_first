package com.wjh.controller;

import com.wjh.Dao.UserDao;
import com.wjh.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<Users> list = userDao.findAll();
        PrintWriter out;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border=1 align='center'");
        out.print("<tr>");
        out.println("<th>用户编号</th>");
        out.println("<th>用户姓名</th>");
        out.println("<th>用户密码</th>");
        out.println("<th>用户性别</th>");
        out.println("<th>用户邮箱</th>");
        out.println("<th>操作</th>");
        out.println("</tr>");
        for (Users u:list
             ) {
            out.print("<tr>");
            out.println("<td>"+u.getUserId()+"</td>");
            out.println("<td>"+u.getUserName()+"</td>");
            out.println("<td>******</td>");
            out.println("<td>"+u.getSex()+"</td>");
            out.println("<td>"+u.getEmail()+"</td>");
            out.println("<td><a href='/user/delete?userID="+u.getUserId()+"'>删除用户</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
