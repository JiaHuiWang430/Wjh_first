package com.wjh.controller;

import com.wjh.Dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.valueOf(request.getParameter("questionId"));
        QuestionDao qd = new QuestionDao();
        int result = 0;
        result = qd.delete(questionId);
        if (result == 1){
            request.setAttribute("delete","试题删除成功！！！");
        }else {
            request.setAttribute("delete","删除失败！");
        }
        request.getRequestDispatcher("/question_delete.jsp").forward(request,response);
    }
}
