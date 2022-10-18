package com.wjh.controller;

import com.wjh.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao u = new UserDao();
        int result = 0;
        String userID = request.getParameter("userID");

        result = u.delete(userID);

        response.setContentType("text/html;charset=utf-8");
        if (result==1){
            response.getWriter().println("<font style='color=red;font-size:40px'>删除成功！</font>");
        }else{
            response.getWriter().println("<font style='color=red;font-size:40px'>删除成功！</font>");
        }

    }
}
