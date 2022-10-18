package com.wjh.controller;

import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionRangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Questions> list = (List<Questions>) session.getAttribute("rand");
        int count = 0;
        for (Questions q: list
             ) {
            Integer questionId = q.getQuestionId();
            String answer = q.getAnswer();
            String aa = request.getParameter("answer_"+q.getQuestionId());
            if (aa.equals(answer)){
                count+=25;
            }
        }
        request.setAttribute("grade",count);
        request.getRequestDispatcher("/grade.jsp").forward(request,response);
    }
}
