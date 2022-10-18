package com.wjh.Dao;

import com.wjh.entity.Users;
import com.wjh.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection conn = JdbcUtil.getConn();
    PreparedStatement ps = null;

    //添加用户信息
    public int add(Users users){
        int result = 0;
        try {
            ps = conn.prepareStatement("insert into users (userName,password,sex,email) values (?,?,?,?)");
            ps.setObject(1,users.getUserName());
            ps.setObject(2,users.getPassword());
            ps.setObject(3,users.getSex());
            ps.setObject(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(conn,ps);
        }
        return result;
    }

    //查询用户信息
    public List findAll(){
        List<Users> list = new ArrayList<>();
        Users users = null;    //将读取的数据写入到users
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from users");
            rs = ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                users = new Users(userId,userName,password,sex,email);
                list.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(rs,conn,ps);
        }
        return list;
    }

    //删除用户信息
    public int delete(String i){
        int result = 0;
        try {
            ps = conn.prepareStatement("delete from users where userID=?");
            ps.setObject(1,Integer.parseInt(i));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(conn,ps);
        }
        return result;
    }

    //查询login
    public int login(String name,String pwd){
        int result = 0;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from users where userName=? and password=?");
            ps.setObject(1,name);
            ps.setObject(2,pwd);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(rs,conn,ps);
        }
        return result;
    }
}
