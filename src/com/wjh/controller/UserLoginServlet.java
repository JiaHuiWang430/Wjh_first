package com.wjh.controller;

import com.wjh.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        request.setCharacterEncoding("utf-8");
        UserDao u = new UserDao();
        userName = request.getParameter("userName");
        password = request.getParameter("password");

        int a = u.login(userName,password);
        if (a==1){
            //有用户名密码，添加session至Tomcat
            HttpSession session = request.getSession();
            response.sendRedirect("/index.html");
        }else{
            response.sendRedirect("/login_error.html");
        }
    }
}
