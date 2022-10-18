package com.wjh.controller;

import com.wjh.Dao.QuestionDao;
import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao qd = new QuestionDao();
        Questions questions = null;
        int result = 0;
        String title,questionA,questionB,questionC,questionD,answer;
        title = request.getParameter("title");
        questionA = request.getParameter("questionA");
        questionB = request.getParameter("questionB");
        questionC = request.getParameter("questionC");
        questionD = request.getParameter("questionD");
        answer = request.getParameter("answer");
        questions = new Questions(null,title,questionA,questionB,questionC,questionD,answer);
        result = qd.add(questions);
        if (result == 1){
            request.setAttribute("info","试题添加成功！");
        }else{
            request.setAttribute("info","添加失败！！！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
