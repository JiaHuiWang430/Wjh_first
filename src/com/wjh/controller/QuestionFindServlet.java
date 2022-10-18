package com.wjh.controller;

import com.wjh.Dao.QuestionDao;
import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao qd = new QuestionDao();
        List<Questions> list = qd.findAll();
        //直接将list放到请求作用域对象中
        request.setAttribute("questions",list);
        request.getRequestDispatcher("/find.jsp").forward(request,response);
    }
}
