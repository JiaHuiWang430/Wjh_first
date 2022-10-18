package com.wjh.controller;

import com.wjh.Dao.QuestionDao;
import com.wjh.entity.Questions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * 随机出题
 */
public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List<Questions> list = dao.getRand();
        HttpSession session = request.getSession(false);    //将正确答案和题目信息放到session中，之后在Servlet可以调取session取得题目信息及其正确答案
        session.setAttribute("rand",list);
        request.getRequestDispatcher("/rand.jsp").forward(request,response);
    }
}
