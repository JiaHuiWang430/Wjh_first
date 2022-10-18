package com.wjh.controller;

import com.wjh.Dao.QuestionDao;
import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionFindOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = null;
        questionId = request.getParameter("questionId");
        Integer id = Integer.parseInt(questionId);
        QuestionDao dao = new QuestionDao();
        Questions q = dao.findOne(id);
        request.setAttribute("question",q);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }
}
