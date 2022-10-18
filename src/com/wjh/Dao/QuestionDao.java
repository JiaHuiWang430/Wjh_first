package com.wjh.Dao;

import com.wjh.entity.Questions;
import com.wjh.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    Connection conn = JdbcUtil.getConn();
    PreparedStatement ps = null;

    public int add(Questions question){
        int result = 0;
        try {
            ps = conn.prepareStatement("insert into question (title,optionA,optionB,optionC,optionD,answer) values (?,?,?,?,?,?)");
            ps.setObject(1,question.getTitle());
            ps.setObject(2,question.getQuestionA());
            ps.setObject(3,question.getQuestionB());
            ps.setObject(4,question.getQuestionC());
            ps.setObject(5,question.getQuestionD());
            ps.setObject(6,question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,ps);
        }
        return result;
    }

    public List<Questions> findAll(){
        ResultSet rs = null;
        Questions questions = null;
        List<Questions> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from question ");
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                questions = new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(questions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(rs,conn,ps);
        }
        return list;
    }

    public Questions findOne(Integer id){
        ResultSet rs = null;
        Questions q = null;
        try {
            ps = conn.prepareStatement("select * from question where questionId=?");
            ps.setObject(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                q = new Questions(id,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(rs,conn,ps);
        }
        return q;
    }

    public int delete(Integer id){
        int result = 0;
        try {
            ps = conn.prepareStatement("delete from question where questionId=?");
            ps.setObject(1,id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,ps);
        }
        return result;
    }

    public int update(Questions question){
        int result = 0;
        try {
            ps = conn.prepareStatement("update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?");
            ps.setObject(1,question.getTitle());
            ps.setObject(2,question.getQuestionA());
            ps.setObject(3,question.getQuestionB());
            ps.setObject(4,question.getQuestionC());
            ps.setObject(5,question.getQuestionD());
            ps.setObject(6,question.getAnswer());
            ps.setObject(7,question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,ps);
        }
        return result;
    }

    public List getRand(){
        ResultSet rs = null;
        Questions questions = null;
        List<Questions> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from question order by rand() limit 0,4");
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                questions = new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(questions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(rs,conn,ps);
        }
        return  list;
    }
}
