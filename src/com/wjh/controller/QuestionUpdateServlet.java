package com.wjh.controller;

import com.wjh.Dao.QuestionDao;
import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId;
        String title,questionA,questionB,questionC,questionD,answer;
        questionId = Integer.valueOf(request.getParameter("questionId"));
        title = request.getParameter("title");
        questionA = request.getParameter("questionA");
        questionB = request.getParameter("questionB");
        questionC = request.getParameter("questionC");
        questionD = request.getParameter("questionD");
        answer = request.getParameter("answer");
        Questions question = new Questions(questionId,title,questionA,questionB,questionC,questionD,answer);
        QuestionDao dao = new QuestionDao();
        int result = 0;
        result = dao.update(question);
        if (result==1){
            request.setAttribute("update","更新成功！！！");
        }else{
            request.setAttribute("update","更新失败！！！");
        }
        request.getRequestDispatcher("/q_updateResult.jsp").forward(request,response);
    }
}
