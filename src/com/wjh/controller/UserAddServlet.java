package com.wjh.controller;

import com.wjh.Dao.UserDao;
import com.wjh.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UserAddServlet extends HttpServlet {

    //是通过get的方法，传入数据的，所以用doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users;
        UserDao userDao = new UserDao();
        int result = 0;
        //从请求头来获取参数值
        String userName,password,sex,email;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //使用Dao类操作数据库
        users = new Users(null,userName,password,sex,email);
        Date start = new Date();
        result = userDao.add(users);
        Date end = new Date();
        System.out.println((end.getTime()-start.getTime())+"ms");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println();
        if (result>0){
            response.getWriter().println("<font style='color:red;font-size:40px'>用户注册成功！</font>");
        }else{
            response.getWriter().println("<font style='color:red;font-size:40px'>用户注册失败！！！</font>");
        }
    }
}
